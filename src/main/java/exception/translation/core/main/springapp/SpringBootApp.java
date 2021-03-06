package exception.translation.core.main.springapp;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import exception.translation.core.exceptions.TranslatedException;
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
        logException(mySqlException);
        Exception newException = exceptionTranslationService.translate(generateRuntimeException());
        logException(newException);
    }

    private static void logException(Exception exception) {
        if (exception instanceof TranslatedException) {
            logger.error("Transformed mysql exception. Code [{}] , Message [{}]", ((TranslatedException) exception).getExceptionCode(),
                    ((TranslatedException) exception).getExceptionMessage(), exception);
        } else {
            logger.error("Other exception. ", exception);
        }
    }

    private static Exception generateMySqlException() {
        return new MySQLSyntaxErrorException("Invalid INSERT syntax.", "23000", 9999);
    }


    private static Exception generateRuntimeException() {
        return new RuntimeException("Test Exception");
    }

}
