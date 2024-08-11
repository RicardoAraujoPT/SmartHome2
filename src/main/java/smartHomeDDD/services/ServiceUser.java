package smartHomeDDD.services;


import org.springframework.stereotype.Service;
import smartHomeDDD.domain.repository.IRepositoryUser;
import smartHomeDDD.domain.role.Role;
import smartHomeDDD.domain.user.FactoryUser;
import smartHomeDDD.domain.user.User;
import smartHomeDDD.domain.valueobject.RoleName;
import smartHomeDDD.domain.valueobject.UserEmail;
import smartHomeDDD.domain.valueobject.UserName;

import java.util.Optional;

@Service
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
        Optional<User> user = _repositoryUser.getUserByName(userName);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        if (user.get().identity().toString().equals(roleName.toString())) {
            throw new IllegalArgumentException("Role Name cannot be similar");
        }
        Role role = _serviceRole.createRole(roleName);

        user.get().setRoleName(userName);
        return user.get();
    }

    public Optional<User> findByName (String userName) {
        UserName userName1 = new UserName(userName);
        return _repositoryUser.getUserByName(userName1);
    }

    public Iterable<User> findAll() {
        return _repositoryUser.findAll();
    }


}
