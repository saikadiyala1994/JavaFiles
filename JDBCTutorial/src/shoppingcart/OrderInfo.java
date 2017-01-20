package shoppingcart;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
*/
public class OrderInfo {
	int pid;
	String title;
	double price;
	public OrderInfo(int pid, String title, double price) {
		super();
		this.pid = pid;
		this.title = title;
		this.price = price;
	}
/*public void orders(int uid) throws SQLException{
	Connection conn;
	Statement stmt;
	try {
		Class.forName("org.postgresql.Driver");
		conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Sehwag@219");
		stmt=conn.createStatement();
		int userid=uid;
		//String query="insert into orderinfo values("+pid+",'"+title+"','"+price+"',"+userid+")";
		//String query2="update orderinfo set title='"+title+"',price="+price+" where pid="+pid+"";
		String query3="delete from orderinfo where pid="+pid+"";
		stmt.executeUpdate(query3);
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}*/
	@Override
	public String toString() {
		return " "+pid+" "+" "+title+" "+price;
	}
}

		
	
	


