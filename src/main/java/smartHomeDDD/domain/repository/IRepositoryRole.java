package smartHomeDDD.domain.repository;

import smartHomeDDD.ddd.Repository;
import smartHomeDDD.domain.role.Role;
import smartHomeDDD.domain.valueobject.RoleName;

import java.util.List;


public interface IRepositoryRole extends Repository<RoleName, Role> {


    Role getRoleByName(RoleName roleName);

}
