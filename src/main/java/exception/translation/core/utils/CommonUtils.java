package exception.translation.core.utils;

import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * @auther Archan on 28/08/17.
 */
public class CommonUtils {

    public static Exception getRootCauseException(Exception exception) {

        Throwable rootCause = ExceptionUtils.getRootCause(exception);
        if (rootCause == null) {
            return exception;
        } else {
            if (Exception.class.isAssignableFrom(rootCause.getClass())) {
                return (Exception) rootCause;
            } else {
                return exception;
            }
        }
    }

    public static Throwable getRootCauseThrowable(Exception exception) {
        Throwable rootCause = ExceptionUtils.getRootCause(exception);
        if (rootCause == null) {
            return exception;
        } else {
            return rootCause;
        }
    }
}
