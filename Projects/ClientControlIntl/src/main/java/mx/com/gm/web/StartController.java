package mx.com.gm.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Person;
import mx.com.gm.service.iPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class StartController {
    
    //Inject DAO Class into Controller
    //@Autowired
    //private iPersonDao personDao;
    
    //Inject Service Layer Interface
    @Autowired
    private iPersonService personService;
    
    //View redirect method GET
    @GetMapping("/")
    //Add Model as a parameter to send info to view
    public String start(Model model){
        //Make use of Service interface methods
        var people = personService.listPeople();
        //Share with model
        model.addAttribute("people", people);
        log.info("Executing Spring MVC Controller.");
        return "index";
    }
    
    //View redirect GET REQ
    @GetMapping("/add")
    //Name method and inject Person
    public String add(Person person){
        //Redirect to view
        return "modify";
    }
    
    //React to Save Person Form Submit - Create
    @PostMapping("/save")
    public String save(@Valid Person person, Errors errors) {
        //Validate for errors
        if(errors.hasErrors()) {
            return "modify";
        }
        //Insert info to DB
        personService.save(person);
        //Back to index page
        return "redirect:/"; 
    }
    
    //React to Update Person Form Submit - Update
    @GetMapping("/update/{idPerson}")
    public String update(Person person, Model model) {
        //Retrieve person by id attribute
        person = personService.findPerson(person);
        //Share retrieved object via model
        model.addAttribute("person",person);
        //Back to form page with pre-loaded values
        return "modify";
    }
    
    //React to Delete Person Form Submit - Delete
    @GetMapping("/delete")
    public String delete(Person person) {
        //Delete person by id attribute
        personService.delete(person);
        //Back to home page
        return "redirect:/";
    }
    
}
