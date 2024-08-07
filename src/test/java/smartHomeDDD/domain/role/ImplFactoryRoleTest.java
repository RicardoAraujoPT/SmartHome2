package smartHomeDDD.domain.role;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import smartHomeDDD.domain.valueobject.*;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImplFactoryRoleTest {

    @Test
    void createRole_shouldCreateRole() {
        // Arrange
        ImplFactoryRole implFactoryRole = new ImplFactoryRole();
        RoleName roleName = mock(RoleName.class);

        // Act
        try (MockedConstruction<Role> roleDouble = Mockito.mockConstruction(Role.class,
                (mock, context) -> {
                    RoleName name = (RoleName) context.arguments().get(0);
                    when(mock.getRoleName()).thenReturn(name);
                })) {

            Role roleCreated = implFactoryRole.createRole(roleName);

            // Assert
            List<Role> mockedRoles = roleDouble.constructed();
            Role mockedRole = mockedRoles.get(0);

            assertEquals(1, mockedRoles.size());
            assertEquals(roleName, mockedRole.getRoleName());

        }
    }

}
