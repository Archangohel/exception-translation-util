package exception.translation.core.translators;

import java.util.Map;

/**
 * Created by archangohel on 28/08/17.
 */
public interface ExceptionCodeTranslator {

    /**
     * Get the parameter map , parsed from {@link exception.translation.core.parsers.ExceptionParser#parse(Exception)}
     * and generate a single code out of that
     * @param codeParamsMap
     * @return
     */
    String translate(Map<String, String> codeParamsMap);
}
