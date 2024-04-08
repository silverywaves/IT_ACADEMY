package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;


public class MemberService {

    // 회원 서비스를 만들려면 회원 리포지토리 필요
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;    // Test 와 같은 인스턴스 사용을 위해 변경

    // constructor 생성
    // memberRepository를 직접 내가 new로 생성하는 것이 아니라, 외부에서 넣어주도록 설정(DI:Dependency Injection)
    public MemberService(MemberRepository memberRepository) {  // MemberRepository의 구현체 : MemoryMemberRepository => MemberService에 주입
        this.memberRepository = memberRepository;
    }

    /* 회원 가입 */
    public Long join(Member member){    // 조인을 하면
        // 같은 이름이 있는 중복 회원X
//        Optional<Member> result = memberRepository.findByName(member.getName());
        // memberRepository에서 파라미터로 넘어온 member.getName을 findByName으로 찾아보기
//        result.ifPresent(m->{     // if present(만약 여기 값이 있으면 로직 동작-null X) => 멤버(m)의 값이 있으면 이미 존재하는 회원
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        // => 리팩토링으로 간단하게 바꿀 수 있음(Extract Method)
        validateDuplicateMember(member);    // 중복 회원 검증


        memberRepository.save(member);      // (save 호출)중복회원검증 통과하면 저장
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m->{
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }
    /* 전체 회원 조회 */
    // 서비스는 비즈니스에 의존적으로 설계&네이밍, 리포지토리는 약간 더 기계적으로 네이밍
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);     // findById 했을 때 memberId 넘겨서 반환
    }
}
