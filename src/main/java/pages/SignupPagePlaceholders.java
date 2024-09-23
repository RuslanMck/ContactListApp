package pages;

public enum SignupPagePlaceholders {

    FIRSTNAME("First Name"),
    LASTNAME("Last Name"),
    EMAIL("Email"),
    PASSWORD("Password");

    private final String placeholder;

    SignupPagePlaceholders(String PLACEHOLDER){
        this.placeholder = PLACEHOLDER;
    }

    public String getPlaceholder(){
        return placeholder;
    }
}
