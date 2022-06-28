package studentpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDaoDemo {

	public static void main(String[] args) {
		
		ChildDAO dao = new ChildDAO();
		Child c1 = dao.getChild(2);
		System.out.println(c1.Childname);
	}
}

class ChildDAO
{
	public Child getChild(int rollNo) 
	{
		try {
			String Query = "select Childname from child where rollno="+rollNo;
			Child c = new Child();
			c.rollNo = rollNo;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivadb", "root", "Shiv@hari1mysql");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Query);
			rs.next();
			String name = rs.getString(1);
			c.Childname = name;
			return c;
		} catch (Exception ex) 
		{
			System.out.println(ex);
			}
		return null;
	}
}

class Child
{
	int rollNo;
	String Childname;
}