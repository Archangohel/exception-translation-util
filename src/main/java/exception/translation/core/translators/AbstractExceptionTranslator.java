package exception.translation.core.translators;

import exception.translation.core.exceptions.TranslatedException;
import exception.translation.core.parsers.ExceptionParser;
import exception.translation.core.services.ExceptionLookupService;
import exception.translation.core.services.ExceptionMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @auther Archan on 28/08/17.
 */

public abstract class AbstractExceptionTranslator implements ExceptionTranslator {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("exceptionCodeTranslator")
    private ExceptionCodeTranslator exceptionCodeTranslator;

    @Autowired
    @Qualifier("exceptionLookupService")
    private ExceptionLookupService exceptionLookupService;

    @Override
    public Exception translate(Exception exception) {
        Assert.notNull(exceptionCodeTranslator, "exceptionCodeTranslator can't be null");
        Assert.notNull(getExceptionParser(), "exceptionParser can't be null");

        Map<String, String> parsedExceptionCodes = getExceptionParser().parse(exception);
        if (parsedExceptionCodes != null && !parsedExceptionCodes.isEmpty()) {
            String exceptionCode = exceptionCodeTranslator.translate(parsedExceptionCodes);
            if (!StringUtils.isEmpty(exception)) {
                ExceptionMetadata configuredExceptionMetadata = exceptionLookupService.lookupByCode(exceptionCode);
                if (configuredExceptionMetadata != null) {
                    // TODO: work on converting the message.
                    String message = configuredExceptionMetadata.getTobeMessagePattern();
                    TranslatedException translatedException = new TranslatedException(exceptionCode, message, exception);
                    return translatedException;
                } else {
                    logger.warn("No configuration found for exception {}. Please add ExceptionMetadata configuration for code ", exception, exceptionCode);
                }

            }
        }
        return null;
    }

    public ExceptionCodeTranslator getExceptionCodeTranslator() {
        return exceptionCodeTranslator;
    }

    public void setExceptionCodeTranslator(ExceptionCodeTranslator exceptionCodeTranslator) {
        this.exceptionCodeTranslator = exceptionCodeTranslator;
    }

    public abstract ExceptionParser getExceptionParser();


    public ExceptionLookupService getExceptionLookupService() {
        return exceptionLookupService;
    }

    public void setExceptionLookupService(ExceptionLookupService exceptionLookupService) {
        this.exceptionLookupService = exceptionLookupService;
    }
}
