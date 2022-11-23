package org.vision.popol.fxhomebook;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

// V - VO class type, P primary key type
public interface IDao<V,P> { 
	public int insert(Connection conn,V vo) throws SQLException;
	public int delete(Connection conn,P pk) throws SQLException;
	public int update(Connection conn,V vo) throws SQLException;
	public V select(Connection conn,P pk) throws SQLException;
	public List<V> selectAll(Connection conn) throws SQLException;
	public List<V> selectByDay(Connection conn, Timestamp startDate,Timestamp endDate) throws SQLException;
}
