package ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 오라클 데이터베이스에 연동해서 member 테이블의 데이터를 조회하는 DAO 클래스
 */
public class MemberDAO {
	// 정적 상수(static constant): 오라클 데이터베이스의 접속 정보
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "c##scott";
	private static final String DB_PASSWORD = "tiger";

	// 오라클 데이터베이스에 연결하는 Connection 객체
	private Connection connection = null;

	// SQL 문을 실행하는 Statement 객체
	private Statement statement = null;

	// 데이터베이스를 조회한 결과를 담을 ResultSet 객체
	private ResultSet resultSet = null;

	/**
	 * member 테이블의 모든 레코드를 조회
	 * @return 조회한 레코드의 목록
	 */
	public List<MemberVO> getMemberList() {
		// member 테이블에서 조회한 레코드를 저장할 ArrayList 객체
		List<MemberVO> list = new ArrayList<>();

		// 데이터베이스에 연결하거나 조회하는 도중에 예외가 발생할 수 있으므로
		// try-catch 구문을 이용해 예외를 처리한다.
		try {
			// 오라클 데이터베이스에 연결
			connectDatabase();
			
			// 실행할 SQL 문을 작성
			String query = "SELECT * FROM member";
			System.out.println("QUERY: " + query);
			
			// Statement 객체를 이용해 SQL 문을 실행한 다음, 실행 결과를 ResultSet 객체에
			// 저장해서 반환
			resultSet = statement.executeQuery(query);

			// 반복자(iterator)를 이용해, ResultSet 객체에 저장된 레코드(행)을 차례대로 확인
			// → ResultSet 객체의 next 메서드는 ResultSet 객체의 커서(cursor)를
			//   다음 레코드로 이동시키며, 다음 레코드가 존재하면 true를, 없으면 false를
			//   반환한다.
			while (resultSet.next()) {
				// ResultSet 객체의 getInt 메서드 등을 이용해, ResultSet 객체의 커서가
				// 가리키는 레코드의 컬럼(column)을 참조
				int id = resultSet.getInt("id");
				String account = resultSet.getString("account");
				String passwd = resultSet.getString("passwd");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				Date regdate = resultSet.getDate("regdate");

				// MemberVO 객체를 생성해서 각 필드를 조회한 레코드의 컬럼으로 설정
				MemberVO member = new MemberVO(id, account, passwd, name, email, regdate);

				// ArrayList 객체에 MemberVO 객체를 추가
				list.add(member);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		// 예외(exception)가 발생하든 하지 않든 실행해야 할 문장은 finally 블록에 작성
		// → 데이터베이스에 연결해서 필요한 기능을 수행한 다음에는 반드시 연결을 해제해야
		//   한다. 따라서 데이터베이스의 연결을 해제하는 문장들은 finally 블록에 작성한다.
		finally {
			/*
			 * 데이터베이스의 연결을 해제할 때는 생성한 순서의 역순으로 객체들을 해제한다.
			 * 그래서 ResultSet 객체, Statement 객체, Connection 객체 순으로 해제한다.
			 * 이때 각 객체를 해제하면서 예외가 발생할 수 있으므로, 각 문장마다
			 * 별도의 예외 처리를 해줘야 한다.
			 * 위 객체들을 생성되지 않을 수도 있기 때문에, 반드시 객체가 생성됐는지
			 * 확인한 다음 해제한다.
			 */
			if (resultSet != null) try { resultSet.close(); } catch (Exception e) {}
			if (statement != null) try { statement.close(); } catch (Exception e) {}
			if (connection != null) try { connection.close(); } catch (Exception e) {}
		}

		// 생성한 ArrayList 객체를 반환
		return list;
	}
	
	/**
	 * 오라클 데이터베이스에 연결
	 */
	private void connectDatabase() {
		// 데이터베이스에 연결하는 도중에 예외가 발생할 수 있으므로 try-catch 구문을
		// 이용해 예외를 처리한다.
		try {
			// 1. 오라클 JDBC 드라이버를 로딩
			Class.forName(DB_DRIVER);
			System.out.println("Success to load the Oracle JDBC driver!");

			// 2. 오라클 데이터베이스에 연결해서 Connection 객체를 생성
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			System.out.println("Success to create the Connection object!");

			// 3. SQL 문을 실행하기 위해 Statement 객체를 생성
			statement = connection.createStatement();
			System.out.println("Success to create the Statement object!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
