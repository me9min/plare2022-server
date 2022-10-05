package org.amel.plare.config;


import lombok.RequiredArgsConstructor;
import org.amel.plare.member.dao.MemberDao;
import org.amel.plare.member.domain.MemberVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberDao memberDao;


    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        //todo refactoring
        try {
            MemberVO memberVO = memberDao.selectOneMember(id);
            return new MemberDetails(memberVO);

        } catch (Exception e) {
            throw new NullPointerException("Not Found Member");
        }
    }

    private final class MemberDetails extends MemberVO implements UserDetails{
        MemberDetails(MemberVO memberVO){
            setAuthId(memberVO.getAuthId());
            setName(memberVO.getName());
            setEmail(memberVO.getEmail());
            setPassword(memberVO.getPassword());
            setDateOfJoin(memberVO.getDateOfJoin());
            setDateOfLastJoin(memberVO.getDateOfLastJoin());
            setSteamId(memberVO.getSteamId());
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public String getUsername() {
            return getAuthId();
        }

        @Override
        public boolean isAccountNonExpired() {
            return false;
        }

        @Override
        public boolean isAccountNonLocked() {
            return false;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return false;
        }

        @Override
        public boolean isEnabled() {
            return false;
        }
    }
}
