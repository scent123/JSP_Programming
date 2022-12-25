package ex02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
	 * DataSource 객체를 이용해 데이터베이스에 연결
	 * @throws SQLException
	 */
	private void getConnection() throws SQLException {
		// DataSource 객체를 이용해 데이터베이스에 연결
		// → Connection 객체의 isClosed 메서드는 데이터베이스 연결이 해제된 상태인지 확인
		// → isClosed 메서드에서는 SQLException 예외가 발생하므로, 이 메서드에서 예외를
		//   처리하든, 아니면 예외를 전달해야 한다.
		if (connection == null || connection.isClosed()) {
			connection = dataSource.getConnection();
			System.out.println("SUCCESS: Get the Connection object!");
		}
	}
	
	/**
	 * SQL 문을 실행하는 Statement 객체를 생성
	 */
	private void createStatement() throws SQLException {
		// Connection 객체 생성
		if (connection == null || connection.isClosed()) getConnection();

		// SQL 문을 실행하는 Statement 객체를 생성
		// ResultSet.TYPE_FORWARD_ONLY
		// → ResultSet 객체의 커서 위치를 다음 레코드로만 변경할 수 있다.
		// ResultSet.TYPE_SCROLL_SENSITIVE
		// → ResultSet 객체의 커서 위치를 변경할 수 있으며, 업데이트한 내용을 반영한다.
		// ResultSet.TYPE_SCROLL_INSENSITIVE
		// → ResultSet 객체의 커서 위치를 변경할 수 있으며, 업데이트한 내용을 반영하지 않는다.
		// ResultSet.CONCUR_UPDATABLE
		// → ResultSet 객체의 데이터를 변경할 수 있다.
		// ResultSet.CONCUR_READ_ONLY
		// → ResultSet 객체의 데이터를 변경하지 못한다.
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		System.out.println("SUCCESS: Get the Statement object!");
	}

	/**
	 * Statement 객체를 이용해 SQL 문을 실행
	 * @param query 실행할 SQL 문
	 */
	private void executeQuery(String query) throws SQLException {
		// Statement 객체가 생성되어 있지 않으면 Connection 객체와 Statement 객체를 생성
		if (statement == null || statement.isClosed()) createStatement();

		// Statement 객체를 이용해 SQL 문을 실행하고, 실행 결과를 ResultSet 객체에 저장
		resultSet = statement.executeQuery(query);

		// 실행한 SQL 문을 확인
		System.out.println("QUERY: " + query);

		// 실행 결과에서 레코드(records; 행)의 개수를 확인
		resultSet.last();					// ResultSet 객체의 커서를 마지막 레코드로 이동
		int numRows = resultSet.getRow();	// 마지막 레코드의 행 번호를 확인
		resultSet.beforeFirst();			// ResultSet 객체의 커서를 첫 번째 레코드 이전으로 이동

		System.out.println("ROWS: " + numRows);
		
		// 실행 결과에서 컬럼(columns; 열)의 개수를 확인
		// → ResultSetMetaData 객체의 getColumnCount 메서드를 이용
		ResultSetMetaData metaData = resultSet.getMetaData();
		int numColumns = metaData.getColumnCount();
		
		System.out.println("COLUMNS: " + numColumns);
	}

	/**
	 * SQL 문을 실행하는 PreparedStatement 객체를 생성
	 * @param query 실행할 SQL 문
	 */
	private void prepareStatement(String query) throws SQLException {
		// Connection 객체 생성
		if (connection == null || connection.isClosed()) getConnection();

		// SQL 문을 실행하는 PreparedStatement 객체를 생성
		preStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);

		System.out.println("SUCCESS: Create the PreparedStatement object!");
		System.out.println("QUERY: " + query);
	}

	/**
	 * PreparedStatement 객체를 이용해 SQL 문을 실행하고, 실행 결과를 ResultSet 객체에 저장
	 */
	private void executeQuery() throws SQLException {
		// SQL 문을 실행하고, 실행 결과를 ResultSet 객체에 저장
		resultSet = preStatement.executeQuery();

		// 실행 결과에서 레코드(records; 행)의 개수를 확인
		resultSet.last();					// ResultSet 객체의 커서를 마지막 레코드로 이동
		int numRows = resultSet.getRow();	// 마지막 레코드의 행 번호를 확인
		resultSet.beforeFirst();			// ResultSet 객체의 커서를 첫 번째 레코드 이전으로 이동

		System.out.println("ROWS: " + numRows);
		
		// 실행 결과에서 컬럼(columns; 열)의 개수를 확인
		// → ResultSetMetaData 객체의 getColumnCount 메서드를 이용
		ResultSetMetaData metaData = resultSet.getMetaData();
		int numColumns = metaData.getColumnCount();
		
		System.out.println("COLUMNS: " + numColumns);
	}

	/**
	 * PreparedStatement 객체를 이용해 SQL 문을 실행
	 * @return SQL 문이 적용된 레코드의 개수
	 */
	private int executeUpdate() throws SQLException {
		// PreparedStatement 객체가 생성되어 있지 않으면, 실행 종료
		if (preStatement == null || preStatement.isClosed()) {
			System.out.println("ERROR: The PreparedStatement object is closed!");
			return 0;
		}

		// PreparedStatement 객체의 executeUpdate 메서드를 이용해 SQL 문을 실행
		// INSERT, UPDATE, DELETE 문 등은 executeUpdate 메서드를 이용해 SQL 문을 실행
		// executeUpdate 메서드의 반환 값은 SQL 문이 적용된 레코드의 개수이다.
		int numRows = preStatement.executeUpdate();
		System.out.println("ROWS: " + numRows);

		return numRows;
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
	 * ResultSet 객체에서 회원 목록을 생성
	 * @return 회원 목록
	 */
	private List<MemberVO> getMemberListFromResultSet() throws SQLException {
		// member 테이블에서 조회한 레코드를 저장할 ArrayList 객체
		List<MemberVO> list = new ArrayList<>();

		// ResultSet 객체의 커서를 첫 번째 레코드 이전으로 이동
		resultSet.beforeFirst();

		// 반복자(iterator)를 이용해, ResultSet 객체에 저장된 레코드(행)을 차례대로 확인
		// → ResultSet 객체의 next 메서드는 ResultSet 객체의 커서(cursor)를
		//   다음 레코드로 이동시키며, 다음 레코드가 존재하면 true를, 없으면 false를
		//   반환한다.
		while (resultSet.next()) {
			// ResultSet 객체의 getInt 메서드 등을 이용해, ResultSet 객체의 커서가
			// 가리키는 레코드의 컬럼(column)을 참조
			// MemberVO 객체를 생성해서 각 필드를 조회한 레코드의 컬럼으로 설정
			MemberVO member = new MemberVO(
					resultSet.getInt("id"), resultSet.getString("account"),
					resultSet.getString("passwd"), resultSet.getString("name"),
					resultSet.getString("email"), resultSet.getDate("regdate")
			);

			// ArrayList 객체에 MemberVO 객체를 추가
			list.add(member);
		}

		// 회원 목록 반환
		return list;
	}

	/**
	 * ResultSet 객체를 확인해서 boolean 값을 반환
	 * @return 레코드의 result 컬럼이 'true'이면 true, 'false'이면 false를 반환
	 */
	private boolean getBooleanFromResultSet() throws SQLException {
		// ResultSet 객체를 확인한 다음 반환할 값
		boolean result = false;

		// ResultSet 객체의 커서를 첫 번째 객체로 이동
		// → ResultSet 객체의 first 메서드는 ResultSet 객체의 커서를 첫 번째 레코드로
		//   이동시키며, 레코드가 존재하는 경우 true를 반환한다.
		//   단, 이 경우 Statement 객체 또는 PreparedStatement 객체를 생성하면서
		//   ResultSet.TYPE_SCROLL_INSENSIVITVE 속성을 설정해야 한다.
		if (resultSet.first()) {
			// 첫 번째 레코드의 첫 번째 컬럼을 확인해서 boolean 자료형으로 변환
			result = Boolean.parseBoolean(resultSet.getString(1));
			System.out.println("RESULT: " + result);
		}

		// 확인 결과를 반환
		return result;
	}

	/**
	 * member 테이블의 모든 레코드를 조회
	 * @return 조회한 레코드의 목록
	 */
	public List<MemberVO> getMemberList() {
		// member 테이블에서 조회한 레코드를 저장할 ArrayList 객체
		List<MemberVO> list = null;

		// 데이터베이스에 연결하거나 조회하는 도중에 예외가 발생할 수 있으므로
		// try-catch 구문을 이용해 예외를 처리한다.
		try {
			// 실행할 SQL 문을 작성
			String query = "SELECT * FROM member";

			// Statement 객체를 이용해 SQL 문을 실행한 다음, 실행 결과를 ResultSet 객체에
			// 저장해서 반환
			executeQuery(query);

			// getMemberListFromResultSet 메서드를 이용해, ResultSet 객체에서 회원 목록 생성
			list = getMemberListFromResultSet();
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
	 * member 테이블에 새로운 레코드를 추가
	 * @param member 추가할 회원 정보
	 */
	public void insertMember(MemberVO member) {
		try {
			// member 테이블에 새로운 레코드를 추가하는 SQL 문
			String query = "INSERT INTO member (id, account, passwd, name, email) "
					+ "VALUES (SEQ_MEMBER_ID.NEXTVAL, ?, ?, ?, ?)";

			// SQL 문을 실행하는 PreparedStatement 객체를 생성
			prepareStatement(query);

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
			executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// closeConnection 메서드를 이용해, PreparedStatement 객체, Connection 객체를 해제
			closeConnection();
		}
	}

	/**
	 * member 테이블에서 레코드를 삭제
	 * @param id 삭제하고자 하는 레코드(회원)의 id
	 */
	public void deleteMember(String id) {
		// 문자열로 전달된 id를 정수로 변환한 값
		int intId = 0;

		// 전달된 id가 정수 형태의 문자열이 아닌 경우 예외가 발생한다.
		try {
			// 문자열로 전달된 id를 정수로 변환
			intId = Integer.parseInt(id);
		}
		catch (NumberFormatException e) {
			// e.printStackTrace();
			System.out.println("ERROR: Invalid id for deleting a member!");
			return;
		}

		try {
			// 전달된 id를 이용해 member 테이블에서 레코드를 삭제할 SQL 문을 작성
			String query = "DELETE FROM member WHERE id = ?";

			// PreparedStatement 객체를 생성
			prepareStatement(query);

			// SQL 문의 지정한 위치에 값을 치환
			preStatement.setInt(1, intId);

			// SQL 문을 실행
			executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// closeConnection 메서드를 이용해 PreparedStatement 객체, Connection 객체를 해제
			closeConnection();
		}
	}

	/**
	 * 주어진 로그인 정보가 올바른 로그인 정보인지 확인
	 * @param member 로그인 정보
	 * @return 올바른 로그인 정보인지 여부
	 */
	public boolean isValidLogin(MemberVO member) {
		// 회원 정보가 존재하는지 여부를 나타내는 변수
		boolean result = false;

		try {
			// 주어진 회원 정보로, member 테이블에 해당 정보가 있는지 확인하는 SQL 문
			String query = "SELECT DECODE(COUNT(*), 1, 'true', 'false') AS result "
					+ "FROM member WHERE account = ? AND passwd = ?";

			// PreparedStatement 객체 생성
			prepareStatement(query);

			// SQL 문의 지정한 위치에 값을 치환
			preStatement.setString(1, member.getAccount());
			preStatement.setString(2, member.getPasswd());

			// SQL 문을 실행하고, 실행 결과를 ResultSet 객체에 저장
			executeQuery();

			// 레코드의 result 컬럼을 확인해서 member 테이블에 회원 정보가 있는지 확인
			result = getBooleanFromResultSet();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// closeConnection 메서드를 이용해 ResultSet 객체, PreparedStatement 객체,
			// Connection 객체를 해제
			closeConnection();
		}

		// 회원 정보가 존재하는지 여부를 반환
		return result;
	}

	/**
	 * member 테이블에서 주어진 account 정보로 회원 정보를 조회
	 * @param account 조회하고자 하는 회원의 account 정보
	 * @return 조회한 회원 정보
	 */
	public MemberVO getMember(String account) {
		// member 테이블에서 조회한 레코드를 저장할 MemberVO 객체
		MemberVO member = new MemberVO();

		try {
			// member 테이블에서 회원 정보를 조회하기 위한 SQL 문을 작성
			String query = "SELECT * FROM member WHERE account = ?";

			// PreparedStatement 객체 생성
			prepareStatement(query);

			// SQL 문의 지정한 위치에 값을 치환
			preStatement.setString(1, account);

			// SQL 문을 실행하고, 실행 결과를 ResultSet 객체에 저장
			executeQuery();

			// ResultSet 객체의 커서를 첫 번째 레코드로 이동
			if (resultSet.first()) {
				// 현재 레코드의 각 컬럼을 MemberVO 객체의 필드에 설정
				member.setId(resultSet.getInt("id"));
				member.setAccount(resultSet.getString("account"));
				member.setPasswd(resultSet.getString("passwd"));
				member.setName(resultSet.getString("name"));
				member.setEmail(resultSet.getString("email"));
				member.setRegdate(resultSet.getDate("regdate"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// closeConnection 메서드를 이용해 ResultSet 객체, PreparedStatement 객체,
			// Connection 객체를 해제
			closeConnection();
		}

		// 조회한 회원 정보를 반환
		return member;
	}

	/**
	 * 주어진 이름으로 member 테이블을 조회해서 회원 목록을 생성
	 * @param name 조회하고자 하는 회원의 이름
	 * @return 회원 목록
	 */
	public List<MemberVO> getMemberListByName(String name) {
		// member 테이블에서 조회한 레코드를 저장할 ArrayList 객체
		// List<MemberVO> list = new ArrayList<MemberVO>();
		List<MemberVO> list = null;

		// 데이터베이스에 연결하거나 조회하는 도중에 예외가 발생할 수 있으므로
		// try-catch 구문을 이용해 예외를 처리한다.
		try {
			// 이름으로 member 테이블에서 레코드를 조회하는 SQL 문을 작성
			String query
				= String.format("SELECT * FROM member WHERE LOWER(name) LIKE '%%%s%%'",
						name.toLowerCase());

			// Statement 객체를 이용해 SQL 문을 실행한 다음, 실행 결과를 ResultSet 객체에
			// 저장해서 반환
			executeQuery(query);

			// getMemberListFromResultSet 메서드를 이용해, ResultSet 객체에서 회원 목록 생성
			list = getMemberListFromResultSet();
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
	 * member 테이블에서 account 정보를 이용해 회원 정보가 존재하는지 확인
	 * @param account 확인하고자 하는 회원 정보의 account 정보
	 * @return 존재하는지 여부
	 */
	public boolean isDuplicateAccount(String account) {
		// 회원 정보가 존재하는지 여부를 나타내는 변수
		boolean result = false;

		try {
			// member 테이블에서 account 정보를 이용해 회원 정보가 존재하는지 확인하는
			// SQL 문
			String query = "SELECT DECODE(COUNT(*), 1, 'true', 'false') AS result "
					+ "FROM member WHERE account = ?";

			// PreparedStatement 객체 생성
			prepareStatement(query);

			// SQL 문의 지정한 위치에 값을 치환
			preStatement.setString(1, account);

			// SQL 문을 실행하고, 실행 결과를 ResultSet 객체에 저장
			executeQuery();

			// 레코드의 result 컬럼을 확인해서 member 테이블에 지정한 회원 정보가 있는지 확인
			result = getBooleanFromResultSet();
		}
		catch (Exception e) { e.printStackTrace(); }
		finally { closeConnection(); }

		// 매개변수 account에 전달된 account를 가지는 회원 정보가 존재하는지 여부를 반환
		return result;
	}

	/**
	 * member 테이블에서 주어진 account 정보를 갖는 레코드를 갱신
	 * @param member 갱신할 회원 정보
	 */
	public void updateMember(MemberVO member) {
		try {
			// member 테이블에서 주어진 account 정보를 갖는 레코드를 갱신하는 SQL 문
			String query = "UPDATE member SET passwd = ?, name = ?, email = ? "
					+ "WHERE account = ?";

			// PreparedStatement 객체 생성
			prepareStatement(query);

			// SQL 문의 지정한 위치에 값을 치환
			preStatement.setString(1, member.getPasswd());
			preStatement.setString(2, member.getName());
			preStatement.setString(3, member.getEmail());
			preStatement.setString(4, member.getAccount());

			// SQL 문을 실행
			executeUpdate();
		}
		catch (Exception e) { e.printStackTrace(); }
		finally { closeConnection(); }
	}
}
