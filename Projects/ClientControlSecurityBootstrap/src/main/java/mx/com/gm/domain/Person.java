package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

//Use lombok to create boilerplate code (getter/setter)
@Data
//Turn our domain class into an Entity
@Entity
//Define exact table name to avoid errors
@Table(name = "person")
public class Person implements Serializable{
   
    private static final long serialVersionUID = 1L;
    //Set class attributes as private for Beans
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;
    //Not validated yet
    private String phone;
    //Declare every String attribute as not empty
    @NotEmpty
    private String name;
    @NotEmpty
    private String lastname;
    @NotEmpty
    @Email
    private String email;  
    @NotNull
    private double balance;
    
}
