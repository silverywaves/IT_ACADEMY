package Ch17;

import java.util.HashMap;
import java.util.Map;

class AuthController{
	// ID/PW 저장
	private static Map<String, Integer> map = new HashMap<>();

	// CRUD
	public static boolean Insert(String id, Integer pw) {
		if(map.containsKey(id)) {	// ID 중복 방지 조건문 -> containsKey 동일한 키가 있는지 확인
			System.out.println("[ERROR]동일 ID가 존재합니다.");
			return false;
		}
		map.put(id, pw);	// ID 중복시 덮어쓰기 되어버림 -> 방지 조건문 넣어주기
		return true;
	}
	public static Integer Select(String id) {
		return map.get(id);
	}
	public static Map<String, Integer> SelectAll() {
		for(String key : map.keySet())	// keySet() ㅣ 모든 키를 Set 컬렉션으로 전달
			System.out.println("KEY : " + key + " value : " + map.get(key));
		return map;
	}
	public static boolean Update(String id, Integer pw) {	// 수정이나 삭제를 위해서는 탐색이 선행되어야 함
		map.replace(id,pw);
		return true;
	}
	public static boolean Deleete(String id) {
		map.remove(id);
		return true;
	}
	
}

public class C05MapMain {

	public static void main(String[] args) {
		// INSERT
		AuthController.Insert("aaa", 111);
		AuthController.Insert("bbb", 222);
//		AuthController.Insert("bbb", 555);		// id 중복
		AuthController.Insert("ccc", 333);
		AuthController.Insert("ddd", 444);
		
		// SELECT
		AuthController.Select("ccc");
		
		//SELECTALL
		AuthController.SelectAll();		// 모든 것을 조회할거라 빈괄호
		
	}
}
