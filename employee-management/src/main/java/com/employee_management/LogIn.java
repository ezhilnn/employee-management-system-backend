package com.employee_management;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("log_in")
@CrossOrigin(origins = "*")
public class LogIn {
    LogInService logInService;
    public LogIn(LogInService logInService) {
        this.logInService = logInService;
    }
    @PostMapping
    public boolean logIn(@RequestBody LogInParams logInParams) {
        boolean check1=logInService.checkCredentials(logInParams.getUsername(), logInParams.getPassword());

       boolean check2=logInService.checkCredentialsbyEmail(logInParams.getUsername(), logInParams.getPassword());
        return check2||check1;
    }
}
