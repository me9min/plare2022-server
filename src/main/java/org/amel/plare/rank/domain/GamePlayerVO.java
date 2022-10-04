package org.amel.plare.rank.domain;

import lombok.Data;
/** 게임 내부 플레이어 클래스
 *  player case for in-game
 */
@Data
public class GamePlayerVO {

    /** shows authorisation ID of user
     *  인증용 아이디 생성
     */
    private String authId;

    /** player name
     * 플레이어 이름
     */
    private String name;

    /** amount of credit player has
     * 플레이어 크레딧 소지 개수
     */
    private int credit;

    /** account creation date
     * 계정 생성일
     */
    private int accountCreationDate;

    /** last login date
     *  마지막 로그인 날짜
     */
    private int lastLoginDate;
}
