package mx.com.gm.dao;

import mx.com.gm.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iUserDao extends JpaRepository<User, Long> {
    
    User findByUsername(String username);
    
}
