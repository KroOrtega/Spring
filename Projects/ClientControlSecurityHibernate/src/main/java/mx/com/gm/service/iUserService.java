package mx.com.gm.service;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.iUserDao;
import mx.com.gm.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//unmutable service bean name per default
@Service("userDetailsService")
@Slf4j
public class iUserService implements UserDetailsService {

    //Inject User DAO class
    @Autowired
    private iUserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Create user instance from our domain class
        mx.com.gm.domain.User user = userDao.findByUsername(username);

        //Handle empty user case
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        
        //Retrieve roles associated to user
        //need to wrap roles in GrantedAuthority type to manage roles with Spring
        var roles = new ArrayList<GrantedAuthority>();
        
        //iterate user list to get roles list (attribute defined in User class)
        for(Role role : user.getRoles()){
            //Fill roles list with the role name wrapped in SimpleGrantedAuthority type
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }
        
        //Return interface UserDetails object from Spring security library
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
            
    }

}
