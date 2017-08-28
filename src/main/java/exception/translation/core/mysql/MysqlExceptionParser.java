package exception.translation.core.mysql;

import exception.translation.core.parsers.ExceptionParser;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther Archan on 28/08/17.
 */

@Component("mysqlExceptionParser")
public class MysqlExceptionParser implements ExceptionParser {
    @Override
    public Map<String, String> parse(Exception exception) {
        if (exception instanceof SQLException) {
            SQLException sqlException = (SQLException) exception;
            if (isMySqlException(exception)) {
                MySqlErrorCodesMapping mapping = MySqlErrorCodesMapping
                        .getByVendorCodeAndSqlState(sqlException.getErrorCode(), sqlException.getSQLState());

                Map<String, String> map = new HashMap<>();
                map.put("vendorCode", String.valueOf(mapping.getVendorCode()));
                map.put("sqlState", mapping.getSQLState());

                return map;
            }
        }
        return null;
    }

    private boolean isMySqlException(Exception sqlException) {
        return sqlException.getClass().getName().startsWith("com.mysql");
    }
}
