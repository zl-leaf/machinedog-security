package me.yipzale.machinedog.security.core;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class OIDCTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        DefaultOAuth2AccessToken accessToken = (DefaultOAuth2AccessToken)oAuth2AccessToken;
        UserModel userModel = (UserModel)oAuth2Authentication.getPrincipal();
        Map<String, Object> additionalInfo = new HashMap<String, Object>();
        additionalInfo.put("openId", userModel.getId());
        accessToken.setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}