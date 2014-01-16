package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.PreparedStatement;


public class Main {
	public static void main(String[] args) {
		Connection conn = null;
		String tempk = "iddqd1337ATB";
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://46.163.118.54/csharp_atb?user=atb&password="+tempk);
			//createSampleTables(conn);
			
			Statement stmt = conn.createStatement();
			
			System.out.println("---Start---");
			ResultSet rs = stmt.executeQuery("SELECT * FROM Map;");
			showRS(rs,2);
			
			System.out.println("---Insert Difficulty---");
			//stmt.executeUpdate("delete from MapDifficulty where MDif_ID = 5;");
			stmt.executeUpdate("insert into MapDifficulty values(5, 'impossible', 115)");
			rs = stmt.executeQuery("SELECT * FROM MapDifficulty;");
			showRS(rs,2);
			
			stmt.executeUpdate("delete from MapDifficulty where MDif_ID = 5;");
			//stmt.executeUpdate("delete from MapDifficulty where MDif_ID = 1;");
			System.out.println("---jetzt nach delete von MDif_ID = 5---");
			rs = stmt.executeQuery("SELECT * FROM MapDifficulty;");

			showRS(rs,2);
			stmt.close();
			
			
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select * from Map;");
			rs = pstmt.executeQuery();
			System.out.println("---Map mit preparedstatement selectet---");
			showRS(rs,2);
			
			pstmt.close();
			rs.close();
			

		} catch (Exception e) {
			// For the sake of this tutorial, let's keep exception handling simple
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}

	private static void showRS(ResultSet rs, int num)
	{
		try {
			while ( rs.next() ) {
				for(int i = 1; i<=num; i++)
					System.out.print(rs.getString(i) + " ");
				System.out.println("");
			}
		} catch (SQLException e) {
			System.out.println("FEHLER");
			
		} catch (Exception e){
			System.out.println(e.getMessage());
		}	
	}
}
