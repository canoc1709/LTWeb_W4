package ltweb05.models;

import java.io.Serializable;

public class RoleModel implements Serializable{
	
	private int roleid;
	private String rolename;
	
	public RoleModel() {
		super();
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}
	
	public RoleModel(int roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}

	@Override
	public String toString() {
		return "RoleModel [roleid=" + roleid + ", rolename=" + rolename + "]";
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
}
