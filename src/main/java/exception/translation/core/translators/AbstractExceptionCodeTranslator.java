package exception.translation.core.translators;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.TreeMap;

/**
 * @auther Archan on 28/08/17.
 */
@Component("exceptionCodeTranslator")
public class AbstractExceptionCodeTranslator implements ExceptionCodeTranslator {
    private static final String CODE_SEPARATOR = "-";

    @Override
    public String translate(Map<String, String> codeParamsMap) {
        Assert.notNull(codeParamsMap, "Param map should not be null to translate");
        Assert.notEmpty(codeParamsMap, "Param map should not be empty to translate");

        Map<String, String> orderedMap = new TreeMap<>();
        orderedMap.putAll(codeParamsMap);
        StringBuilder codeBuilder = new StringBuilder();
        for (String paramValue : orderedMap.values()) {
            codeBuilder.append(paramValue).append(CODE_SEPARATOR);
        }
        codeBuilder.delete(codeBuilder.length() - 1, codeBuilder.length());
        return codeBuilder.toString();
    }
}
