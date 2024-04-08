package springbin.componentScan.controller;

// 회원가입 후 가입된 결과를 HTML로 뿌려주는 작업 -> 컨트롤러와 뷰 템플릿 필요
// 멤버컨트롤러는 멤버서비스를 통해 회원가입하고, 멤버서비스를 통해 데이터를 조회할 수 있어야 함
// = 의존관계가 있다 (멤버 컨트롤러가 멤버서비스를 의존한다)

// 컨트롤러를 통해서 외부 요청을 받고 그 다음에 서비스에서 비즈니스 로직을 만들고
// 리포지토리에서 데이터를 저장한다

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// 기능 없이 Controller 실행??
// -> 스프링컨테이너에 이 컨트롤러 애노테이션이 있으면 이 멤버 컨트롤러 객체를 생성해서 스프링에 넣어두고 스프링이 관리
//      (= 스프링 컨테이너에서 스프링 빈이 관리된다)
@Controller
public class MemberController {

    // 멤버서비스를 가져다 써야함
//    private final MemberService memberService = new MemberService();
//    // new로 생성해서 쓸 수도 있긴하지만, 스프링이 관리를 하게되면 다 스트링컨테이너에 등록하고 스트링컨테이너에서 받아쓰도록 바꿔야함
//    // new로 하게되면 멤버컨트롤러 말고 다른 여러 컨트롤러들이 멤버서비스를 가져다 쓸수있는데, 이 객체는 별 기능이 없어서 여러개의 인스턴스를 생성할 필요없음
//    // -> 하나만 생성해서 공통으로 쓰면 됨
    private final MemberService memberService;

    // 생성자 => MemberController가 생성될 때 스프링빈에 등록되어있는 멤버서비스 객체를 가져다 넣어줌(DI-의존관계주입)
    @Autowired  // 멤버서비스에 스프링이 스프링컨테이너에 있는 멤버서비스를 가져다가 연결시켜줌
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
        // 실행시 error 발생 : 'hello.hellospring.service.MemberService' that could not be found.
        // 멤버서비스를 찾을 수 없다?? => autowired는 스프링컨테이너에서 멤버서비스를 가져와야하는데 안됨 -> MemberService 이동!

    }
}

/*  스프링 빈을 등록하는 2가지 방법
    1. 컴포넌트 스캔과 자동 의존관계 설정(@ 애노테이션 사용)
    2. 자바 코드로 직접 스프링 빈 등록
* */

/*  컴포넌트 스캔 원리
    @Component 애노테이션이 있으면 스프링 빈으로 자동 등록
        - 해당 패키지를 포함한 하위들은 자동으로 스프링빈으로 등록
        - 하위 패키지가 아니면 스캔 x
    @Controller 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 때문
    @Component 를 포함하는 다음 애노테이션도 스프링 빈으로 자동 등록
        @Controller
        @Service
        @Repository
* */

/*  스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본으로 싱글톤으로 등록
        - 싱글톤 : 유일하게 하나만 등록해서 공유
    => 같은 스프링 빈이면 모두 같은 인스턴스
    => 설정으로 싱글톤이 아니게 설정할 수 있지만, 특별한 경우를 제외하면 대부분 싱글톤을 사용
* */
