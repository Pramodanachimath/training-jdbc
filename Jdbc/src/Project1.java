import java.sql.*;

public class Project1 {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbc12";
		String uname="root";
		String pass="root";
		 Connection con=null;
		 Statement statement=null;
		 String query="Select * from employee";
		try {
			con = DriverManager.getConnection(url,uname,pass);
			 statement=con.createStatement();	
			ResultSet set=statement.executeQuery(query);
			while(set.next()) {
				System.out.println(set.getString("emp_name")+" "+set.getInt("emp_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (con != null) {
					con.close();
					
					if (statement != null) {
						statement.close();
					}
				}

			}  catch (SQLException e) {
			e.printStackTrace();
		}
		  
		 }
		 
		 
	}
	
	 
}
