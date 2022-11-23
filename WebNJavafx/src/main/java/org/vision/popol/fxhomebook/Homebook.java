package org.vision.popol.fxhomebook;

import java.sql.Timestamp;

// 가계부 vo클래스 - 데이터베이스 HOMEBOOK 테이블의 한 레코드의
// 정보를 담는 객체를 만들어 주는 클래스 
public class Homebook {
	private long serialno; //일련번호 - 프라이머리키-->자동으로 생성되게 만들 필요가 있음
	private Timestamp day; //일자
	private String section; // 수지구분
	private String accounttitle; //계정과목
	private String remark; //적요
	private int revenue; // 수입
	private int expense; // 지출
	public long getSerialno() {
		return serialno;
	}
	public void setSerialno(long serialno) {
		this.serialno = serialno;
	}
	public Timestamp getDay() {
		return day;
	}
	public void setDay(Timestamp day) {
		this.day = day;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getAccounttitle() {
		return accounttitle;
	}
	public void setAccounttitle(String accounttitle) {
		this.accounttitle = accounttitle;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getRevenue() {
		return revenue;
	}
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	public int getExpense() {
		return expense;
	}
	public void setExpense(int expense) {
		this.expense = expense;
	}
	@Override
	public String toString() {
		return "Homebook [serialno=" + serialno + ", day=" + day + ", section=" + section + ", accounttitle="
				+ accounttitle + ", remark=" + remark + ", revenue=" + revenue + ", expense=" + expense + "]";
	}
	
}
