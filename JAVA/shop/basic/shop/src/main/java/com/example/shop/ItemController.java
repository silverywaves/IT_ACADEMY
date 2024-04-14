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
    private final ItemRepository itemRepository;  // repository 등록(itemRepository에 DB 입출력 함수가 잔뜩 들어있음)   <- new ItemRepository()
        // 참고 : Lombok 없이 등록하려면 Alt+Insert 단축키로 Constructor 생성 후 @Autowired
        // @Autowired  
        // public ItemController(ItemRepository itemRepository) {
        //     this.itemRepository = itemRepository;
        //     // => new ItemRepository() 하나 뽑아서 itemRepository 변수에 넣으라고 지시
        // }
    private final ItemService itemService;    // 변수 등록    <- new ItemService()
    private final ListService listService;
    private final UpdateService updateService;

    // 만약 Lombok @RequiredArgsConstructor 안쓰면 이렇게 적어야 함
    @Autowired    // 각 클래스에서 object 알아서 뽑아서 각 변수에 넣어달라는 뜻
    public ItemController(ItemRepository itemRepository, ItemService itemService){    // Dependency Injection : 1. object 여러개 생성하지 않아도 되어서 효율적 2. 클래스간 커플링(연관성) 감소효과
        this.itemRepository = itemRepository;
        this.itemService = itemService;
    }
    
    @GetMapping("/list")
    String list(Model model){   // <HTML에 서버데이터 넣기> 1. 파라미터에 Model model 넣기
        // 3. repository.입출력문법() 쓰기
//         var result = itemRepository.findAll();  // findAll() : 테이블의 모든 데이터를 List 자료형으로 가져옴
//         System.out.println(result);
        
//         // => 여러 데이터를 한 변수에 넣으려면 ArrayList
//         // ArrayList 형식 [자료1, 자료2] : 자료를 컴마로 구분하여 출력(=JS의 array)
//         // ArrayList<ArrayList에 보관할 자료타입=출력중인 테이블 클래스> a = new ArrayList<>(); // 다양한 타입을 넣고 싶을때는 Object
//         // List<Object> a = new ArrayList<>();    // List : ArrayList 의 상위타입
//         // a.add(30);
//         // a.add(40);
//         // System.out.println(a.get(0));    // ArrayList에서 하나만 출력
//         List<Item> result = itemRepository.findAll();
//         System.out.println(result.get(0).price);
//         System.out.println(result.get(0).title);

//         // object만 출력하면 아무것도 안나와서 불편함 -> object 변수들 한번에 출력하는 법
//         // Item.java 이동 => toString 함수 재정의 or (Lombok 사용시) @ToString 사용
//         var a = new Item();
//         System.out.println(a.toString());
// //        System.out.println(a.getClass());
// //        a.setTitle("abc");  // a.title 에 들어감
        
//         model.addAttribute("name","비싼바지");   // 2. model.addAttribute(전달할 데이터 이름, 데이터) : 데이터가 해당이름으로 .html에 전달됨

        listService.listItem(model);

        return "list.html";

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    // ajax로 데이터전송하면 @RequestBody 써야 출력 가능
    //  2-1. 전송버튼 누르면 서버로 보내기 => POST method 요청시 서버로 데이터 전송 가능
    @PostMapping("/add")  
    // 유저가 <form>으로 보낸 데이터 출력
   String addPost(@RequestParam(name = "title") String title, Integer price) { // 여기에 기재된 타입으로 변환하라는 뜻, @RequestParam(name="title")는 생략가능
    // String addPost(@RequestParam Map formData) {  // <input>이 많다면? Map 자료형으로 유저가 보낸 모든 데이터 변환해서 한 변수에 다 담을 수 있음
//        System.out.println(formData);
//        System.out.println(title);
//        System.out.println(price);
        // 3. 서버는 검사 후 이상없으면 DB에 저장

        // 기능 분리하기(함수에는 하나의 기능만 넣는 것을 권장함 & 하나의 클래스엔 비슷한 기능의 함수들만 보관하는게 좋음)
        // Controller 는 보통 데이터나 html 보내는 역할 -> DB 입출력기능 다른 함수로 분리
        // DB 입출력 기능    => ItemService 로 이동
        // Item item = new Item();
        // item.setTitle(title);
        // item.setPrice(price);

//        new ItemService().saveItem(String title, Integer price);
        // 다른 Class 함수 사용시 new Class().함수() 비추천 -why?-> Post 요청이 들어올때마다 object 새로 뽑으면 비효율적
        // => 다른데서 미리 new Class() 해놓고 재사용하는게 좋음  <- 스프링한테 시키면 해줌
        // 1. new Class() 할 클래스에 @Service or @Repository or @Component
        // 2. 사용할 곳에서 변수로 등록
        // 3. 변수사용
        itemService.saveItem(title, price);
        
//        itemRepository.save(item의 object);
        // itemRepository.save(item);    // html 보내는 기능

        // // var test = new HashMap<>();
        // // HashMap<key의 타입, value의 타입>
        // HashMap<String, Object> test = new HashMap<>();
        // // test.put("자료형이름","값")
        // test.put("name", "kim");
        // test.put("age", 20);
        // System.out.println(test.get("name");    // Map에서 자료 하나만 뽑아내기

        return "redirect:/list";    // redirect : 특정페이지로 돌아가게 만들 수 있음
        
    }
    // 2-2
    // @PostMapping("/add")
    // String addPost(@ModelAttribute Item item){  // @ModelAttribute : <input> 데이터들을 바로 object로 변환
    //     System.out.println(item);
    //     itemRepository.save(item);
    //     return "redirect:/list";
    // }



    // /detail/1 접속시 1번상품 보여주기, /detail/2 접속시 2번상품 보여주기, ...
    // => URL 파라미터 문법 사용! 비슷한 URL의 API 여러개 만들 필요 X => @GetMapping("/detail/{작명}" - 여러개 가능)
//     @GetMapping("/detail/{id}")
//     String detail(@PathVariable long id, Model model){
// //        System.out.println(id);
//         // id가 1인 행을 불러오기 => repository변수.findById(행번호)
//         Optional<Item> result = itemRepository.findById(id);  // 기재한 행번호에 자료가 비어있을수도 있기때문에 Optional 사용
//         // Spring Data JPA 사용 시 Repository에서 리턴 타입을 Optional로 바로 받을 수 있도록 지원
//         // Optional : 'nu.isPresenll일 수도 있는 객체'를 감싸는 일종의 Wrapper 클래스
//         if(result.isPresent()) {    // result에 데이터가 있으면 아래 내용 수행
// //            System.out.println(result.get());   // result가 비어있는 상태일수도 있으니 그냥 get() 사용시 위험 -> if문으로 조건 설정
//             model.addAttribute("data",result.get());
//             return "detail.html";
//         } else {
//             return "redirect:/list";
//         }
//     }

    // 예외처리
    @GetMapping("/detail/{id}")
    String detail(@PathVariable long id, Model model) throws Exception {  // throws Exception : 이 함수는 에러를 뱉는다(정지시킨다는 경고)
//        try {
//            Optional<Item> result = itemRepository.findById(id);
//            if (result.isPresent()) {
//                model.addAttribute("data", result.get());
//                return "detail.html";
//            } else {
//                return "redirect:/list";
//            }
//    }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//        }   // => 유저가 타입을 이상하게 보내는 에러는 처리하지 못함

        // => 모든 에러를 캐치 : @ExceptionHandler
//    @ExceptionHandler(Exception.class)
//    public void handler(){  // 옆에 있는 모든 API에서 Exception 발생시 안의 코드 실행
//        return ResponseEntity.status(400).body("에러");
//    }
        // => 모든 Controller 파일의 에러 캐치 : @ControllerAdvice 사용 -> MyExceptionHandler 이동
        throw new Exception();
    }

    // 상품 수정
    @GetMapping("/change/{id}")
    String change(@PathVariable long id, Model model) {
    Optional<Item> result = itemRepository.findById(id);
    if(result.isPresent()){
        model.addAttribute("data", result.get());
        return "change.html";
    } else {
        return "redirect:/list";
    }
    }

    @PostMapping("/update")
    String updateItem(Long id, String title, Integer price){
        updateService.updateItem(id, title, price);
        return "redirect:/list";
    }

        
}
