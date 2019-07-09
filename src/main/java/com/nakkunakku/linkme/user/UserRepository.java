package com.nakkunakku.linkme.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public String getLocalTime() {
		return sqlSession.selectOne("user.getCurrentDateTime");
	}
}
