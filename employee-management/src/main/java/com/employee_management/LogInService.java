package com.employee_management;

import org.springframework.stereotype.Service;

@Service
public class LogInService {
    private final CredentialsRepository credentialsRepository;

    public LogInService(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }

    public boolean checkCredentials(String username, String password) {
        Credentials credentials = credentialsRepository.findByUsername(username);
        if (credentials == null) {
            return false;
        }
        return credentials.getPassword().equals(password);
    }

    public boolean checkCredentialsbyEmail(String email, String password) {
        Credentials credentials = credentialsRepository.findByEmail(email);  // Update this line
        if (credentials == null) {
            return false;
        }
        return credentials.getPassword().equals(password);
    }
}
