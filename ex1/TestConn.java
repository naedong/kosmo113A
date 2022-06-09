
package ex1;
import java.sql.Connection;
import java.sql.SQLException;

// �ù� ���� �׽�Ʈ 
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
public class TestConn {
	private static DataSource ds;
	static {
		// �̹� �ε�� ���� ��  context.xml�� ���� �ڹٰ� ã�ƿ��� ��ü 
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
