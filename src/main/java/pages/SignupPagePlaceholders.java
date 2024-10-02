package pages;

public enum SignupPagePlaceholders {

    FIRSTNAME("First Name"),
    LASTNAME("Last Name"),
    EMAIL("Email"),
    PASSWORD("Password");

    private final String PLACEHOLDER;

    SignupPagePlaceholders(String PLACEHOLDER){
        this.PLACEHOLDER = PLACEHOLDER;
    }

    public String getPLACEHOLDER(){
        return PLACEHOLDER;
    }
}
