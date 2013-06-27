package danyu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectDB {

	public static void viewTable(Connection con, String dbName)
		    throws SQLException {

		    Statement stmt = null;
		    String query = "select * " +
		                   "from Sketches";
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            String sketchName = rs.getString("Name");
		            float price = rs.getFloat("UnitPrice");
		            
		            System.out.println(sketchName +
		                               "\t" + price );
		        }
		    } catch (SQLException e ) {
		        e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		}
	
	public static Connection setConn(String connStr){
		Connection con=null;
		try {
			con=DriverManager.getConnection(connStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   String connUrl="jdbc:sqlserver://localhost;databaseName=master;user=danyu;password=123456";
	   Connection conn=setConn(connUrl);
	   try {
		viewTable(conn, "master");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
