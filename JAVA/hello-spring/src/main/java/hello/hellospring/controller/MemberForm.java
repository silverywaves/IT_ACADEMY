package hello.hellospring.controller;

public class MemberForm {
    private String name;    // createMemberForm.html 의 name에 매칭되어 값이 들어갈 것

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // => MemberController 이동하여 메서드 추가
}
