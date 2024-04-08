package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 4. 기능 만들기  -> 5. 구현체(MemoryMemberRepository 클래스) 만들기
    Member save(Member member);     // 회원을 저장소에 저장 -> 회원 반환
    Optional<Member> findById(Long Id);     // id 로 회원 찾기
    Optional<Member> findByName(String name);   // name 으로 회원 찾기
    // Optional : null 체크관리 메서드 (null을 그대로 반환하는 대신 Optional로 감싸서 반환)
    List<Member> findAll();         // 모든 회원 반환


}
