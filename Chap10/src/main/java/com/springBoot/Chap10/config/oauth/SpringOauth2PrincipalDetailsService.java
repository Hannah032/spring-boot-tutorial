package com.springBoot.Chap10.config.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class SpringOauth2PrincipalDetailsService extends DefaultOAuth2UserService {

    // 외부 로그인(Google, Facebook 등) 요청시 실행
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String providerName = userRequest.getClientRegistration().getRegistrationId(); // ex) google, facebook, naver, kakao
        System.out.println("providerName: " + providerName);

        // 추가적인 사용자 정보 처리 가능 (예: DB 저장 등)

        return oAuth2User;
    }
}
