package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.iPersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class StartController {
    
    //Inject DAO Class into Controller
    @Autowired
    private iPersonDao personDao;
    
    //View redirect method
    @GetMapping("/")
    //Add Model as a parameter to send info to view
    public String start(Model model){
        //Make use of DAO interface methods
        var people = personDao.findAll();
        //Share with model
        model.addAttribute("people", people);
        log.info("Executing Spring MVC Controller.");
        return "index";
    }
    
}
