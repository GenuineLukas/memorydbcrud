package com.example.demo.user.service;

import com.example.demo.user.db.UserRepository;
import com.example.demo.user.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service 어노테이션은 스프링 프레임워크에서 사용하는 스테레오타입 어노테이션 중 하나로,
// 비즈니스 로직을 처리하는 서비스 계층의 컴포넌트를 나타냅니다. 이 어노테이션은 클래스가 서비스 계층의 컴포넌트임을
// 스프링 컨테이너에게 알리며, 스프링은 이 클래스의 인스턴스를 자동으로 빈으로 등록하고 관리합니다.
// 주로 비즈니스 로직을 처리하거나 데이터베이스 호출을 수행하는 등의 작업을 하는 클래스에 사용됩니다.
@Service
public class UserService {
    private final UserRepository userRepository;

    // UserRepository is injected through the constructor
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity save(UserEntity user){
        //save
        return userRepository.save(user);
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public void remove(Long id){
        userRepository.delete(id);
    }

    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }

    public List<UserEntity> filterScore(int score){
       return userRepository.findAllScoreGreaterThan(score);
    }
}
