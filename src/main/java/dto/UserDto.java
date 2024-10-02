package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import testUsers.SignupUser;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

private SignupUser user;
private String token;

    public UserDto() {
    }

    public UserDto(SignupUser user, String token) {
        this.user = user;
        this.token = token;
    }
}
