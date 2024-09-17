package ltweb05.services;

import java.sql.Date;

import ltweb05.models.UserModel;

public interface IUserService {

	UserModel login(String username, String password);

	UserModel get(String username);
	
	//Truy vấn xuống DAO để lấy dữ liệu
	UserModel findByUserName(String username);

	void insert(UserModel user);

	boolean register(String email, String username, String fullname, String phone, 
			String image, int roleid, String password);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
}
