package com.employee_management;

import org.springframework.stereotype.Service;

@Service
public class SignInService{
    CredentialsRepository credentialsRepository;
    public SignInService(CredentialsRepository credentialsRepository){
        this.credentialsRepository = credentialsRepository;
    }
    public boolean signIn(Credentials credentials){
        if (credentialsRepository.existsByUsername(credentials.getUsername())) {
            return false; // Username already exists
        }
        credentialsRepository.save(credentials);
        return true;
    }
}
