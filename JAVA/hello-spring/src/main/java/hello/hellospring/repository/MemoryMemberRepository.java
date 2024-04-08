package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {   // 6 저장소(MemberRepository 인터페이스) 구현

    // 7. save 할 때 저장할 공간 생성 -> Map 사용
    // key => id 니까 Long 타입 / value => 멤버 니까 Member 타입 -> import
    private static Map<Long, Member> store = new HashMap<>();
    // 실무에서는 동시성 문제로 공유되는 변수일 경우 concurrent HashMap 을 써야 함
    private static long sequence = 0L;      // 시퀀스 만들기(키값 생성) - 실무에서는 동시성 문제로 Atomic Long 사용
    // 시퀀스 : 연속적인 사건들이나 사건이나 행동 등의 순서
    //       : 프로그래밍적 의미로는 공간적, 시간적으로 정해져 있는 순서(앞뒤가 반드시 지켜져야만 하는 순서)

    @Override
    public Member save(Member member) {     
        member.setId(++sequence);           // 멤버를 save 할 때 시퀀스 값을 하나 올려줌
        store.put(member.getId(), member);  // store 에다가 넣기 전에 멤버에 id값을 셋팅, 이름은 넘어온 상태
        return member;      // 스펙에 따라 저장된 결과 반환
    }

    @Override
    public Optional<Member> findById(Long id) {
        // store에서 get으로 id를 꺼내옴
        return Optional.ofNullable(store.get(id));
        // => 결과가 없으면? null 
        // -> 처리방법 : optional.of + Nullable -> null을 감싸서 반환 가능
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))    // member.getName이 파라미터로 널멍온 name이랑 같은지 확인(필터링)
                .findAny();     // 값을 찾으면 반환
        // findAny() ; 루프를 돌면서 하나를 찾으면 값 반환, 값이 없으면 옵셔널에 null이 포함되어 반환
    }

    @Override
    public List<Member> findAll() {

        return new ArrayList(store.values());   // store에 있는 values(멤버들) 반환
    }

    // 8 테스트 케이스 작성하러 가기(코드를 코드로 검증)
    // 메인 메서드 또는 웹어플리케이션의 컨트롤을 통해 기능 실행 -> 준비, 실행 오래걸림, 반복 어려움, 여러 테스트를 한번에 실행하기 어려움
    // => java에서는 JUnit 이라는 프레임워크로 테스트 코드를 만들어서 그 테스트코드 자체를 실행
    // -> test 패키지 내에서 repository 패키지 생성 -> 테스트할 클래스명뒤에 Test 붙인 이름으로 클래스 생성
    public void clearStore(){
        store.clear();  // store 비워줌
    }
}
