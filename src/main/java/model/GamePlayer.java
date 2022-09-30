package model;

import lombok.*;

/** in -game player class
 *  게임 내부적으로 존재하는 플레이어 클래스
 */
@Data
public class GamePlayer {

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

    /** tentative (임시 비활성화)
     *
     */
//    private long cash
}
