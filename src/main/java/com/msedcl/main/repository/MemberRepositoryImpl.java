package com.msedcl.main.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.msedcl.main.entity.Member;
import com.msedcl.main.entity.MemberType;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	private JdbcTemplate jdbcTemplate;

	private static final String ADD_NEW_MEMBER_SQL = "INSERT INTO member_details(member_name,member_type_id,books_issued_count) values(?,?,?)";
	private static final String SELECT_A_MEMBER_BY_ID_SQL = "SELECT * FROM member_details WHERE member_code = ?";


	public MemberRepositoryImpl(JdbcTemplate jdbcTemplate) {
		System.out.println("Overloaded Constructor Called - MemberRepositoryImpl");
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	@Transactional
	public Member addNewMember(Member member) {
		int rowsInserted = jdbcTemplate.update(ADD_NEW_MEMBER_SQL, member.getMemberCode(), member.getMemberType().getMemberTypeId(), member.getBookdIssuedCount());
		if (rowsInserted > 0)
			return member;
		else
			return null;
	}

	@Override
	public Member getMemberbyMemberId(int memberId) {
		return jdbcTemplate.queryForObject(SELECT_A_MEMBER_BY_ID_SQL,(rs, row) -> new Member(rs.getInt(1), rs.getString(2), rs.getInt(3), new MemberType(rs.getInt(4),null,0,0)));
	}


}
