package com.employee_management;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign_in")
public class SignIn {
    SignInService signInService;
    public SignIn(SignInService signInService) {
        this.signInService = signInService;
    }
    @PostMapping()
    public boolean signIn(@RequestBody Credentials cred){
        return signInService.signIn(cred);

    }
}
