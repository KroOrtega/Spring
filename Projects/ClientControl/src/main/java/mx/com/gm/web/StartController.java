package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.iPersonDao;
import mx.com.gm.service.iPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class StartController {
    
    //Inject DAO Class into Controller
    //@Autowired
    //private iPersonDao personDao;
    
    //Inject Service Layer Interface
    @Autowired
    private iPersonService personService;
    
    //View redirect method
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
    
}
