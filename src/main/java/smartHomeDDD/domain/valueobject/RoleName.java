package smartHomeDDD.domain.valueobject;

import smartHomeDDD.ddd.DomainId;

public enum RoleName implements DomainId {

    ADMIN,
    POWER_USER,
    ROOM_OWNER,
    OWNER;

    public String toString() {
        return this.name();
    }


}
