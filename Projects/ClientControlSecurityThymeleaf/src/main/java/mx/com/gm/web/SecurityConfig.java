package mx.com.gm.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    //deactivate default user: user and configure new ones
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //create dummy users in memory
        auth.inMemoryAuthentication()
                .withUser("admin")
                    //Specify not to encrypt password
                    .password("{noop}123")
                    .roles("ADMIN","USER")
                .and()
                .withUser("user")
                    .password("{noop}123")
                    .roles("USER")
                ;
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
