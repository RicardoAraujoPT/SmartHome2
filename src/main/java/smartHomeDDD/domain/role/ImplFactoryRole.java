package smartHomeDDD.domain.role;

import smartHomeDDD.domain.valueobject.RoleName;

public class ImplFactoryRole implements FactoryRole {

    public Role createRole(RoleName roleName) {
        return new Role(roleName);
    }

}
