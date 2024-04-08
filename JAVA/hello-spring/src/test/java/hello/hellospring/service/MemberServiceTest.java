package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    // 서비스 생성
//    MemberService memberService = new MemberService();

    // 클리어를 위해 MemoryMemberRepository 가져오기
//    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    // MemberService의 new MemoryMemberRepository() 와 MemberServiceTest의 new MemoryMemberRepository()는 서로 다른 객체(인스턴스)
    // 같은 인스턴스를 쓰게 변경 (new 직접생성 x, 외부에서 가져오게 수정)
    MemberService memberService;    // 4 
    MemoryMemberRepository memberRepository;    // 3 만들어진 memberRepository를 MemoryMemberRepository에 넣어둠
    @BeforeEach
    public void beforeEach(){   // 1 각 테스트 실행전에 
        memberRepository = new MemoryMemberRepository();    // 2 새로운 MemoryMemberRepository 만들고
        memberService = new MemberService(memberRepository);    // 4 memberRepository를 MemberService에서 memberServicedp 넣어줌
        // => 같은 MemoryMemberRepository 사용
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();  // 메서드 끝나고 나면 db값 삭제
    }

    @Test   // 빌드될 때 테스트코드는 실제 코드에 포함되지 않음
    void join() {   // 회원 가입이 잘 되는지 테스트
        // given - 상황이 주어져서 (기반 데이터)
        Member member = new Member();
        member.setName("hello");

        // when - 이것을 싱행했을 때 (검증 내용) : MemberService의 join 검증
        Long saveId = memberService.join(member);

        // then - 결과가 나와야 함 (검증부)
        Member findMember = memberService.findOne(saveId).get();  // memberService의 findOne에 멤버아이디 넘기기 -> 결과를 get으로 받아 findMember 저장
//        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());    // static import
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외(){    // 테스트코드에서는 한글로 써도 괜찮음
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
//        // 방법1
//        try {
//            memberService.join(member2);    // 실행 후 exception 터치하지않고 내려가면 fail(=테스트 예외 발생)
//            // => 예외 발생 -> try catch
//            fail();
//        } catch (IllegalStateException e){
//            // 예외 발생한 것이 정상적으로 작동(성공)
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        // 방법2
//        assertThrows(IllegalStateException.class, () -> memberService.join(member2));   // member2에 대한 예외 발생되야함
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2)); // 예외 e로 받아옴
        // 메세지 반환
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}