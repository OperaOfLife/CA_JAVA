package sg.edu.iss.caps.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	private RoleType role;
	
	
	
	public User() {
		super();
	}



	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public User(String username, String password, RoleType role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public RoleType getRole() {
		return role;
	}



	public void setRole(RoleType role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}



	


	



	
}
