package com.example.testsecurity.repository;

import com.example.testsecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    // Description : Member table에 Jpa 함수를 사용할 수 있도록 감싸준다.
    boolean existsByUsername(String username);

    UserEntity findByUsername(String username);
}
