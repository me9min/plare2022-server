package org.amel.plare.member.service;

import lombok.RequiredArgsConstructor;
import org.amel.plare.member.dao.MemberDao;
import org.amel.plare.member.domain.MemberVO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberDao memberDao;

    private final PasswordEncoder passwordEncoder;

    
    public void signupMember(MemberVO memberVO) {
        String encryptedPassword = passwordEncoder.encode(memberVO.getPassword());
        memberVO.setPassword(encryptedPassword);

        memberDao.insertMember(memberVO);
    }
}
