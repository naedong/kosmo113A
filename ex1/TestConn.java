
package ex1;
import java.sql.Connection;
import java.sql.SQLException;

// 시범 접속 테스트 
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
public class TestConn {
	private static DataSource ds;
	static {
		// 이미 로드된 설정 인  context.xml을 현재 자바가 찾아오는 객체 
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myora");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConn() throws SQLException {
		return ds.getConnection();
	}
}
