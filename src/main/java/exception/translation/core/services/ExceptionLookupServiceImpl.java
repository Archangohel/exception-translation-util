package exception.translation.core.services;

import exception.translation.core.mysql.MySqlErrorCodesMapping;
import org.springframework.stereotype.Component;

/**
 * @auther Archan on 28/08/17.
 */
@Component("exceptionLookupService")
public class ExceptionLookupServiceImpl implements ExceptionLookupService {
    //TODO: configure codes and exception in DB


    @Override
    public ExceptionMetadata lookupByCode(String code) {
        MySqlErrorCodesMapping mapping = MySqlErrorCodesMapping.getByLookupCode(code);
        ExceptionMetadata metadata = new ExceptionMetadata();
        metadata.setCode(code);
        metadata.setOriginalMessagePattern(mapping.getMessagePattern());
        metadata.setTobeMessagePattern(mapping.getTransformPattern());
        return metadata;
    }
}
