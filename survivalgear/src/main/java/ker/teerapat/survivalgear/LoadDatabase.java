package ker.teerapat.survivalgear;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(SurvivalgearRepository repository) {
        return args -> {
            log.info("loading " + repository.save(new Survivalgear("flashlight", "god", "emergency kit", true, null)));
            log.info("loading " + repository.save(new Survivalgear("first aid kit", "god", "bathroom cabinet", true, null)));
            log.info("loading " + repository.save(new Survivalgear("multi-tool", "god", "backpack", false, null)));            
        };
    }
}