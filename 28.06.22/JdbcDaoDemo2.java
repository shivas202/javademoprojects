package studentpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDaoDemo2 {

	public static void main(String[] args) {
		
		TheChildDAO dao2 = new TheChildDAO();
		Child c2 = new Child();
		c2.rollNo = 4;
		c2.Childname = "laxman";
		dao2.connect();
		dao2.addChild(c2);
	}
}

class TheChildDAO
{
	Connection con = null;
	public void connect()
		{
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivadb", "root", "Shiv@hari1mysql");	
			} 
			catch (Exception Ex) 
			{
				System.out.println(Ex);
			}
			
		}

public Child getChild(int rollNo) 
{
String Query = "select Childname from child where rollno="+rollNo;
			Child c = new Child();
			c.rollNo = rollNo;
			try {
				Statement st;
				st = con.createStatement();
				ResultSet rs = st.executeQuery(Query);
				rs.next();
				String name = rs.getString(1);
				c.Childname = name;
				return c;
			} catch (Exception ex) {
				System.out.println(ex);				
			}
			return null;
}

		public void addChild(Child c)
		{
			String Query = "insert into child values (?,?)";
			PreparedStatement pst;
			try {
				pst = con.prepareStatement(Query);
				pst.setInt(1, c.rollNo);
				pst.setString(2, c.Childname);
				pst.executeUpdate();
			}
			catch (Exception Ex)
			{
				System.out.println(Ex);
			}
			
		
	}
}

