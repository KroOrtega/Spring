package mx.com.gm.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Data
@Table(name="users")
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    
    //Map PK
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    
    //Map attributes
    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;

    //Map relationship between User and Role class
    @OneToMany
    //Indicate Foreign Key column
    @JoinColumn(name = "id_user")
    private List<Role> roles;
}
