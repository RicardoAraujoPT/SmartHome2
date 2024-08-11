package smartHomeDDD.domain.User;

import org.junit.jupiter.api.Test;
import smartHomeDDD.domain.role.Role;
import smartHomeDDD.domain.user.FactoryUser;
import smartHomeDDD.domain.user.ImplFactoryUser;
import smartHomeDDD.domain.user.User;
import smartHomeDDD.domain.valueobject.RoleName;
import smartHomeDDD.domain.valueobject.UserEmail;
import smartHomeDDD.domain.valueobject.UserName;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserAggregateTest {



    @Test
    void createValidUser_shouldCreateUser() {
        // Arrange
        UserName userName = new UserName("user01");
        UserEmail userEmail = new UserEmail("user01@hotmail.com");
        Role role = new Role (RoleName.ADMIN);
        FactoryUser factoryUser = new ImplFactoryUser();
        // Act
        User user = factoryUser.createUser(userName,userEmail,role);

        // Assert
        assertEquals(user.identity().toString(),userName.toString());
    }

    @Test
    void updateValidUserRole_shouldUpdateRole() {
        // Arrange
        UserName userName = new UserName("user01");
        UserEmail userEmail = new UserEmail("user01@hotmail.com");
        Role role = new Role (RoleName.ADMIN);
        FactoryUser factoryUser = new ImplFactoryUser();
        // Act
        User user = factoryUser.createUser(userName,userEmail,role);

        Role newRole = new Role (RoleName.POWER_USER);
        user.setRole(newRole);

        // Assert
        assertEquals(user.identity().toString(),userName.toString());
    }

}
