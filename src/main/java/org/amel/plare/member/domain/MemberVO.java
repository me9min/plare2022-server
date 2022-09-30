package org.amel.plare.member.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {

    /** 웹 멤버 아이디 */
    private String id;

    /** 비밀번호, DB에 들어가기전에 암호화 되어야함 */
    private String password;

    /** 이름(닉네임) */
    private String name;

    /** 이메일, DB에 들어가기전에 이메일형식 체크 */
    private String email;

    /** 가입날짜 유닉스시간 */
    private String date_of_join;

    /** 마지막접속날짜 유닉스시간 */
    private String date_of_last_join;

    /** 스팀ID(사설서버게임 ID), store.store_players 테이블의 authid와 같다 */
    private String steamid;
}
