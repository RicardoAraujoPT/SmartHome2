package smartHomeDDD.domain.role;

import org.junit.jupiter.api.Test;
import smartHomeDDD.domain.valueobject.RoleName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class RoleTest {

    @Test
    void createValidRole_shouldCreateRole() {
        // Arrange
        RoleName roleNameDouble = mock(RoleName.class);

        // Act
        Role role = new Role(roleNameDouble);

        // Assert
        assertEquals(role.getRoleName().toString(),roleNameDouble.toString());
    }



}
