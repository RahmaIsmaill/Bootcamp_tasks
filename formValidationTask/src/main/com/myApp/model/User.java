package main.com.myApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.com.myApp.specialannotation.PasswordMatches;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PasswordMatches
public class User {

    @NotBlank(message = "Username cannot be empty or null")
    private String userName;

    @NotBlank(message = "Email cannot be empty or null")
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "Please enter a valid email address"
    )
    private String email;

    @NotBlank(message = "Password cannot be empty")

    private String password;

    @NotBlank(message = "Confirm Password cannot be empty")
    private String confirmPassword;

}
