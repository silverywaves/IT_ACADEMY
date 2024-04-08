package hello.hellospring.domain;

public class Member {

    // 1. 요구사항 (id, name)
    private Long id;        // 임의의 값(데이터베이스 or 시퀀스) <- 고객이 정하는 id 가 아니라 시스템이 저장하는 id
    private String name;

    // 2. getter & setter -> 3. 회원 객체를 저장하는 저장소(repository 인터페이스) 생성
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
