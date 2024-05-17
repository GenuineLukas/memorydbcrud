package com.example.demo.user.db;

import com.example.demo.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // select * from user where score >= [??]

    List<UserEntity> findAllByScoreGreaterThanEqual(int sc);
    List<UserEntity> findAllByScoreLessThanEqual(int sc);
    // SQL query methods
    // more query methods can be found here: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    // select * from user where score >= ?? AND score <= ??
    // SQL query methods are JPA convention
    List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);

    @Query(
            value = "select * from user as u where u.score >= :min AND u.score <= :max",
            nativeQuery = true
    )
    List<UserEntity> score(
            @Param(value = "min") int min,
            @Param(value = "max") int max);

}