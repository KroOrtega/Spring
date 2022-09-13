//interfaces are named starting with an "i"
package mx.com.gm.dao;

import mx.com.gm.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface iPersonDao extends CrudRepository<Person, Long>{
    
}
