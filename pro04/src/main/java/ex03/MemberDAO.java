package ex03;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * 오라클 데이터베이스에 연동해서 member 테이블의 데이터를 조회하는 DAO 클래스
 */
public class MemberDAO {
	// DBCP(Database Connection Pool)를 관리하는 DataSource 객체
	private DataSource dataSource = null;

	// 오라클 데이터베이스에 연결하는 Connection 객체
	private Connection connection = null;

	// SQL 문을 실행하는 Statement 객체
	private Statement statement = null;

	// SQL 문을 실행하는 PreparedStatement 객체
	private PreparedStatement preStatement = null;

	// 데이터베이스를 조회한 결과를 담을 ResultSet 객체
	private ResultSet resultSet = null;

	/**
	 * 생성자: JNDI를 통해 DataSource 객체를 생성
	 */
	public MemberDAO() {
		try {
			// Context 객체 생성
			Context context = new InitialContext();

			// Context 객체를 통해 JNDI에 접근해서, 톰캣 컨테이너가 연결한
			// DataSource 객체를 받아온다.
			// lookup 메서드는 Object 객체를 반환하므로 DataSource 자료형으로 변환해서 대입
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			System.out.println("SUCCESS: Get the DataSource object!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

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
			/*
			// 오라클 데이터베이스에 연결
			connectDatabase();
			*/

			// DataSource 객체를 이용해 데이터베이스에 연결
			connection = dataSource.getConnection();
			System.out.println("SUCCESS: Get the Connection object!");

			// Statement 객체 생성
			statement = connection.createStatement();
			System.out.println("SUCCESS: Create the Statement object!");

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
			// ResultSet 객체, Statement 객체, Connection 객체를 해제
			closeConnection();
		}

		// 생성한 ArrayList 객체를 반환
		return list;
	}
	
	/**
	 * 데이터베이스 연결을 해제
	 */
	private void closeConnection() {
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
		if (preStatement != null) try { preStatement.close(); } catch (Exception e) {}
		if (connection != null) try { connection.close(); } catch (Exception e) {}

		resultSet = null;
		statement = null;
		preStatement = null;
		connection = null;

		System.out.println("SUCCESS: Close the statement and connection!");
	}

	/**
	 * member 테이블에 새로운 레코드를 추가
	 * @param member 추가할 회원 정보
	 */
	public void insertMember(MemberVO member) {
		try {
			// DataSource 객체를 이용해 데이터베이스에 연결
			connection = dataSource.getConnection();
			System.out.println("SUCCESS: Get the Connection object!");

			// member 테이블에 새로운 레코드를 추가하는 SQL 문
			String query = "INSERT INTO member (id, account, passwd, name, email) "
					+ "VALUES (SEQ_MEMBER_ID.NEXTVAL, ?, ?, ?, ?)";
			System.out.println("QUERY: " + query);

			// SQL 문을 실행하는 PreparedStatement 객체를 생성
			preStatement = connection.prepareStatement(query);
			System.out.println("SUCCESS: Create the PreparedStatement object!");

			// PreparedStatement 객체의 setString 메서드 등을 이용해 SQL 문의 지정한
			// 위치(?)에 원하는 값을 치환
			// 이때 치환할 위치의 인덱스는 1부터 시작한다!
			preStatement.setString(1, member.getAccount());
			preStatement.setString(2, member.getPasswd());
			preStatement.setString(3, member.getName());
			preStatement.setString(4, member.getEmail());

			// PreparedStatement 객체의 executeUpdate 메서드를 이용해 SQL 문을 실행
			// INSERT, UPDATE, DELETE 문 등은 executeUpdate 메서드를 이용해 SQL 문을 실행
			// executeUpdate 메서드의 반환 값은 SQL 문이 적용된 레코드의 개수이다.
			preStatement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// closeConnection 메서드를 이용해, PreparedStatement 객체, Connection 객체를 해제
			closeConnection();
		}
	}

}
