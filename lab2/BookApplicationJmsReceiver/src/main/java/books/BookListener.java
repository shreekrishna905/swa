package books;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class BookListener {
    @JmsListener(destination = "testQueue")
    public void receiveMessage(final String contactAsString) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Book book = objectMapper.readValue(contactAsString, Book.class);
            System.out.println("JMS receiver received message:" + book);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
