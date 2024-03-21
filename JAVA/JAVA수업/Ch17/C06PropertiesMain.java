package Ch17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class C06PropertiesMain {

	public static void main(String[] args) throws Exception {
		
		// 2
		String classPath = System.getProperty("java.class.path");
//		System.out.println("classPath : " + classPath);
		String dirPath = System.getProperty("user.dir");
//		System.out.println("DirPath : " + dirPath);
		String packagePath = C06PropertiesMain.class.getPackageName();
//		System.out.println("packagePath : " + packagePath);
		String filePath = dirPath + File.separator/*구분자*/ + "src" + File.separator + packagePath + File.separator + "application.properties";
//		System.out.println("FILEPATH : " + filePath);
		
		Properties properties = new Properties();
//		FileInputStream fin = new FileInputStream("파일경로"); 단방향으로 파일 받아올때
		FileInputStream fin = new FileInputStream(filePath);	
		// 경로를 직접 넣어줬음 -> 경로를 편하게 하는 다른 방법 있음 -> 2 확인
		properties.load(fin);
		
		// getProperty() : properties 에 저장된 값을 읽어옴 (읽어오려는 키가 없으면 지정된 기본값 반환)
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		System.out.printf("%s\n%s\n%s\n", url, username, password);
	}
	
}
