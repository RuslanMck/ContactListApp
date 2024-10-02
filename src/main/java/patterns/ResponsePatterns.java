package patterns;

public class ResponsePatterns {
    public static final String TOKEN_PATTERN = "\\A[a-zA-Z.0-9-_]{149}\\z";
    public static final String ID_PATTERN = "\\A\\w{24}\\z";
    public static final String FIRST_NAME_PATTERN = "\\A\\w{0,24}\\z";
    public static final String LAST_NAME_PATTERN = "\\A\\w{0,24}\\z";
    public static final String EMAIL_PATTERN = "\\A[a-zA-Z0-9_.+]+@[a-z]+\\.[a-z]+\\z";
    public static final String VERSION_PATTERN = "\\A[0-9]{1}\\z";
}
