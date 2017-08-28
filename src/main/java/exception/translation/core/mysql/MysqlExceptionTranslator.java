package exception.translation.core.mysql;

import exception.translation.core.parsers.ExceptionParser;
import exception.translation.core.translators.AbstractExceptionTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @auther Archan on 28/08/17.
 */

@Component("mysqlExceptionTranslator")
public class MysqlExceptionTranslator extends AbstractExceptionTranslator {

    @Autowired
    @Qualifier("mysqlExceptionParser")
    private ExceptionParser exceptionParser;


    @Override
    public ExceptionParser getExceptionParser() {
        return exceptionParser;
    }
}
