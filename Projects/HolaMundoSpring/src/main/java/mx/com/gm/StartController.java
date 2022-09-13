package mx.com.gm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StartController {
    
    //Example method
    @GetMapping("/")
    public String start(){
        log.info("Executing REST Controller.");
        log.debug("More log detail of REST Controller.");
        return "Hello World with Spring again let's see!";
    }
    
}
