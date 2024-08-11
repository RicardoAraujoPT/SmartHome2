package smartHomeDDD.persistence.springdata;

import org.springframework.stereotype.Repository;
import smartHomeDDD.domain.repository.IRepositoryRole;
import smartHomeDDD.domain.role.FactoryRole;
import smartHomeDDD.domain.role.Role;
import smartHomeDDD.domain.valueobject.RoleName;

import java.util.Optional;

@Repository
public class RepositoryRoleSpringData implements IRepositoryRole {

    final IRepositoryRoleSpringData _repositoryRoleSpringData;

    final FactoryRole _factoryRole;

    public RepositoryRoleSpringData(IRepositoryRoleSpringData repositoryRoleSpringData, FactoryRole factoryRole) {
        if (repositoryRoleSpringData == null) {
            throw new IllegalArgumentException("Repository cannot be null");
        }
        if (factoryRole == null) {
            throw new IllegalArgumentException("Factory cannot be null");
        }

        _repositoryRoleSpringData = repositoryRoleSpringData;
        _factoryRole = factoryRole;
    }

    @Override
    public Role save(Role entity) {
        return null;
    }

    @Override
    public Iterable<Role> findAll() {
        return null;
    }

    @Override
    public Optional<Role> ofIdentity(RoleName id) {
        return Optional.empty();
    }

    @Override
    public boolean containsOfIdentity(RoleName id) {
        return false;
    }

    @Override
    public Role getRoleByName(RoleName roleName) {
        return null;
    }
}
