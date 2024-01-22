package pdc.telemetrie.jaegerpdc.config;

import io.micrometer.observation.ObservationRegistry;
import jakarta.jms.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsTemplatePublish {

    private final JmsTemplate jmsTemplate;

    @Value("spring.artemis.queues")
    private String queueName;
    private final JmsMessagingTemplate jmsMessagingTemplate;


    public JmsTemplatePublish(ObservationRegistry observationRegistry, ConnectionFactory connectionFactory) {
        this.jmsTemplate = new JmsTemplate(connectionFactory);
        // configure the observation registry
        this.jmsTemplate.setObservationRegistry(observationRegistry);

        // For JmsMessagingTemplate, instantiate it with a JMS template that has a configured registry
        this.jmsMessagingTemplate = new JmsMessagingTemplate(this.jmsTemplate);


    }



    public void sendMessages() {
        this.jmsTemplate.convertAndSend("PDC.TELEMETRY.JAEGER","test message");
    }
}
