package mx.com.gm;

import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class StartController {
    
    @Value("${index.greeting}")
    private String greeting;
    
    //View redirect method
    @GetMapping("/")
    //Add Model as a parameter to send info to view
    public String start(Model model){
        //var to be sent
        var msg = "Hello World with Thymeleaf.";
        //sending var to model (key,var)
        model.addAttribute("msg", msg);
        model.addAttribute("greeting", greeting);
        //create a domain class object
        var person = new Person();
        person.setName("Kathy");
        person.setLastName("Jones");
        person.setEmail("kathy.jones@gmail.com");
        person.setPhone("5578765543");
        //create another domain class object
        var person2 = new Person();
        person2.setName("Mark");
        person2.setLastName("Twain");
        person2.setEmail("mark.twain@gmail.com");
        person2.setPhone("5543556543");
        //Create an array list to store people
        var peopleList = new ArrayList();
        //fill array list
        peopleList.add(person);
        peopleList.add(person2);
        //Another notation to create the array list
        var peopleList2 = Arrays.asList(person, person2);
        //add person to model
        model.addAttribute("person", person);
        //add array list to model
        model.addAttribute("peopleList",peopleList);
        //add info level log comment
        log.info("Executing Spring MVC Controller.");
        //The return of an MVC @Controller
        //is the name of the view addressed
        //in this case: index.html
        return "index";
    }
    
}
