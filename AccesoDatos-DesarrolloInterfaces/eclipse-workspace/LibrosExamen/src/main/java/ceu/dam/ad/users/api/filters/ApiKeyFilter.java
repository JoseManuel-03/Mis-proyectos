package ceu.dam.ad.users.api.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class ApiKeyFilter extends OncePerRequestFilter{

	@Value("${api-key}")
	private String apiKey;

	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String requestURI = request.getRequestURI();
		return (requestURI.startsWith("/swagger") || requestURI.startsWith("/api-doc"));
	}

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String apiKeyRequest = request.getHeader("API-KEY-USER");
		if (apiKey.equals(apiKeyRequest)) {
			filterChain.doFilter(request, response);
		} else {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.getWriter().write("NOT IN MY HOOUSEEEE !!!!");
		}
	}

}
