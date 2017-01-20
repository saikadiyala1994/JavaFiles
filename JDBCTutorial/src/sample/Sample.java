package sample;

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
			//String st="Vijay";
			//int i=6;
			ResultSet res=stmt.executeQuery("select firstname from customer_details where firstname ='"+st+"'");
			if(res!=null){
				String name=null;
				String location=null;
				long id=0;
				while(res.next()){
					name=res.getString("firstname");
					//location=res.getString("location");
					//id=res.getLong("id");
					System.out.println(name);
					
					
					}
			}
			
			String city="Mysore";
			String loc="Karnataka";
			String query="insert into cities(name,location) values('"+city+"','"+loc+"')";
			int r=stmt.executeUpdate(query);
					System.out.println("no of rows inserted" +r);
			
			ResultSet res1=stmt.executeQuery("select id,name,location from cities");
			if(res1!=null){
				String name=null;
				String location=null;
				long id=0;
				while(res1.next()){
					name=res1.getString("name");
					location=res1.getString("location");
					id=res1.getLong("id");
					System.out.println(id + ":"+name+" :"+location);
					
					
					}
			}
				String updatequery="update cities set name='Gutur',location='AndhraPradesh' where id=5";
				int u=stmt.executeUpdate(updatequery);
				System.out.println("No of rows updated "+u);
				ResultSet res2=stmt.executeQuery("select id,name,location from cities order by id");
				if(res2!=null){
					String name=null;
					String location=null;
					long id=0;
					while(res2.next()){
						name=res2.getString("name");
						location=res2.getString("location");
						id=res2.getLong("id");
						System.out.println(id + ":"+name+" :"+location);
						
						
						}
			}
				String deletequery="delete from cities where location='Karnataka'";
				int d=stmt.executeUpdate(deletequery);
				System.out.println("No of rows deleted"+d);
				
			
			ResultSet res3=stmt.executeQuery("select id,name,location from cities order by id");
			if(res3!=null){
				String name=null;
				String location=null;
				long id=0;
				while(res3.next()){
					name=res3.getString("name");
					location=res3.getString("location");
					id=res3.getLong("id");
					System.out.println(id + ":"+name+" :"+location);
					
					
					}
		}
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
