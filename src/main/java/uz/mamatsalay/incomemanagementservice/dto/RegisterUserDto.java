package uz.mamatsalay.incomemanagementservice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO for {@link uz.mamatsalay.incomemanagementservice.model.User}
 */
@Getter
@Setter
public class RegisterUserDto {
    private String username;
    private String email;
    private String password;
}