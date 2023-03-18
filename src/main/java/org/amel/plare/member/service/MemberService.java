package org.amel.plare.member.service;

import org.amel.plare.member.dao.MemberDao;
import org.amel.plare.member.domain.MemberLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	MemberDao memberDao;
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public int memberLogin(MemberLoginVO memberLogin) {

		String encodedPassword = memberDao.findPasswordById(memberLogin.getAuthId());
		
		if (encodedPassword.equals(bCryptPasswordEncoder.encode(memberLogin.getPassword()))) {
			
			return 0;
		}
		else
		{
			return 1;
		}
	}

}
