package kr.amel.plare.member.controller;

import kr.amel.plare.member.domain.MemberLoginVO;
import kr.amel.plare.member.domain.MemberVO;
import kr.amel.plare.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller class for member accounts 계정 콘트롤러 클래스
 */
@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String memberLogin(@RequestBody MemberLoginVO memberLogin) {

		return memberService.memberLogin(memberLogin);
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public int memberSignup(@RequestBody MemberVO member) {

		return memberService.memberSignup(member);
	}

}
