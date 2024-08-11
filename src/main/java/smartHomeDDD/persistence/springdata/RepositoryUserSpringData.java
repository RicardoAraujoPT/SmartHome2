package smartHomeDDD.persistence.springdata;

import org.springframework.stereotype.Repository;
import smartHomeDDD.domain.repository.IRepositoryUser;
import smartHomeDDD.domain.user.FactoryUser;
import smartHomeDDD.domain.user.User;
import smartHomeDDD.domain.valueobject.UserName;
import smartHomeDDD.persistence.datamodel.UserDataModel;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryUserSpringData implements IRepositoryUser {

    final IRepositoryUserSpringData _repositoryUserSpringData;
    final FactoryUser _factoryUser;

    public RepositoryUserSpringData(FactoryUser factoryUser, IRepositoryUserSpringData repositoryUserSpringData) {
        if (factoryUser == null) {
            throw new IllegalArgumentException("Factory cannot be null");
        }
        if (repositoryUserSpringData == null) {
            throw new IllegalArgumentException("Repository cannot be null");
        }
        this._factoryUser = factoryUser;
        this._repositoryUserSpringData = repositoryUserSpringData;
    }


    @Override
    public User save(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (containsOfIdentity(user.identity())) {
            throw new IllegalArgumentException("User already exists");
        }
        UserDataModel userDataModel = new UserDataModel(user);
        this._repositoryUserSpringData.save(userDataModel);
        return user;
    }

    @Override
    public Iterable<User> findAll() {
        List<UserDataModel> userDataModels = this._repositoryUserSpringData.findAll();
        return UserDataModel.toDomain(_factoryUser, userDataModels);
    }

    @Override
    public Optional<User> ofIdentity(UserName id) {
        Optional<UserDataModel> userDataModel = this._repositoryUserSpringData.findById(id.toString());

        if (userDataModel.isPresent()) {
            User user = UserDataModel.toDomain(_factoryUser, userDataModel.get());
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean containsOfIdentity(UserName id) {
        return _repositoryUserSpringData.existsById(id.toString());
    }

    @Override
    public Optional<User> getUserByName(UserName userName) {
        Optional<UserDataModel> userDataModel = this._repositoryUserSpringData.findByUserName(userName.toString());
        if (userDataModel.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(UserDataModel.toDomain(_factoryUser, userDataModel.get()));
    }
}
