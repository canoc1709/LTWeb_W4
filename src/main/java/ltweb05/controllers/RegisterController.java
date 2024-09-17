package ltweb05.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ltweb05.services.implement.userServiceImplement;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/register", "/def"})
public class RegisterController<Date> extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			resp.sendRedirect(req.getContextPath() + "/admin");
			return;
		}
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("username")) {
						session = req.getSession(true);
						session.setAttribute("username", cookie.getValue());
						resp.sendRedirect(req.getContextPath() + "/admin");
						return;
					}
				}
			}
			req.getRequestDispatcher("/ltweb05/src/main/webapp/Views/register.jsp").forward(req, resp);
		}


	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String image = req.getParameter("image");
		String roleid = req.getParameter("roleid");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		userServiceImplement service = new userServiceImplement();
		String alertMsg =
		"";
		
		if (service.checkExistEmail(email)) {
			alertMsg = "Email đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/Views/register.jsp").forward(req, resp);
			return;
			}
			if (service.checkExistUsername(username)) {
			alertMsg =
			"Tài khoản đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/Views/register.jsp").forward(req, resp);
			return;
			}
			
			boolean isSuccess = service.register(email, username, fullname, phone, image, Integer.parseInt(roleid), password);
			if (isSuccess) {
				//SendMail sm = new SendMail();
				//sm.sendMail(email, "Shopping.iotstar.vn", "Welcome to Shopping. Please Login to use service. Thanks !");
				req.setAttribute("alert", alertMsg);
				resp.sendRedirect(req.getContextPath() + "/login");
			} else {
				alertMsg = "System error!";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/Views/register.jsp").forward(req, resp);
			}
	}
}
