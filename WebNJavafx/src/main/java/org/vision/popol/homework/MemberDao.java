package org.vision.popol.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.vision.popol.fxhomebook.Homebook;

public class MemberDao implements IDao<Member,Long> {

	@Override
	public int insert(Connection conn, Member vo) throws SQLException {
		String sql = " INSERT INTO MEMBER (SERIALNO,NAME,ID,PASSWORD,GENDER,TEL,EMAIL) "
				+ "VALUES(SEQ_MEMBER.NEXTVAL,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//pstmt.setLong(1,vo.getSerialno());
		pstmt.setString(1,vo.getName());
		pstmt.setString(2,vo.getId());
		pstmt.setString(3,vo.getPwd());
		pstmt.setString(4,vo.getGender());
		pstmt.setString(5,vo.getTel());
		pstmt.setString(6,vo.getEmail());
		int res = 0;		
	    try {
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			return -1;
		}
		conn.close();
		return res;		
	}

	@Override
	public int delete(Connection conn, Long pk) throws SQLException {
		String sql = "DELETE FROM MEMBER WHERE SERIALNO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, pk);
		int res = pstmt.executeUpdate();
		return res;
	}

	@Override
	public int update(Connection conn, Member vo) throws SQLException {
		String sql = "UPDATE MEMBER "
				+ "SET NAME=?, ID=?, PASSWORD=? ,"
				+ "GENDER=?, TEL=?,EMAIL=? "
				+ "WHERE SERIALNO=?";
		int res = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getTel());
			pstmt.setString(6, vo.getEmail());
			pstmt.setLong(7, vo.getSerialno());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
		conn.close();	
		return res;
	}

	@Override
	public Member select(Connection conn, Long pk) throws SQLException {
		String sql = "SELECT * FROM MEMBER WHERE SERIALNO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, pk);
		ResultSet rs = pstmt.executeQuery();
		Member vo = new Member();
		while(rs.next()) {
			vo.setSerialno(pk);
			vo.setName(rs.getString("NAME"));
			vo.setId(rs.getString("ID"));
			vo.setPwd(rs.getString("PASSWORD"));
			vo.setGender(rs.getString("GENDER"));
			vo.setTel(rs.getString("TEL"));
			vo.setEmail(rs.getString("EMAIL"));
		}
		conn.close();
		return vo;
	}

	@Override
	public List<Member> selectAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM MEMBER";
		//Statement stmt = conn.createStatement();
		//ResultSet rs = stmt.executeQuery(sql);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Member> data = new ArrayList<>();
		Member vo = new Member();
		while(rs.next()) {
			vo.setSerialno(rs.getLong("SERIALNO"));
			vo.setName(rs.getString("NAME"));
			vo.setId(rs.getString("ID"));
			vo.setPwd(rs.getString("PASSWORD"));
			vo.setGender(rs.getString("GENDER"));
			vo.setTel(rs.getString("TEL"));
			vo.setEmail(rs.getString("EMAIL"));
			data.add(vo);
		}
		conn.close();
		return data;
	}

	@Override
	public List<Member> selectByCondition(Connection conn,String condition) throws SQLException {
		String sql = "SELECT * FROM MEMBER "+condition;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Member> data = new ArrayList<>();
		Member vo = null;
		while(rs.next()) {			
			vo = new Member();
			vo.setSerialno(rs.getLong("SERIALNO"));
			vo.setName(rs.getString("NAME"));
			vo.setId(rs.getString("ID"));
			vo.setPwd(rs.getString("PASSWORD"));
			vo.setGender(rs.getString("GENDER"));
			vo.setTel(rs.getString("TEL"));
			vo.setEmail(rs.getString("EMAIL"));
			data.add(vo);
		}
		conn.close();
		return data;
	}

	

}
