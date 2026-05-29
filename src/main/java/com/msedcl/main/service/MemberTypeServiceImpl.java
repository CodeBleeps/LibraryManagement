package com.msedcl.main.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.msedcl.main.entity.MemberType;
import com.msedcl.main.repository.MemberTypeRepository;

@Service
public class MemberTypeServiceImpl implements MemberTypeService {
	private MemberTypeRepository memberTypeRepository;
	
	private static final Map<Integer, MemberType> MEMBER_TYPE_ID_MAP = new HashMap<>();
	private static final Map<String, MemberType> MEMBER_TYPE_DESC_MAP = new HashMap<>();
	
	public MemberTypeServiceImpl(MemberTypeRepository memberTypeRepository) {
		System.out.println("Overloaded Constructor Called - MemberTypeRepositoryImpl");
		this.memberTypeRepository = memberTypeRepository;
		populateMemberTypeMaps();
	}

	@Override
	public List<MemberType> getMemberTypeList() {		
		return memberTypeRepository.getMemberTypeList();
	}

	@Override
	public void populateMemberTypeMaps() {		
		 List<MemberType> memberTypes = getMemberTypeList();
		 for(MemberType memberType: memberTypes) {
			 MEMBER_TYPE_ID_MAP.put(memberType.getMemberTypeId(), memberType);
			 MEMBER_TYPE_DESC_MAP.put(memberType.getMemberTypeDesc(), memberType);
		 }
	}

	@Override
	public MemberType getMemberTypeByMemberTypeId(int memberTypeId) {
		return MEMBER_TYPE_ID_MAP.get(memberTypeId);
	}

	@Override
	public MemberType getMemberTypeByMemberTypeDesc(String memberTypeDesc) {
		return MEMBER_TYPE_DESC_MAP.get(memberTypeDesc);
	}
}
