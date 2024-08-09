package smartHomeDDD.services;


import smartHomeDDD.domain.repository.IRepositoryUser;
import smartHomeDDD.domain.role.Role;
import smartHomeDDD.domain.user.FactoryUser;
import smartHomeDDD.domain.user.User;
import smartHomeDDD.domain.valueobject.RoleName;
import smartHomeDDD.domain.valueobject.UserEmail;
import smartHomeDDD.domain.valueobject.UserName;


public class ServiceUser {

    final FactoryUser _factoryUser;

    final IRepositoryUser _repositoryUser;

    final ServiceRole _serviceRole;

    public ServiceUser(FactoryUser factoryUser, IRepositoryUser repositoryUser, ServiceRole serviceRole) {
        if (factoryUser == null) {
            throw new IllegalArgumentException("Factory cannot be null");
        }
        if (repositoryUser == null) {
            throw new IllegalArgumentException("Repository cannot be null");
        }
        if (serviceRole == null) {
            throw new IllegalArgumentException("ServiceRole cannot be null");
        }
        this._factoryUser = factoryUser;
        this._repositoryUser = repositoryUser;
        this._serviceRole = serviceRole;
    }

    public User createUser (UserName userName, UserEmail userEmail, RoleName roleName) {
        Role role = _serviceRole.createRole(roleName);
        return _factoryUser.createUser(userName,userEmail,role);
    }

    public User updateUserRole (UserName userName, RoleName roleName) {
        User user = _repositoryUser.getUserByName(userName);
        if (user.getRoleName().toString().equals(roleName.toString())) {
            throw new IllegalArgumentException("Role Name cannot be similar");
        }
        Role role = _serviceRole.createRole(roleName);

        user.setRole(role);
        return user;
    }
}
