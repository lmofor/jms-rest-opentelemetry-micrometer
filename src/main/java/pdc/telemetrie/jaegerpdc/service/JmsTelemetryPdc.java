package pdc.telemetrie.jaegerpdc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import pdc.telemetrie.jaegerpdc.config.JmsTemplatePublish;

@Service
public class JmsTelemetryPdc {
    @Autowired
    private JmsTemplatePublish jms;

    public void send(){
        jms.sendMessages();
    }

}
