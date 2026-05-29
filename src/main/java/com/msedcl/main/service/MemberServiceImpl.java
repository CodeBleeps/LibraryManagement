package com.msedcl.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.entity.Member;
import com.msedcl.main.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	private MemberRepository memberRepository;

	public MemberServiceImpl(MemberRepository memberRepository) {
		System.out.println("Overloaded Constructor Called - MemberServiceImpl");
		this.memberRepository = memberRepository;
	}

	@Override
	public Member addNewMember(Member member) {		
			return memberRepository.addNewMember(member);
	}

	@Override
	public Member getMemberbyMemberId(int memberId) {
		return memberRepository.getMemberbyMemberId(memberId);
	}

	@Override
	public List<Member> getAllMemberList() {
		return memberRepository.getAllMemberList();
	}


}
