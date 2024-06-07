package com.esi.avito.repository;


import com.esi.avito.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
    User findByEmail(String email);
    User findByFirebaseUserId(String firebaseUserId);
}
