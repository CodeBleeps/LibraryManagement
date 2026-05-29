package com.msedcl.main.service;

import java.util.List;

import com.msedcl.main.entity.Member;

public interface MemberService {
	Member addNewMember(Member member);
	Member getMemberbyMemberId(int memberId);
	List<Member> getAllMemberList();
}
