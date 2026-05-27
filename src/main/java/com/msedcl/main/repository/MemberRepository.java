package com.msedcl.main.repository;

import com.msedcl.main.entity.Member;

public interface MemberRepository {
	Member addNewMember(Member member);
	Member getMemberbyMemberId(int memberId);
}
