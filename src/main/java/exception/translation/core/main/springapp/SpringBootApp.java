package exception.translation.core.main.springapp;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import exception.translation.core.services.ExceptionTranslationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


/**
 * Created by archangohel on 15/08/17.
 */

public class SpringBootApp {
    private static Logger logger = LoggerFactory.getLogger(SpringBootApp.class);

    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ExceptionTranslationService exceptionTranslationService = context.getBean(ExceptionTranslationService.class);
        Exception mySqlException = exceptionTranslationService.translate(generateMySqlException());
        logger.error("Transformed mysql exception {}", mySqlException);
        Exception newException = exceptionTranslationService.translate(generatRuntimeException());
        logger.error("Other exception {}", newException);

    }

    private static Exception generateMySqlException() {
        return new MySQLSyntaxErrorException("Invalid INSERT syntax.", "23000", 9999);
    }


    private static Exception generatRuntimeException() {
        return new RuntimeException("Test Exception");
    }

}
