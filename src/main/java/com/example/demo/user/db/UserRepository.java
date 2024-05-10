package com.example.demo.user.db;

import com.example.demo.db.SimpleDataRepository;
import com.example.demo.user.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {

    public List<UserEntity> findAllScoreGreaterThan(int score) {
        return this.findAll().stream().filter(userEntity -> userEntity.getScore() > score).collect(Collectors.toList());
    }
}