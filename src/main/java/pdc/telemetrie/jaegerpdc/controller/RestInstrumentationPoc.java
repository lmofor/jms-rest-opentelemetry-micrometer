package pdc.telemetrie.jaegerpdc.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class RestInstrumentationPoc {

    @GetMapping("/good")
    public String goodMethod(){
        log.info("LOGGED HERE");
        System.out.println("PRINTED HERE");
        return "ok";
    }
}
