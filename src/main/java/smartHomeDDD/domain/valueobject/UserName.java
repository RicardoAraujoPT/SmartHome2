package smartHomeDDD.domain.valueobject;

import smartHomeDDD.ddd.DomainId;

public class UserName implements DomainId {

    private String _userName;

    public UserName(String userName) {
        this._userName = userName;
    }

    public String toString() {
        return this._userName;
    }

}
