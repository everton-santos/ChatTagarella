package br.com.chattagarella.aplicacao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoockiesManager {
	
	private static final String USER_NAME = "cookie1";
	private static final String USER_ID = "cookie2";
	
	
	public static String getUserName(HttpServletRequest request )
	{
		return getCookie(request, USER_NAME);
	}
	public static String getUserId(HttpServletRequest request )
	{
		return getCookie(request, USER_ID);
	}
	
	public static void setUserName(HttpServletResponse response,String valor)
	{
		setCookie(response, USER_NAME, valor);
	}
	
	public static void setUserId(HttpServletResponse response,String valor)
	{
		setCookie(response, USER_ID, valor);
	}
	
	public static void setCookie(HttpServletResponse response, String cookieNome, String cookieValor)
	{
		Cookie cookie  = new Cookie(cookieNome, cookieValor);
		response.addCookie(cookie);
	}
	
	public static String getCookie(HttpServletRequest request, String cookieNome)
	{
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				
				Cookie cookie = cookies[i];
				
				if (cookie.getName().equals(cookieNome) ) {
					
					return cookie.getValue();
				}
			}	
		}
		return "";
	}
	

}
