package com.employee_management;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<Credentials, Integer> {
    Credentials findByUsername(String username);
    boolean existsByUsername(String username);
    Credentials findByEmail(String email);  // Add this method
}
