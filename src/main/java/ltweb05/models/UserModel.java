package ltweb05.models;

import java.io.Serializable;
import java.sql.Date;


public class UserModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String email;
	private String username;
	private String fullname;
	private String phone;
	private String image;
	private int roleid;
	private String password;
	private String createdDate;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImage() {
		return image;
	}
	public UserModel(int id, String email, String username, String fullname, String phone, String image, int roleid,
			String password){
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.phone = phone;
		this.image = image;
		this.roleid = roleid;
		this.password = password;
	}
	public UserModel()
	{
		
	}
	public UserModel(String email, String username, String fullname, String phone, String image, int roleid,
			String password){
		super();
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.phone = phone;
		this.image = image;
		this.roleid = roleid;
		this.password = password;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", email=" + email + ", username=" + username + ", fullname=" + fullname
				+ ", phone=" + phone + ", image=" + image + ", roleid=" + roleid + ", password=" + password + "]";
	}
	

	
	
}
