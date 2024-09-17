package ltweb05.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ltweb05.models.LoginModel;
import ltweb05.models.UserModel;
import ltweb05.services.implement.userServiceImplement;

//@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/login", "/abc"})
public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String action = req.getParameter("action");
		if("Đăng nhập".equals(action))
		{
			//Lấy tham số từ view
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			//Xử lý 
			String alertMsg = "";
			if (username.isEmpty() || password.isEmpty()) {
				alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
				
				//Trả về tham số lại cho Views trên trang login
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/Views/login.jsp").forward(req, resp);
				return;
			}
			userServiceImplement service = new userServiceImplement();
			//		IUserService service = new userServiceImplement();

			UserModel user = service.login(username, password);

			if (user != null) {
				HttpSession session = req.getSession(true);
				
				//Session account, nếu còn thời gian thì đăng nhập luôn
				session.setAttribute("account", user);
				resp.sendRedirect(req.getContextPath() + "/waiting");
			} else {
				alertMsg = "Tài khoản hoặc mật khẩu không đúng";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/Views/login.jsp").forward(req, resp);
			}
		}
		else if ("Đăng ký".equals(action))
		{
			req.getRequestDispatcher("/Views/register.jsp").forward(req, resp);
		}
		else if ("Quên mật khẩu".equals(action)) {
			req.getRequestDispatcher("/Views/forgotpassword.jsp").forward(req, resp);
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String alertMsg = " ";
		alertMsg = "This is doGet!";
		req.setAttribute("alert", alertMsg);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/waiting");
					return;
				}
			}
		}
		req.getRequestDispatcher("/Views/login.jsp").forward(req, resp);
	}
}