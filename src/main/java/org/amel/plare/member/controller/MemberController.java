package org.amel.plare.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** controller class for member accounts
 *  계정 콘트롤러 클래스
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/signup")
    public String Signup() {

        return "test";
    }
}
