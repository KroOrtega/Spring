//Service Implementation
package mx.com.gm.service;

import java.util.List;
import mx.com.gm.dao.iPersonDao;
import mx.com.gm.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements iPersonService{

    @Autowired
    private iPersonDao personDao;
    
    @Override
    //able to rollback and/or commit
    @Transactional
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> listPeople() {
        //findAll() returns Object type, so cast it
        return (List<Person>) personDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public void find(Person person) {
        //findById() returns Optional<Object>, 
        //give it an alternative for null output
        personDao.findById(person.getIdPerson()).orElse(null);
    }

    @Override
    //able to rollback and/or commit
    @Transactional
    public void delete(Person person) {
        personDao.delete(person);
    }
    
}
