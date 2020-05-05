package hjs.model;

public class Userinfo {
	private int id;
	private String username;
	private String Password;
	private String txtemail;

 
     public Userinfo(){
	 super();
      }

	public Userinfo(String username,String Password) {
             super();
          this.username=username;
          this.Password=Password;
 } 

public Userinfo(String userName, String password, String email) {
	   this.username=userName;
	    this.Password=password;
	    this.txtemail=email;
}

public String getTxtemail() {
	     return txtemail;
}
public void setTxtemail(String txtemail) {
	     this.txtemail = txtemail;
}
public String getUsername() {
	    return username;
}
public int getId() {
	    return id;
}
public void setId(int id) {
	    this.id = id;
}
public String getUserName() {
	    return username;
}
public void setUsername(String username) {
	   this.username = username;
}
public  String getPassword() {
	   return Password;
}
public void setPassword(String Password) {
	   this.Password = Password;
}

}
