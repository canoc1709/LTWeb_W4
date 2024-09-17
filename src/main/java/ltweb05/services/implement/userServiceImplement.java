package ltweb05.services.implement;

import java.security.DomainCombiner;
import java.sql.Date;

import ltweb05.dao.implement.userDAOimplement;
import ltweb05.models.UserModel;
import ltweb05.services.IUserService;

public class userServiceImplement implements IUserService {

	userDAOimplement userDAO = new userDAOimplement();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	public UserModel findByUserName(String username) {
		return userDAO.findByUserName(username);
	}

	@Override
	public UserModel get(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserModel user) {
		userDAO.insert(user);
	}

	@Override
	public boolean register(String email, String username, String fullname, String phone, 
			String image, int roleid, String password) {
		if (userDAO.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userDAO.insert(new UserModel(email, username, fullname, phone, image, roleid, password));
		return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		return userDAO.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		return userDAO.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return userDAO.checkExistPhone(phone);
	}
	
	public static void main(String[] args) {
		IUserService userService = new userServiceImplement();
	}
}
