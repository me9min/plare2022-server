package org.amel.plare.member.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberLoginVO {
    
    private String authId;
    
    private String password;
}
