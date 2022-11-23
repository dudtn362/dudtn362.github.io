package org.vision.popol.fxhomebook;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class TestOfHomebookDao {
	HomebookDao dao = new HomebookDao();	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 TestOfHomebookDao x = new TestOfHomebookDao();
//		x.홈북다오의인서트기능이성공하는지테스트();
//		x.홈북다오의인서트기능이실패하는지테스트();
		x.모든자료읽어오기테스트();
//		x.삭제성공테스트();
//		x.삭제실패테스트();	
//		x.자료수정성공여부테스트();
//		x.자료수정실패테스트(); 
//		x.자료선택해오기테스트();
		//x.지정한날짜의자료만가져오기테스트();
	}
	public void 지정한날짜의자료만가져오기테스트() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getConnection();
		Timestamp a = new Timestamp(System.currentTimeMillis());
		Timestamp b = new Timestamp(System.currentTimeMillis());
		a.setYear(122);
		a.setMonth(6);
		a.setDate(1);	
		
		b.setYear(122);
		b.setMonth(6);
		b.setDate(14);	
		
		System.out.println(a);
		System.out.println(b);
		List<Homebook> data = dao.selectByDay(conn, a, b);
		for(Homebook x : data) {
		System.out.println(x);
		}
	}	
	public void 자료선택해오기테스트() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getConnection();
		Homebook vo = dao.select(conn, 1L);
		System.out.println(vo);
		
	}
	public void 자료수정실패테스트() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getConnection();
		
		Homebook vo = new Homebook();
		vo.setSerialno(9999L);
		Timestamp day = new Timestamp(System.currentTimeMillis());	
		vo.setDay(day);
		vo.setSection("수입");
		vo.setAccounttitle("피복비");
		vo.setRemark("딸 여름용 물놀이 원피스를 사주다.");
		vo.setRevenue(0);
		vo.setExpense(78000);
		int res = dao.update(conn, vo);
		if(res==0) {
			System.out.println("수정실패 테스트 성공");
		}else {
			System.out.println("수정실패 테스트 실패");
		}
	}
	//테스트케이스의 메소드명은 친절하고 충분하게(다만,띄어쓰기는 안됨)
	//매개변수는 없어야 한다.
	public void 자료수정성공여부테스트() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getConnection();
		
		Homebook vo = new Homebook();
		vo.setSerialno(1L);
		Timestamp day = new Timestamp(System.currentTimeMillis());
		day.setYear(122);
		day.setMonth(6); // 7월을 의미
		day.setDate(12);
		
		vo.setDay(day);
		vo.setSection("수입");
		vo.setAccounttitle("피복비");
		vo.setRemark("딸 여름용 물놀이 원피스를 사주다.");
		vo.setRevenue(0);
		vo.setExpense(78000);
		int res = dao.update(conn, vo);
		if(res==1) {
			System.out.println("수정성공");
		}else {
			System.out.println("수정실패");
		}
	}

	public void 삭제성공테스트() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getConnection();
		int res = dao.delete(conn, 1L);
		System.out.println(res);
		if(res==1) {
			System.out.println("자료를 잘 지웠습니다.");
		}else {
			System.out.println("자료를 못 지웠습니다.");
		}
	}
	public void 삭제실패테스트() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getConnection();
		// 없는 시리얼 번호로 호출 해야 함
		int res = dao.delete(conn, 3L);
		System.out.println(res);
		if(res==0) {
			System.out.println("정상적인 삭제 실패");
		}else {
			System.out.println("뭔가 이상함.");
		}
	}
	
	public void 모든자료읽어오기테스트() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getConnection();
		List<Homebook> data = dao.selectAll(conn);
		for(Homebook x:data) {
			System.out.println(x);
		}
	}
	
	// test case
	public void 홈북다오의인서트기능이성공하는지테스트() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getConnection();
		Homebook vo = new Homebook();
		vo.setSerialno(2L);
		Timestamp d = new Timestamp(System.currentTimeMillis());
		vo.setDay(d);
		vo.setSection("지출");
		vo.setAccounttitle("수도광열비");
		vo.setRemark("이번달 전기요금");
		vo.setRevenue(0);
		vo.setExpense(78000);
		try {
			int res = dao.insert(conn, vo);
			System.out.println(res);
			if(res>0) System.out.println("자료입력 성공!");
			else System.out.println("자료입력 실패!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// test case
		public void 홈북다오의인서트기능이실패하는지테스트() throws ClassNotFoundException, SQLException {
			Connection conn = null;
			conn = ConnectionFactory.getConnection();
			Homebook vo = new Homebook();
			vo.setSerialno(1);
			Timestamp d = new Timestamp(System.currentTimeMillis());
			vo.setDay(d);
			vo.setSection("지출");
			vo.setAccounttitle("피복비");
			vo.setRemark("딸 여름용 물놀이 원피스를 사주다.");
			vo.setRevenue(0);
			vo.setExpense(78000);
			if (dao.insert(conn, vo) == -1) {
			System.out.println("입력실패 테스트 성공!");
			} else {
			System.out.println("입력실패 테스트 실패!");
			}
			}
		
}
