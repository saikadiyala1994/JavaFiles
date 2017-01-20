package shoppingcart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginValid {
	public static void main(String[] args) {
			int userid=1;
			String password="Sehwag@21";
			Boolean b = true;
			try {
				b=isValidUser(userid,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(b==true)
				System.out.println("Userid and password are valid");
			else
				System.out.println("Userid and password are not valid");
			
		}

	private static Boolean isValidUser(int userid, String password) throws SQLException {
		Connection conn;
		Statement stmt;
		int i=0;
		try {
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Sehwag@219");
			stmt=conn.createStatement();
			ResultSet res=stmt.executeQuery("Select * from userinfo");
			if(res!=null){
			int id=0;
			String pass=null;
			while(res.next()){
				id=res.getInt("id");
				pass=res.getString("password");
				pass=pass.replaceAll("\\s", "");
				
				if(id==userid && pass.compareTo(password)==0){
					
					i++;
				}
			
			}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==0)
			return false;
			else
				return true;
		
		
	}

}
