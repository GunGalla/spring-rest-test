package com.gungalla.springresttask.repository.impl;

import com.gungalla.springresttask.domain.user.Role;
import com.gungalla.springresttask.domain.user.User;
import com.gungalla.springresttask.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void create(User user) {

    }

    @Override
    public void insertUserRole(Long userId, Role role) {

    }

    @Override
    public boolean isTaskOwner(Long userId, Long taskId) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

}
