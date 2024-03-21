package Ch17;

import java.util.HashMap;
import java.util.Map;

public class C04MapMain {

	public static void main(String[] args) {
		
		Map<String,Integer> map = new HashMap<>();
		
		// 추가
		map.put("aaa", 1234);
		map.put("bbb", 3333);
		map.put("ccc", 2222);
		map.put("ddd", 1111);	// id 중복 <- 이게 삭제
		map.put("ddd", 4444);	// id 중복
		
		// 삭제
		map.remove("aaa");
		
		// 개수
		System.out.println("SIZE " + map.size());
		
		// 조회(단건)
		System.out.println(map.get("bbb"));
		
		// 조회(전체)
		for(String key : map.keySet())	// set<string>
			System.out.println(key + " : " + map.get(key));
	}
}
