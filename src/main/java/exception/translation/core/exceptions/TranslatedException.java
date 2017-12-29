package exception.translation.core.exceptions;

/**
 *
 * Created by archangohel on 28/08/17.
 */
public class TranslatedException extends RuntimeException {
    private String exceptionCode;
    private String exceptionMessage;

    public TranslatedException(String exceptionCode, String exceptionMessage, Throwable originalException) {
        super(originalException);
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
    }



    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public String toString() {
        return "TranslatedException{" +
                "exceptionCode='" + exceptionCode + '\'' +
                ", exceptionMessage='" + exceptionMessage + '\'' +
                "} " + super.toString();
    }
}
