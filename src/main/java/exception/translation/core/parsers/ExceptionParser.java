package exception.translation.core.parsers;

import java.util.Map;

/**
 * Exception parser interface to parse code from the exception.
 * Created by archangohel on 28/08/17.
 */
public interface ExceptionParser {
    /**
     * Extract the exceptions codes from the exception message if exists. Otherwise returns null.
     *
     * @param exception
     * @return
     */
    Map<String, String> parse(Exception exception);
}
