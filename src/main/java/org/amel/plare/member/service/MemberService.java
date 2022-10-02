package org.amel.plare.member.service;

import org.amel.plare.member.dao.MemberDao;
import org.amel.plare.member.dao.MemberLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    
    @Autowired
    MemberDao memberDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    // 테스트 함수 사용하지않음
    public int memberLogin(MemberLoginVO memberLogin) {
        
        String encodedPassword = memberDao.findPasswordById(memberLogin.getId());
        
        if(encodedPassword == passwordEncoder.encode(memberLogin.getPassword())) {
            
            return 0;
        }
        
        return 1;
    }
}
