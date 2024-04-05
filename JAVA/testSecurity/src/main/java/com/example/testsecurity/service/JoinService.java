package com.example.testsecurity.service;

import com.example.testsecurity.dto.JoinDTO;
import com.example.testsecurity.entity.UserEntity;
import com.example.testsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
//    데이터를 받아 회원가입을 진행할 메서드 생성

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDTO joinDTO) {

        // DB에 이미 동일한 username을 가진 회원이 존재하는지 검증
        // JoinController로 데이터가 들어오고 JoinService에서 진행
        // -> username 존재하면 true return
        boolean isUser = userRepository.existsByUsername(joinDTO.getUsername());
        if (isUser) {
            return;
        }

        UserEntity data = new UserEntity();

        data.setUsername(joinDTO.getUsername());
        data.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
        // 비밀번호의 경우 필수적으로 암호화를 진행해서 데이터베이스에 넣어줘야함
        // -> encode 메서드를 이용해서 joinDTO의 비밀번호데이터를 꺼낸 후 해시화(암호화) & 셋팅

        // 회원가입을 진행할 때 회원자신이 직접 특정한 롤값을 설정할 수 없기때문에 서비스단에서 롤값은 강제로(명시적으로) 넣어야함
        data.setRole("ROLE_USER");
        // ROLE_ 이라는 접두사를 넣어줘야함

        // 데이터를 DB에 저장
        userRepository.save(data);  // 레파지토리에 특정한 데이터를 insert 할 수 있는 save orm 쿼리

    }
}
