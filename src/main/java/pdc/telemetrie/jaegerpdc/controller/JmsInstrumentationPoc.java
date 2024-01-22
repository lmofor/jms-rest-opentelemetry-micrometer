package pdc.telemetrie.jaegerpdc.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pdc.telemetrie.jaegerpdc.service.JmsTelemetryPdc;


@Log4j2
@RestController
public class JmsInstrumentationPoc {
        @Autowired
        private JmsTelemetryPdc jmsTelemetryPdc;

        @GetMapping("/jms")
    public String jmsSender(){
        jmsTelemetryPdc.send();
        log.info("JMS LOGGED HERE");
        System.out.println("JMS PRINTED HERE");

        return "Envoyé";
    }

    @JmsListener(destination = "PDC.TELEMETRY.JAEGER")
    public void jmsListener(String str){

        log.info("JMS LISTENED LOGGED HERE : " + str);
        System.out.println("JMS LISTENED PRINTED HERE : " + str);


    }
}
