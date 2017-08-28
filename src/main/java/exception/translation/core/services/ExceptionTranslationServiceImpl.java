package exception.translation.core.services;

import exception.translation.core.exceptions.TranslatedException;
import exception.translation.core.translators.ExceptionTranslator;
import exception.translation.core.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @auther Archan on 28/08/17.
 */
@Component
public class ExceptionTranslationServiceImpl implements ExceptionTranslationService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private Set<ExceptionTranslator> registeredTranslators = new HashSet<>();

    private Object registerTranslatorsLock = new Object();

    @Override
    public Exception translate(Exception originalException) {
        Exception rootCauseException = CommonUtils.getRootCauseException(originalException);
        for (ExceptionTranslator exceptionTranslator : registeredTranslators) {
            Exception returnedException = exceptionTranslator.translate(rootCauseException);
            if (returnedException != null && returnedException instanceof TranslatedException) {
                return returnedException;
            }
        }
        return originalException;
    }

    @Override
    public void registerTranslator(ExceptionTranslator exceptionTranslator) {
        if (exceptionTranslator != null) {
            logger.info("Registering exceptionTranslator {}", exceptionTranslator.getClass().getName());
            synchronized (registerTranslatorsLock) {
                registeredTranslators.add(exceptionTranslator);
            }
        }
    }
}
