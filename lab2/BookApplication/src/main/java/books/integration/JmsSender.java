package books.integration;

import books.domain.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsSender {

    final JmsTemplate jmsTemplate;

    public JmsSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(Book book)  {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String bookString = objectMapper.writeValueAsString(book);
            System.out.println("Sending a JMS message:" + bookString);
            jmsTemplate.convertAndSend("testQueue", bookString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
