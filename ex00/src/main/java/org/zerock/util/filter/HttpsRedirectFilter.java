package org.zerock.util.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class HttpsRedirectFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 리디렉션 처리
        if ("http".equals(request.getScheme())) {
            String redirectUrl = "https://" + request.getServerName() + request.getRequestURI();
            response.sendRedirect(redirectUrl);
            return;
        }
        filterChain.doFilter(request, response); // 계속 필터 체인 처리
		
	}

}
