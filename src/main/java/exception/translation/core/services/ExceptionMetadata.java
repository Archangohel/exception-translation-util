package exception.translation.core.services;

import java.util.Map;

/**
 * Created by archangohel on 28/08/17.
 */

public class ExceptionMetadata {

    private String code;
    private String originalMessagePattern;
    private String tobeMessagePattern;
    private String params;
    private Map<String, Object> paramsMap;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOriginalMessagePattern() {
        return originalMessagePattern;
    }

    public void setOriginalMessagePattern(String originalMessagePattern) {
        this.originalMessagePattern = originalMessagePattern;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Map<String, Object> getParamsMap() {
        return paramsMap;
    }

    public void setParamsMap(Map<String, Object> paramsMap) {
        this.paramsMap = paramsMap;
    }

    public String getTobeMessagePattern() {
        return tobeMessagePattern;
    }

    public void setTobeMessagePattern(String tobeMessagePattern) {
        this.tobeMessagePattern = tobeMessagePattern;
    }
}
