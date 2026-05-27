package com.msedcl.main.entity;

public class MemberType{

	private int memberTypeId;
	private String memberTypeDesc;
	private int bookIssueLimit;
	private int borrowDaysLimit;

	public MemberType() {
		// TODO Auto-generated constructor stub
	}

	public MemberType(int memberTypeId, String memberTypeDesc, int bookIssueLimit, int borrowDaysLimit) {
		super();
		this.memberTypeId = memberTypeId;
		this.memberTypeDesc = memberTypeDesc;
		this.bookIssueLimit = bookIssueLimit;
		this.borrowDaysLimit = borrowDaysLimit;
	}

	public int getMemberTypeId() {
		return memberTypeId;
	}

	public void setMemberTypeId(int memberTypeId) {
		this.memberTypeId = memberTypeId;
	}

	public String getMemberTypeDesc() {
		return memberTypeDesc;
	}

	public void setMemberTypeDesc(String memberTypeDesc) {
		this.memberTypeDesc = memberTypeDesc;
	}

	public int getBookIssueLimit() {
		return bookIssueLimit;
	}

	public void setBookIssueLimit(int bookIssueLimit) {
		this.bookIssueLimit = bookIssueLimit;
	}

	public int getBorrowDaysLimit() {
		return borrowDaysLimit;
	}

	public void setBorrowDaysLimit(int borrowDaysLimit) {
		this.borrowDaysLimit = borrowDaysLimit;
	}

	@Override
	public String toString() {
		return "MemberType [memberTypeId=" + memberTypeId + ", memberTypeDesc=" + memberTypeDesc + ", bookIssueLimit="
				+ bookIssueLimit + ", borrowDaysLimit=" + borrowDaysLimit + "]";
	}
	
}
