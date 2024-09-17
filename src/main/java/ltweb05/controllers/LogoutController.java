package ltweb05.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Hủy bỏ session
	    HttpSession session = req.getSession(false);
	    if (session != null) {
	      session.invalidate();
	    }

	    // Xóa cookie (tùy chọn)
	    Cookie cookie = new Cookie("username", "");
	    cookie.setMaxAge(0); // Xóa cookie ngay lập tức
	    resp.addCookie(cookie);

	    // Chuyển hướng về trang đăng nhập
	    resp.sendRedirect(req.getContextPath() + "/login");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
