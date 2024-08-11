package smartHomeDDD.domain.user;

import org.springframework.stereotype.Component;
import smartHomeDDD.domain.role.Role;
import smartHomeDDD.domain.valueobject.UserEmail;
import smartHomeDDD.domain.valueobject.UserName;


@Component
public class ImplFactoryUser implements FactoryUser {

    @Override
    public User createUser(UserName userName, UserEmail userEmail, Role userRole) {
        return new User (userName, userEmail, userRole);
    }

}
