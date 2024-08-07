package smartHomeDDD.services;

import smartHomeDDD.domain.repository.IRepositoryRole;
import smartHomeDDD.domain.role.FactoryRole;
import smartHomeDDD.domain.role.Role;
import smartHomeDDD.domain.valueobject.RoleName;

public class ServiceRole {

    final FactoryRole _factoryRole;

    final IRepositoryRole _repositoryRole;


    public ServiceRole(FactoryRole factoryRole, IRepositoryRole repositoryRole) {
        if (factoryRole == null) {
            throw new IllegalArgumentException("Factory cannot be null");
        }
        if (repositoryRole == null) {
            throw new IllegalArgumentException("Repository cannot be null");
        }

        _factoryRole = factoryRole;
        _repositoryRole = repositoryRole;
    }

    public Role createRole(RoleName roleName) {
        Role role = _factoryRole.createRole(roleName);
        return _repositoryRole.save(role);
    }

    public Role getRole(RoleName roleName) {
        return _repositoryRole.getRoleByName(roleName);
    }





}
