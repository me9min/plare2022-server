package org.amel.plare.member.service;

import org.amel.plare.member.dao.MemberDao;
import org.amel.plare.member.domain.MemberLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@al
#ddf
public class MemberService {
    private final MemberDao memberDao;
    private final PasswordEncoder passwordEncoder;
    
	public int memberLogin(MemberLoginVO memberLogin) {

		String encodedPassword = memberDao.findPasswordById(memberLogin.getAuthId());

		if (encodedPassword == passwordEncoder.encode(memberLogin.getPassword())) {

			return 0;
		}

		return 1;
	}
	
	
}
