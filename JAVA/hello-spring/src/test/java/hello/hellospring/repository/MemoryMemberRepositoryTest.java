package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
    // 테스트를 먼저 만든 후 구현 클래스를 만듦 => 테스트 주도 개발(TDD)

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 모든 테스트는 순서랑 상관없이 메소드별로 다 따로 동작하게만 설계해야 함
    // => 테스트가 하나 끝나고 나면 해당 저장소나 공용데이터들을 클리어해줘야함
    @AfterEach      // 메서드 실행이 끝날때마다 동작함(콜백 메서드)
    public void afterEach(){
        repository.clearStore();
    }

        @Test       // Test 임포트 -> 메서드 실행
        public void save(){     // 멤버 저장이 잘 되는지 테스트
            Member member = new Member();   // 멤버 생성
            member.setName("spring");       // 멤버 이름 셋팅

            repository.save(member);        // 리포지토리에 멤버 save

            Member result = repository.findById(member.getId()).get();  // 검증(제대로 들어갔는지 확인)
//            System.out.println("result = " + (result == member));     // 방법1
//            Assertions.assertEquals(member, result);      // 방법2
            assertThat(member).isEqualTo(result);   // 방법3 저장할 new 의 값(member)과 내가 db에서 꺼낸 값(result)이 똑같으면 참
        }

        @Test
        public void findByName(){
            Member member1 = new Member();
            member1.setName("spring1");
            repository.save(member1);

            Member member2 = new Member();      // Shift + F6 : 리네임
            member2.setName("spring2");
            repository.save(member2);

            Member result = repository.findByName("spring1").get();

            assertThat(result).isEqualTo(member1);
        }

        @Test
    public void findAll(){
            Member member1 = new Member();
            member1.setName("spring1");
            repository.save(member1);

            Member member2 = new Member();
            member2.setName("spring2");
            repository.save(member2);

            List<Member> result = repository.findAll();

            assertThat(result.size()).isEqualTo(2);
        }

}
