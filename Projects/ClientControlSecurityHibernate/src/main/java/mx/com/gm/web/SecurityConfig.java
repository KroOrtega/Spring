package mx.com.gm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    //inject user details service
    @Autowired
    private UserDetailsService userDetailsService;
    
    //inject encrypter
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    //This will force spring to look for an Auth Manager Builder - predefined in SpringSecurity factory
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Override
    //Restrict application URLs
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //Restrict requests to following paths and their subpaths (/**) :
                .antMatchers("/add/**", "/update/**", "/delete")
                //To only users:
                    .hasRole("ADMIN")
                .antMatchers("/")
                    .hasAnyRole("USER","ADMIN")
                .and()
                    //Remove default login page and call ours
                    .formLogin()
                    .loginPage("/login")
                .and()
                    //Handle Exceptions
                    .exceptionHandling().accessDeniedPage("/errors/403")
                ;
    }
    
}
