package ch7;

// 다형성 - 자손클래스의 인스턴스를 조상타입의 참조변수로 참조하는 것이 가능
// 인터페이스 타입의 참조변수로 이를 구현한 클래스의 인스턴스 참조 가능, 인터페이스 타입으로 형변환 가능
// => 인터페이스는 메서드의 매개변수 타입으로 사용 가능
//    => 메서드 호출시 해당 인터페이스를 구현한 클래스의 인스턴스를 매개변수로 제공해야 함

// 리턴타입이 인터페이스 = 메서드가 해당 인터페이스를 구현한 클래스의 인스턴스를 반환한다

interface Parseable{
	// 구문 분석작업 수행 목적으로 parse(String fileName) 정의
	public abstract void parse(String fileName);
}

class ParserManager{		
	// 리턴타입이 Parseable 인터페이스
	public static Parseable getParser(String type) {	// 매개변수로 넘겨받는 type 값에 따라 XMLParser 인스턴스 or HTMLParser 인스턴스 반환
		if(type.equals("XML")) {	
			return new XMLParser();	
		} else {
			Parseable p = new HTMLParser();
			return p;
			// return new HTMLParser();
		}
	}
}

class XMLParser implements Parseable{		// Parseable 인터페이스 구현
	public void parse(String fileName) {
		/* 구문 분석작업을 수행하는 코드 기재 */
		System.out.println(fileName + "-XML parsing completed.");
	}
}

class HTMLParser implements Parseable{		// Parseable 인터페이스 구현
	public void parse(String fileName) {
		/* 구문 분석작업을 수행하는 코드 기재 */
		System.out.println(fileName + "-HTML parsing completed.");
	}
}

class _39_ParserTest_인터페이스다형성 {
	public static void main(String[] args) {
		Parseable parser = ParserManager.getParser("XML");	// 참조변수 parser 는 XMLParser 인스턴스 주소값을 갖게 됨
		// =>  Parseable parser = new NMLParser();
		parser.parse("document.xml");		// parse 는 XMLParser 인스턴스를 가리킴
		// 참조변수 parser 를 통해 parse() 호출시, parser 가 참조하고 있는 XMLParser 인스턴스의 parse 메서드가 호출됨
		parser = ParserManager.getParser("HTML");
		parser.parse("document2.html");
	}
}
