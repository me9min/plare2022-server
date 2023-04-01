package kr.amel.plare.member.service;

import kr.amel.plare.member.dao.MemberDao;
import kr.amel.plare.member.domain.MemberLoginVO;
import kr.amel.plare.member.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	MemberDao memberDao;
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public String memberLogin(MemberLoginVO memberLogin) {

		String encodedPassword = memberDao.findPasswordById(memberLogin.getAuthId());
		
		if (encodedPassword.equals(bCryptPasswordEncoder.encode(memberLogin.getPassword()))) {
			
			return "로그인 성공";
		}
		else
		{
			return "비밀번호 불일치";
		}
	}

	public int memberSignup(MemberVO member) {

		if (0 < memberDao.checkId(member.getAuthId())) {

			return 0;
		}
		else
		{
			member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
			return memberDao.insertMember(member);
		}
	}

}
