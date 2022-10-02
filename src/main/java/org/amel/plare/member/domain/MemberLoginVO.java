package org.amel.plare.member.domain;

import lombok.Data;

@Data
public class MemberLoginVO {
    
    private String authId;
    
    private String password;
}
