package com.example.techiteasyspringhomework.repositories;

import com.example.techiteasyspringhomework.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
