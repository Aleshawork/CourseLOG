package com.example.SpringSecurity.repository;

import com.example.SpringSecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<List<User>> findUserByNameAndSurname(String name, String surname);
    Optional<User> findUserByGroups(String group);
}
