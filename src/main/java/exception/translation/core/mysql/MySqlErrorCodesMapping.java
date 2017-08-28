package exception.translation.core.mysql;

/**
 * Just a Demo class for now. The error codes config should be done in DB/some cache.
 * TODO: DB impl and cache impl for error codes.
 * @auther Archan on 28/08/17.
 */
public enum MySqlErrorCodesMapping {

    TEST_MAPPING_1(9999, "23000", "23000-9999", "Duplicate entry '(.+)' for key '(.+)'", "Transformed Message 1. Params {1}"),
    TEST_MAPPING_2(99992, "23001", "23001-99992", "Duplicate entry '(.+)' for key '(.+)'", "Transformed Message 2. Params {2}"),
    TEST_MAPPING_3(99993, "23002", "23002-99993", "Duplicate entry '(.+)' for key '(.+)'", "Transformed Message 3. Params {3}"),
    TEST_MAPPING_4(99994, "23003", "23003-99994", "Duplicate entry '(.+)' for key '(.+)'", "Transformed Message 4. Params {4}"),
    TEST_MAPPING_5(99995, "23004", "23004-99995", "Duplicate entry '(.+)' for key '(.+)'", "Transformed Message 5. Params {5}"),
    TEST_MAPPING_6(99996, "23005", "23005-99996", "Duplicate entry '(.+)' for key '(.+)'", "Transformed Message 6. Params {6}"),
    TEST_MAPPING_7(99997, "23006", "23006-99997", "Duplicate entry '(.+)' for key '(.+)'", "Transformed Message 7. Params {7}");

    MySqlErrorCodesMapping(int vendorCode, String SQLState, String lookupCode, String messagePattern, String transformPattern) {
        this.vendorCode = vendorCode;
        this.SQLState = SQLState;
        this.messagePattern = messagePattern;
        this.lookupCode = lookupCode;
        this.transformPattern = transformPattern;
    }

    private int vendorCode;
    private String SQLState;
    private String lookupCode;
    private String messagePattern;
    private String transformPattern;

    public static MySqlErrorCodesMapping getByVendorCodeAndSqlState(int vendorCode, String sqlState) {
        for (MySqlErrorCodesMapping entry : MySqlErrorCodesMapping.values()) {
            if (vendorCode == entry.vendorCode && entry.SQLState.equals(sqlState)) {
                return entry;
            }
        }
        return null;
    }

    public static MySqlErrorCodesMapping getByLookupCode( String lookupCode) {
        for (MySqlErrorCodesMapping entry : MySqlErrorCodesMapping.values()) {
            if (entry.lookupCode.equals(lookupCode)) {
                return entry;
            }
        }
        return null;
    }

    public String getMessagePattern() {
        return messagePattern;
    }

    public String getSQLState() {
        return SQLState;
    }

    public String getTransformPattern() {
        return transformPattern;
    }

    public int getVendorCode() {
        return vendorCode;
    }

    public String getLookupCode() {
        return lookupCode;
    }
}
