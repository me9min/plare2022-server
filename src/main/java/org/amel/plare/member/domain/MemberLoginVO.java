package org.amel.plare.member.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MemberLoginVO {

	private String authId;

	private String password;
}