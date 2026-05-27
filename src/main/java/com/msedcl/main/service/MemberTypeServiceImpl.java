package com.msedcl.main.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.msedcl.main.entity.MemberType;

@Service
public class MemberTypeServiceImpl implements MemberTypeService {
	private JdbcTemplate jdbcTemplate;

	private static final String SELECT_ALL_MEMBER_TYPE_SQL = "SELECT * FROM member_type";
	
	private static final Map<Integer, MemberType> MEMBER_TYPE_ID_MAP = new HashMap<>();
	private static final Map<String, MemberType> MEMBER_TYPE_DESC_MAP = new HashMap<>();
	
	public MemberTypeServiceImpl(JdbcTemplate jdbcTemplate) {
		System.out.println("Overloaded Constructor Called - MemberTypeRepositoryImpl");
		this.jdbcTemplate = jdbcTemplate;
		populateMemberTypeMaps();
	}

	@Override
	public List<MemberType> getMemberTypeList() {		
		return jdbcTemplate.query(SELECT_ALL_MEMBER_TYPE_SQL,(rs, row) -> new MemberType(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
	}


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
