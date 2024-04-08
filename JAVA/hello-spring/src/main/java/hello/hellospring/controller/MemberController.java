package hello.hellospring.controller;

// 회원가입 후 가입된 결과를 HTML로 뿌려주는 작업 -> 컨트롤러와 뷰 템플릿 필요
// 멤버컨트롤러는 멤버서비스를 통해 회원가입하고, 멤버서비스를 통해 데이터를 조회할 수 있어야 함
// = 의존관계가 있다 (멤버 컨트롤러가 멤버서비스를 의존한다)

// 컨트롤러를 통해서 외부 요청을 받고 그 다음에 서비스에서 비즈니스 로직을 만들고
// 리포지토리에서 데이터를 저장한다

import org.springframework.ui.Model;
import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @Autowired  // 컴포넌트 스캔
    public MemberController(MemberService memberService) {   // SpringConfig 의 memberService()를 넣어줌

        this.memberService = memberService;
        // 실행시 error 발생 : 'hello.hellospring.service.MemberService' that could not be found.
        // 멤버서비스를 찾을 수 없다?? => autowired는 스프링컨테이너에서 멤버서비스를 가져와야하는데 안됨
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());     // 멤버생성

//        System.out.println("member = " + member.getName()); // 콘솔에 출력

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        // Model addAttribute(String name, Object value) : value 객체를 name 이름으로 추가, 뷰 코드에서는 name으로 지정한 이름을 통해서 value를 사용
        return "members/memberList";
    }
}

/*  스프링 빈을 등록하는 2가지 방법
    1. 컴포넌트 스캔과 자동 의존관계 설정(@ 애노테이션 사용)
    2. 자바 코드로 직접 스프링 빈 등록
* */

/*  DI에는 필드 주입, setter 주입, 생성자 주입 이렇게 3가지 방법 有
    의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 생성자 주입을 권장
* */

/*  실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔 사용
    정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록
* */

/*  @Autowired 를 통한 DI는 helloController , memberService 등과 같이 스프링이 관리하는 객체에서만 동작
    스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작 X
* */
