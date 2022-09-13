package mx.com.gm.domain;

import lombok.Data;

//Use lombok to create boilerplate code (getter/setter)
@Data
public class Person {
    //Set class attributes as private for Beans
    private String name;
    private String lastName;
    private String email;
    private String phone;
    

    
    
}
