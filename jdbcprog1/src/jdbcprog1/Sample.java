package jdbcprog1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sample {
	public static void main(String[] args) throws SQLException {
		Connection conn;
		Statement stmt;
		try {
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Sehwag@219");
			stmt=conn.createStatement();
			ResultSet res=stmt.executeQuery("select * from customer_details");
			System.out.println("fname:lname:cid:ssn:id");
			if(res!=null){
				String fname=null;
				String lname=null;
				String cid=null;
				String ssn=null;
				long id=0;
				while(res.next()){
					fname=res.getString("firstname");
					lname=res.getString("lastname");
					cid=res.getString("contractorid");
					ssn=res.getString("ssn");
					id=res.getLong("id");
					System.out.println(fname+":"+lname+":"+cid+":"+ssn+":"+id);
				}
				stmt.close();
				conn.close();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
