package smartHomeDDD.services;

import org.junit.jupiter.api.Test;
import smartHomeDDD.domain.repository.IRepositoryRole;
import smartHomeDDD.domain.role.FactoryRole;
import smartHomeDDD.domain.role.ImplFactoryRole;
import smartHomeDDD.domain.role.Role;
import smartHomeDDD.domain.valueobject.RoleName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServiceRoleTest {

    @Test
    void testServiceRoleConstructor_shouldConstructServiceObject() {
        // Arrange
        IRepositoryRole repositoryRole = mock(IRepositoryRole.class);
        FactoryRole factoryRole = mock(FactoryRole.class);

        // Act
        ServiceRole serviceRole = new ServiceRole(factoryRole, repositoryRole);

        // Assert
        assertNotNull(serviceRole);
    }

    @Test
    void testCreateRole_shouldCreateRole() {
        // Arrange
        IRepositoryRole repositoryRole = mock(IRepositoryRole.class);
        FactoryRole factoryRole = new ImplFactoryRole();
        ServiceRole serviceRole = new ServiceRole(factoryRole, repositoryRole);
        RoleName roleName = RoleName.ADMIN;
        Role role = factoryRole.createRole(roleName);
        when(repositoryRole.save(any())).thenReturn(role);

        // Act
        Role createdRole = serviceRole.createRole(roleName);

        // Assert
        assertEquals(roleName, createdRole.getRoleName());
    }


    @Test
    void testGetRole_shouldGetRole() {
        // Arrange
        IRepositoryRole repositoryRole = mock(IRepositoryRole.class);
        FactoryRole factoryRole = new ImplFactoryRole();
        ServiceRole serviceRole = new ServiceRole(factoryRole, repositoryRole);
        RoleName roleName = RoleName.ADMIN;
        Role role = factoryRole.createRole(roleName);
        when(repositoryRole.getRoleByName(roleName)).thenReturn(role);

        // Act
        Role createdRole = serviceRole.getRole(roleName);

        // Assert
        assertEquals(roleName, createdRole.getRoleName());
    }


}
