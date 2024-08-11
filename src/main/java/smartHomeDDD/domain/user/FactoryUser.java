package smartHomeDDD.domain.user;

import smartHomeDDD.domain.role.Role;
import smartHomeDDD.domain.valueobject.UserEmail;
import smartHomeDDD.domain.valueobject.UserName;

public interface FactoryUser {

    User createUser(UserName userName, UserEmail userEmail, Role userRole);
}
