package smartHomeDDD.domain.valueobject;

import smartHomeDDD.ddd.DomainId;

public class UserEmail implements DomainId {

    private String _userEmail;

    public UserEmail(String userEmail) {
        this._userEmail = userEmail;
    }

    public String toString() {
        return this._userEmail;
    }

}
