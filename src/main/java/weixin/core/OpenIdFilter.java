package weixin.core;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpenIdFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		String openid = (String)((HttpServletRequest)request).getSession().getAttribute("openid");
		if(openid == null){
			((HttpServletResponse)response).sendRedirect("/weixin/error/oauthError.html");
			return;
		}
		
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}

}
