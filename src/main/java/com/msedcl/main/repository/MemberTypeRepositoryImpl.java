package com.msedcl.main.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.msedcl.main.entity.MemberType;

@Repository
public class MemberTypeRepositoryImpl implements MemberTypeRepository {
	private JdbcTemplate jdbcTemplate;

	private static final String SELECT_ALL_MEMBER_TYPE_SQL = "SELECT * FROM member_type";
	
	private static final Map<String, MemberType> MEMBER_TYPE_MAP = new HashMap<>();
	

	public MemberTypeRepositoryImpl(JdbcTemplate jdbcTemplate) {
		System.out.println("Overloaded Constructor Called - MemberTypeRepositoryImpl");
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<MemberType> getMemberTypeList() {
		return jdbcTemplate.query(SELECT_ALL_MEMBER_TYPE_SQL,(rs, row) -> new MemberType(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
	}

}
