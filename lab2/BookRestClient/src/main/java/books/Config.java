package books;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    RestOperations restTemplate() {
        return new RestTemplate();
    }

}
