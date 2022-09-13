package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

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
    private String name;
    private String lastname;
    private String email;
    private String phone;
    
}
