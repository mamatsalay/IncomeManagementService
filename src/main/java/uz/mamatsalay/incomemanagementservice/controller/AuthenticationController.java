package uz.mamatsalay.incomemanagementservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mamatsalay.incomemanagementservice.dto.LoginUserDto;
import uz.mamatsalay.incomemanagementservice.dto.RegisterUserDto;
import uz.mamatsalay.incomemanagementservice.dto.VerifyUserDto;
import uz.mamatsalay.incomemanagementservice.model.User;
import uz.mamatsalay.incomemanagementservice.response.LoginResponse;
import uz.mamatsalay.incomemanagementservice.service.AuthenticationService;
import uz.mamatsalay.incomemanagementservice.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;
    public AuthenticationController(AuthenticationService authenticationService, JwtService jwtService) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getJwtExpiration());
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/verify")
        public ResponseEntity<?> verifyUser(@RequestBody VerifyUserDto verifyUserDto) {
            try{
                authenticationService.verifyUser(verifyUserDto);
                return ResponseEntity.ok("Account verified successfully");
            } catch (RuntimeException e){
                return ResponseEntity.badRequest().body(e.getMessage());
            }
    }

    @PostMapping("/resend")
    public ResponseEntity<?> resendVerificationCode(@RequestParam String email) {
        try{
            authenticationService.resendVerificationEmail(email);
            return ResponseEntity.ok("Verification code resent");
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}

