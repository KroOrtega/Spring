//Interface
package mx.com.gm.service;

import java.util.List;
import mx.com.gm.domain.Person;

public interface iPersonService {
    
    //Methods to be implemented
    //Create
    public void save(Person person);
    //Read
    public List<Person> listPeople();
    //Read
    public void find(Person person);
    //Delete
    public void delete(Person person);
    //Read and return
    public Person findPerson(Person person);
    
}
