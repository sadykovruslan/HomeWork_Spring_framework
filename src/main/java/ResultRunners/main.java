package ResultRunners;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        var applicationContext = new AnnotationConfigApplicationContext(ResultProcessorConfig.class);
        var resultProcessor = applicationContext.getBean(ResultProcessor.class);

    }
}
