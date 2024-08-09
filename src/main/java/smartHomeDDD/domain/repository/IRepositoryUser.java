package smartHomeDDD.domain.repository;

import smartHomeDDD.ddd.Repository;
import smartHomeDDD.domain.user.User;
import smartHomeDDD.domain.valueobject.UserName;

public interface IRepositoryUser extends Repository<UserName, User> {

    User getUserByName(UserName userName);
}
