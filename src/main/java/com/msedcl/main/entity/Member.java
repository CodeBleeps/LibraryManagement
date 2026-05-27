package com.msedcl.main.entity;

public class Member{

	private int memberCode;
	private String memberName;
	private int bookdIssuedCount;
	private MemberType memberType;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int memberCode, String memberName, int bookdIssuedCount, MemberType memberType) {
		super();
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.bookdIssuedCount = bookdIssuedCount;
		this.memberType = memberType;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getBookdIssuedCount() {
		return bookdIssuedCount;
	}

	public void setBookdIssuedCount(int bookdIssuedCount) {
		this.bookdIssuedCount = bookdIssuedCount;
	}


	public MemberType getMemberType() {
		return memberType;
	}

	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}

	@Override
	public String toString() {
		return "Member [memberCode=" + memberCode + ", memberName=" + memberName + ", bookdIssuedCount="
				+ bookdIssuedCount + ", memberType=" + memberType + "]";
	}
	
}
