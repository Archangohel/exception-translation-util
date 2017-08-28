package exception.translation.core.translators;

/**
 * Exception translator interface. Typically for handling one type of application exception
 * (eg. A database Mysql, Postgres, Oracle etc) can have one or many translators.
 * <p>
 *
 * @author Archan on 28/08/17.
 */
public interface ExceptionTranslator {


    /**
     * Returns {@link exception.translation.core.exceptions.TranslatedException} if it finds a match ,
     * otherwise it returns null.
     *
     * @param exception
     * @return
     */
    Exception translate(Exception exception);
}
