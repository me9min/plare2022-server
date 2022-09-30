package org.amel.plare.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** API level Controller for member
 *  멤버 클래스 용 API 컨트롤러
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    /** {stub} - create new account
     *  {stub} - 신규 계정 생성
     * @return 'test' 스트링
     */
    @GetMapping("/signup")
    public String Signup() {

        return "test";
    }
}
