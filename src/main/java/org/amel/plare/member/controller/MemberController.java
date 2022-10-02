package org.amel.plare.member.controller;

import lombok.RequiredArgsConstructor;
import org.amel.plare.member.domain.MemberLoginVO;
import org.amel.plare.member.domain.MemberVO;
import org.amel.plare.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    
    private final MemberService memberService;


    @PostMapping("/signup")
    public ResponseEntity signupMember(@RequestBody MemberVO memberVO) {
        memberService.signupMember(memberVO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    


}
