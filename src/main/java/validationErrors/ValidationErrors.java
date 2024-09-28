package validationErrors;

import lombok.Getter;

@Getter
public class ValidationErrors {

    private final String FIRSTNAME_VALIDATION_ERROR = "User validation failed: firstName: Path `firstName` is required.";
    private final String LASTNAME_VALIDATION_ERROR = "User validation failed: lastName: Path `lastName` is required.";
    private final String EMAIL_VALIDATION_ERROR = "User validation failed: email: Email is invalid";
    private final String PASSWORD_VALIDATION_ERROR = "User validation failed: password: Path `password` is required.";
}
