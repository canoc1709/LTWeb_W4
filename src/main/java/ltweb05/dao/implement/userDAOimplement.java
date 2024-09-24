package ltweb05.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import ltweb05.config.DBConnectMySQL;
import ltweb05.dao.IUserDAO;
import ltweb05.models.UserModel;

public class userDAOimplement extends DBConnectMySQL implements IUserDAO {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {
		String sql = "Select * from users";

		List<UserModel> list = new ArrayList<>();
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("email"), rs.getString("username"),
						rs.getString("fullname"), rs.getString("phone"), rs.getString("image"), rs.getInt("roleid"),
						rs.getString("password")));

			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findByID(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM users WHERE id = (?)";

		try {

			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			List<UserModel> list = new ArrayList<>();

			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("email"), rs.getString("username"),
						rs.getString("fullname"), rs.getString("phone"), rs.getString("image"), rs.getInt("roleid"),
						rs.getString("password")));
			}
			return list.getFirst();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO `users` (email, username, fullname, phone, image, roleid, password) VALUES (?,?,?,?,?,?,?)";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getImage());
			ps.setInt(6, user.getRoleid());
			ps.setString(7, user.getPassword());
			ps.executeUpdate();
			
			System.out.println("Run!");
		} catch (Exception e) {
			System.out.println("Failed!");
			e.printStackTrace();
		}
	}

	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
//				UserModel user = new UserModel(rs.getInt("id"), rs.getString("email"), rs.getString("username"),
//						rs.getString("fullname"), rs.getString("phone"), rs.getString("image"), rs.getInt("roleid"),
//						rs.getString("password"));
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPhone(rs.getString("phone"));
				user.setImage(rs.getString("image"));
				user.setRoleid(rs.getInt("roleid"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel get(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from [user] where email = ?";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from [User] where username = ?";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		boolean duplicate = false;
		String query = "select * from [User] where phone = ?";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	public static void main(String[] args) {
		userDAOimplement u = new userDAOimplement();
		u.insert(new UserModel("22110219@student.hcmute.edu.vn", "555", "Đồng Gia Sang", "0842485539", "image", 2, "555"));
		
		UserModel user = u.findByID(4);
		System.out.println(user);
	}

	@Override
	public boolean checkValidEmail(String email) {
		String regex = "^(.+)@(\\S+)$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		System.out.println(matcher.matches());
		return matcher.matches();
		
	}

	@Override
	public boolean checkValidPhone(String phone) {
	
		return false;
	}

	@Override
	public void updateUserPassword(String email, String newPassword) {
		String sql = "UPDATE users SET password = ? WHERE email = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, email);
			ps.executeUpdate();
			System.out.println("Run!");
		} catch (Exception e) {
			System.out.println("Failed!");
			e.printStackTrace();
		}
		
	}

}
