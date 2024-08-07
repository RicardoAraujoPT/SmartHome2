package smartHomeDDD.domain.role;

import org.junit.jupiter.api.Test;
import smartHomeDDD.domain.valueobject.RoleName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleAggregateTest {

    @Test
    void createValidRole_shouldCreateRole() {
        // Arrange
        String roleNameString = "ADMIN";
        RoleName roleName = RoleName.ADMIN;
        FactoryRole factoryRole = new ImplFactoryRole();

        // Act
        Role role = factoryRole.createRole(roleName);

        // Assert
        assertEquals(roleNameString,role.getRoleName().toString());
    }
}
