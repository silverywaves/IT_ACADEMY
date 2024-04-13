package com.example.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor    // lombok 으로 repository 등록시 사용하는 어노테이션
public class ItemController {       // public : 다른 폴더에서도 사용 가능(없으면 같은 폴더 안에서만 사용가능)
    // /list 페이지로 접속하면 상품목록 페이지 보내주기

    // JPA 데이터 입출력 3-STEP
    // 1. repository 만들기 => ItemRepository Interface 생성
    // 2. 원하는 클래스에 repository 등록
    private final ItemRepository itemRepository;  // repository 등록(itemRepository에 DB 입출력 함수가 잔뜩 들어있음)
        // 참고 : Lombok 없이 등록하려면 Alt+Insert 단축키로 Constructor 생성 후 @Autowired
        // @Autowired
        // public ItemController(ItemRepository itemRepository) {
        //     this.itemRepository = itemRepository;
        //     // => new ItemRepository() 하나 뽑아서 itemRepository 변수에 넣으라고 지시
        // }
    
    @GetMapping("/list")
    String list(Model model){   // <HTML에 서버데이터 넣기> 1. 파라미터에 Model model 넣기
        // 3. repository.입출력문법() 쓰기
        var result = itemRepository.findAll();  // findAll() : 테이블의 모든 데이터를 List 자료형으로 가져옴
        System.out.println(result);
        
        // => 여러 데이터를 한 변수에 넣으려면 ArrayList
        // ArrayList 형식 [자료1, 자료2] : 자료를 컴마로 구분하여 출력(=JS의 array)
        // ArrayList<ArrayList에 보관할 자료타입=출력중인 테이블 클래스> a = new ArrayList<>(); // 다양한 타입을 넣고 싶을때는 Object
        // List<Object> a = new ArrayList<>();    // List : ArrayList 의 상위타입
        // a.add(30);
        // a.add(40);
        // System.out.println(a.get(0));    // ArrayList에서 하나만 출력
        List<Item> result = itemRepository.findAll();
        System.out.println(result.get(0).price);
        System.out.println(result.get(0).title);

        // object만 출력하면 아무것도 안나와서 불편함 -> object 변수들 한번에 출력하는 법
        // Item.java 이동 => toString 함수 재정의 or (Lombok 사용시) @ToString 사용
        var a = new Item();
        System.out.println(a.toString());
//        System.out.println(a.getClass());
//        a.setTitle("abc");  // a.title 에 들어감
        
        model.addAttribute("name","비싼바지");   // 2. model.addAttribute(전달할 데이터 이름, 데이터) : 데이터가 해당이름으로 .html에 전달됨
        return "list.html";

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    // ajax로 데이터전송하면 @RequestBody 써야 출력 가능
    //  2. 전송버튼 누르면 서버로 보내기 => POST method 요청시 서버로 데이터 전송 가능
    @PostMapping("/add")  
    // 유저가 <form>으로 보낸 데이터 출력
   String addPost(@RequestParam(name = "title") String title, Integer price) { // 여기에 기재된 타입으로 변환하라는 뜻, @RequestParam(name="title")는 생략가능
    // String addPost(@RequestParam Map formData) {  // <input>이 많다면? Map 자료형으로 유저가 보낸 모든 데이터 변환해서 한 변수에 다 담을 수 있음
//        System.out.println(formData);
//        System.out.println(title);
//        System.out.println(price);
        // 3. 서버는 검사 후 이상없으면 DB에 저장
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
//        itemRepository.save(item의 object);
        itemRepository.save(item);

        // var test = new HashMap<>();
        // HashMap<key의 타입, value의 타입>
        HashMap<String, Object> test = new HashMap<>();
        // test.put("자료형이름","값")
        test.put("name", "kim");
        test.put("age", 20);
        System.out.println(test.get("name");    // Map에서 자료 하나만 뽑아내기

        return "redirect:/list";    // redirect : 특정페이지로 돌아가게 만들 수 있음
        
    }

}
