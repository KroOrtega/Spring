package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

//@Entity for each table entity
@Entity
//@Data to generate boilerplate code
@Data
//State the name of the table
@Table(name="roles")
//implement Serializable interface for object tx
public class Role implements Serializable{
    private static final long serialVersionUID = 1L;
    
    //Set PK properties
    @Id
    //Use Entity ID to map PK since our key is Auto-Incrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    
    //Map attributes
    @NotEmpty
    private String name;
    //Not using this attribute on this class
    //The relationship will be established via User Entity
    //private int idUser;
}
