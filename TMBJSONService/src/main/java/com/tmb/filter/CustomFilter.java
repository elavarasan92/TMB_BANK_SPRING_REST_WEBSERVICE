package com.tmb.filter;

import java.io.IOException;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

public class CustomFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		  HttpServletRequest httpRequest = (HttpServletRequest) request;
		  
		              Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		              
		  		              Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		  		              
	              if (roles.contains("ROLE_USER")) {
	            	  httpRequest.getSession().setAttribute("myVale", "myvalue");
	              }
		  
		              chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
