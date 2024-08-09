package smartHomeDDD.domain.user;

import smartHomeDDD.domain.role.Role;
import smartHomeDDD.domain.valueobject.UserEmail;
import smartHomeDDD.domain.valueobject.UserName;

public class ImplFactoryUser implements FactoryUser {

    @Override
    public User createUser(UserName userName, UserEmail userEmail, Role userRole) {
        return new User (userName, userEmail, userRole);
    }

}
