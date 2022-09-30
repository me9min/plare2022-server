package org.amel.plare.member;

import lombok.Data;

/** user class for webpage login and auth
 *  계정 인증 및 웹페이지 로그인 담당 계정 클래스
 */
@Data
public class Member {
    /** shows authorisation ID of user
     *  인증용 아이디 생성
     */
    private String authId;
}
