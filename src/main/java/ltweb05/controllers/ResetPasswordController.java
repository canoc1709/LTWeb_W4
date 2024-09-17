package ltweb05.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ltweb05.dao.implement.userDAOimplement;
import ltweb05.models.UserModel;

@WebServlet(urlPatterns = {"/resetPassword"})
public class ResetPasswordController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newPassword = req.getParameter("newPassword");
        String confirmPassword = req.getParameter("confirmPassword");

        if (newPassword.equals(confirmPassword)) {
            // Cập nhật mật khẩu mới vào database
            String email = (String) req.getSession().getAttribute("email");
            updatePasswordInDatabase(email, newPassword);  // Gọi hàm để cập nhật mật khẩu
            
            // Xóa OTP khỏi session sau khi đặt lại mật khẩu thành công
            req.getSession().removeAttribute("otp");

            req.setAttribute("message", "Mật khẩu đã được đặt lại thành công.");
            try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            req.getRequestDispatcher("/Views/login.jsp").forward(req, resp); // Chuyển hướng tới trang đăng nhập
        } else {
            req.setAttribute("message", "Mật khẩu và xác nhận mật khẩu không khớp.");
            req.getRequestDispatcher("/Views/resetPassword.jsp").forward(req, resp);
        }
	}
	private void updatePasswordInDatabase(String email, String newPassword) {
		userDAOimplement u = new userDAOimplement();
		u.updateUserPassword(email, newPassword);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
