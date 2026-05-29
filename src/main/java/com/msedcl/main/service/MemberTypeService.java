package com.msedcl.main.service;

import java.util.List;

import com.msedcl.main.entity.MemberType;

public interface MemberTypeService {
	MemberType getMemberTypeByMemberTypeId(int memberTypeId);
	MemberType getMemberTypeByMemberTypeDesc(String memberTypeDesc);
	List<MemberType> getMemberTypeList();
	public void populateMemberTypeMaps();
}
