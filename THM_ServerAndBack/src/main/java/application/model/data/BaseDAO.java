package application.model.data;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {

	Connection conn;

	BaseDAO() {
		try {
	          //  Treiber laden
	          DriverManager.registerDriver ((Driver) new com.mysql.jdbc.Driver());
//	          String str = "jdbc:mysql://localhost:3306/wine_test_db";
	          String str2 = "jdbc:mysql://localhost:3306/wine_test_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	          conn = DriverManager.getConnection(str2, "WineTastingApplication", "root");

	      } catch(SQLException e) {
	          e.printStackTrace();
	      }
	}
}
