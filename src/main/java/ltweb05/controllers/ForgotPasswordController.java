package ltweb05.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
@WebServlet(urlPatterns = {"/forgotPassword"})
public class ForgotPasswordController  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String otp = req.getParameter("otp");
		String action = req.getParameter("action");
		//Nếu người dùng ấn gửi OTP
		if("sendOTP".equals(action))
		{
			if(otp != null || otp.isEmpty()) {
		        // Tạo mã OTP ngẫu nhiên
		        String otp_code = generateOtp(6);

		        // Lưu OTP vào session hoặc database tùy ý bạn
		        req.getSession().setAttribute("otp", otp_code);
		        req.getSession().setAttribute("email", email);

		        // Gửi OTP qua email
		        try {
		            sendOtpEmail(email, otp_code);
		            //req.setAttribute("showOtpSection", true);
		        } catch (MessagingException e) {
		            e.printStackTrace();
		            resp.getWriter().println("ERROR ROIIIIIIIII!");
		        }
		        req.getRequestDispatcher("/Views/forgotpassword.jsp").forward(req, resp);
			}
		}
		else if("confirmOTP".equals(action)){
			String sessionOtp = (String) req.getSession().getAttribute("otp");
			if (sessionOtp != null && sessionOtp.equals(otp)) {
				//resp.sendRedirect(req.getContextPath() + "/resetPassword");
				req.getRequestDispatcher("/Views/resetPassword.jsp").forward(req, resp);
            } else {
                resp.getWriter().println("OTP's not valid!");
            }
		}
	}
	
	private void sendOtpEmail(String recipientEmail, String otpCode) throws MessagingException, UnsupportedEncodingException {
	    // Thiết lập thông tin cấu hình SMTP cho Gmail
	    Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    
	    // Thiết lập tài khoản Gmail gửi email
	    final String username = "phamchung1.qtkd@gmail.com"; // Thay bằng email của bạn
	    final String password = "xahj avjd jljs fplp"; // Thay bằng mật khẩu ứng dụng của bạn (không phải mật khẩu email)
	    
	    // Tạo session với username và password của tài khoản gửi email
	    Session session = Session.getInstance(props, new Authenticator() {
	        @Override
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	        }
	    });

	    try {
	        // Tạo một email message
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(username, "YourAppName")); // Tên người gửi
	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail)); // Email người nhận
	        message.setSubject("Your OTP Code"); // Tiêu đề email
	        message.setText("Your OTP code is: " + otpCode); // Nội dung email

	        // Gửi email
	        Transport.send(message);

	        System.out.println("OTP Email sent successfully");
	    } catch (MessagingException e) {
	        throw new RuntimeException(e);
	    }
	}

    private String generateOtp(int length) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(rand.nextInt(10)); // Thêm số ngẫu nhiên từ 0-9
        }
        return sb.toString();
    }
    

	
}
