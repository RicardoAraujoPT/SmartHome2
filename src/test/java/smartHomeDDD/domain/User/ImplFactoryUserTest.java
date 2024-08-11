package smartHomeDDD.domain.User;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import smartHomeDDD.domain.role.Role;
import smartHomeDDD.domain.user.ImplFactoryUser;
import smartHomeDDD.domain.user.User;
import smartHomeDDD.domain.valueobject.UserEmail;
import smartHomeDDD.domain.valueobject.UserName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

 class ImplFactoryUserTest {

    @Test
    void createUser_shouldCreateUser() {
        // Arrange
        ImplFactoryUser implFactoryUser = new ImplFactoryUser();
        UserName userName = mock(UserName.class);
        UserEmail userEmail = mock (UserEmail.class);
        Role role = mock (Role.class);

        // Act
        try (MockedConstruction<User> UserDouble = Mockito.mockConstruction(User.class,
                (mock, context) -> {
                    UserName name = (UserName) context.arguments().get(0);
                    UserEmail userEmail1 = (UserEmail) context.arguments().get(1);
                    Role role1 = (Role) context.arguments().get(2);
                    when(mock.identity()).thenReturn(name);
                    when(mock.getUserEmail()).thenReturn(userEmail1);
                    when(mock.getRole()).thenReturn(role1);
                })) {

            implFactoryUser.createUser(userName,userEmail,role);

            // Assert
            List<User> mockedUsers = UserDouble.constructed();
            User mockedUser = mockedUsers.get(0);

            assertEquals(1, mockedUsers.size());
            assertEquals(userName, mockedUser.identity());

        }
    }
}
