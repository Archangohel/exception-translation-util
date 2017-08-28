package exception.translation.core.services;

import exception.translation.core.exceptions.TranslatedException;
import exception.translation.core.translators.ExceptionTranslator;

/**
 * Main interface to translate exceptions.
 * Created by archangohel on 28/08/17.
 */
public interface ExceptionTranslationService {

    /**
     * Should be called with original exception that needs to be translated.
     * Typically if any registered translator(registered through
     * {@link ExceptionTranslationService#registerTranslator} is able to translate
     * the exception then it should return {@link TranslatedException}
     * otherwise it would return the same instance of the exception passed.
     * Error {@link Error} is not in scope of the service.
     *
     * @param originalException
     * @return
     */
    Exception translate(Exception originalException);

    /**
     * Registers an exception translator {@link ExceptionTranslator}.
     *
     * @param exceptionTranslator
     */
    void registerTranslator(ExceptionTranslator exceptionTranslator);
}
