package com.akechsalim.userloginandregistration.registration;

import com.akechsalim.userloginandregistration.appuser.AppUser;
import com.akechsalim.userloginandregistration.appuser.AppUserService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private AppUserService appUserService;
    private EmailValidator emailValidator;

    public RegistrationService(AppUserService appUserService, EmailValidator emailValidator) {
        this.appUserService = appUserService;
        this.emailValidator = emailValidator;
    }

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid");
        }
        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        )
        );
    }
}
