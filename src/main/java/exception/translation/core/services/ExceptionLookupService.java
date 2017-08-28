package exception.translation.core.services;

import java.util.Map;

/**
 * Created by archangohel on 28/08/17.
 */
public interface ExceptionLookupService {

    /**
     * Lookup based on a string code returned by
     * (get the code from {@link exception.translation.core.translators.ExceptionCodeTranslator#translate(Map)}.
     *
     * @param code
     * @return
     */
    ExceptionMetadata lookupByCode(String code);
}
