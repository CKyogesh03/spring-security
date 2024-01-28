package com.security.app.repository;

import com.security.app.entity.Role;
import com.security.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {

    User findByRole(Role role);
    Optional<User> findByEmail(String email);
}
