package smartHomeDDD.persistence.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import smartHomeDDD.persistence.datamodel.UserDataModel;

import java.util.Optional;

public interface IRepositoryUserSpringData extends JpaRepository<UserDataModel, String> {


    Optional<UserDataModel> findByUserName(String string);
}
