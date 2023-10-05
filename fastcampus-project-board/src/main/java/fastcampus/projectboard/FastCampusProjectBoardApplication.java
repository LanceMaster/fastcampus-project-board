package fastcampus.projectboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@ConfigurationPropertiesScan
@SpringBootApplication
public class FastCampusProjectBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastCampusProjectBoardApplication.class, args);

    }

}
