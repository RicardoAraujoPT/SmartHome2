package smartHomeDDD.domain.role;


import smartHomeDDD.ddd.AggregateRoot;
import smartHomeDDD.domain.valueobject.RoleName;

public class Role implements AggregateRoot<RoleName> {

    private RoleName roleName;

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }


    @Override
    public RoleName identity() {
        return roleName;
    }

    @Override
    public boolean sameAs(Object object){
        if (object instanceof Role oRole) {
            return this.roleName.equals(oRole.roleName);
        }
        return false;
    }

}
