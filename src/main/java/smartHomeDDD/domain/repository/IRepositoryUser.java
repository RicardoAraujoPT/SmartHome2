package smartHomeDDD.domain.repository;

import smartHomeDDD.ddd.Repository;
import smartHomeDDD.domain.user.User;
import smartHomeDDD.domain.valueobject.UserName;

import java.util.Optional;

public interface IRepositoryUser extends Repository<UserName,User> {

    Optional<User> getUserByName(UserName userName);


}
