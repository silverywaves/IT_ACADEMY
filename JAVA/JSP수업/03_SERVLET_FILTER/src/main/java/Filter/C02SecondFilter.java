package Filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

//@WebFilter("/login")
public class C02SecondFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		// request 전 처리
		System.out.println("C02SecondFilter START------");
		chain.doFilter(req, resp);
		// response 후 처리
		System.out.println("C02SecondFilter END-------");
		
	}

}
