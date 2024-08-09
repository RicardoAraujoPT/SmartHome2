package smartHomeDDD.domain.User;

import org.junit.jupiter.api.Test;
import smartHomeDDD.domain.role.Role;
import smartHomeDDD.domain.user.User;
import smartHomeDDD.domain.valueobject.UserEmail;
import smartHomeDDD.domain.valueobject.UserName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class UserTest {

    @Test
    void createValidUser_shouldCreateUser() {
        // Arrange
        UserName userName = mock (UserName.class);
        UserEmail userEmail = mock(UserEmail.class);
        Role role = mock(Role.class);

        // Act
        User user = new User(userName,userEmail,role);

        // Assert
        assertEquals(user.getRoleName().toString(),userName.toString());
    }

    @Test
    void updateValidUserRole_shouldUpdateRole() {
        // Arrange
        UserName userName = mock (UserName.class);
        UserEmail userEmail = mock(UserEmail.class);
        Role role = mock(Role.class);

        // Act
        User user = new User(userName,userEmail,role);

        Role newRole = mock(Role.class);
        user.setRole(newRole);

        // Assert
        assertEquals(user.getRoleName().toString(),userName.toString());
    }



}
