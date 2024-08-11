package smartHomeDDD.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import smartHomeDDD.domain.user.User;
import smartHomeDDD.domain.valueobject.RoleName;
import smartHomeDDD.domain.valueobject.UserEmail;
import smartHomeDDD.domain.valueobject.UserName;
import smartHomeDDD.services.ServiceUser;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class OAuth2LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private ServiceUser serviceUser;


    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        if ("github".equals(token.getAuthorizedClientRegistrationId())){

            DefaultOAuth2User principal = (DefaultOAuth2User) authentication.getPrincipal();
            Map<String, Object> attributes = principal.getAttributes();
            String email = attributes.getOrDefault("email", "").toString();
            String name = attributes.getOrDefault("name", "").toString();
            serviceUser.findByName(name)
                    .ifPresentOrElse(
                            user -> {
                                DefaultOAuth2User newUser = new DefaultOAuth2User(List.of(new SimpleGrantedAuthority(user.getRole().toString())),
                                        attributes, "name");
                                Authentication securityAuth = new OAuth2AuthenticationToken(newUser, List.of(new SimpleGrantedAuthority(user.getRole().toString())),
                                        token.getAuthorizedClientRegistrationId());
                                SecurityContextHolder.getContext().setAuthentication(securityAuth);

                            },
                            () -> {
                                UserName userName = new UserName(name);
                                UserEmail userEmail = new UserEmail(email);
                                User user = serviceUser.createUser(userName, userEmail, RoleName.POWER_USER);
                                DefaultOAuth2User newUser = new DefaultOAuth2User(List.of(new SimpleGrantedAuthority(user.getRole().toString())),
                                        attributes, "name");
                                Authentication securityAuth = new OAuth2AuthenticationToken(newUser, List.of(new SimpleGrantedAuthority(user.getRole().toString())),
                                        token.getAuthorizedClientRegistrationId());
                                SecurityContextHolder.getContext().setAuthentication(securityAuth);
                            }
                    );

        }

        this.setDefaultTargetUrl("http://localhost:5173/");
        super.onAuthenticationSuccess(request, response, authentication);

    }

}
