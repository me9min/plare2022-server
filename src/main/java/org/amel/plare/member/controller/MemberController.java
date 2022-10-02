package org.amel.plare.member.controller;

import org.amel.plare.member.domain.MemberLoginVO;
import org.amel.plare.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
    
    @Autowired
    MemberService memberService;
    
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public int memberSignup() {
        
        return 0;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public int memberLogin(@RequestBody MemberLoginVO memberLogin) {
        
        return 0;
    }
}
