package smartHomeDDD.persistence.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import smartHomeDDD.persistence.datamodel.RoleDataModel;

public interface IRepositoryRoleSpringData extends JpaRepository<RoleDataModel, String>{
}
