package smartHomeDDD.domain.user;

import smartHomeDDD.ddd.AggregateRoot;
import smartHomeDDD.domain.role.Role;
import smartHomeDDD.domain.valueobject.UserEmail;
import smartHomeDDD.domain.valueobject.UserName;

public class User implements AggregateRoot<UserName> {

    private UserName _userName;

    private UserEmail _userEmail;

    private Role _role;

    public User(UserName userName, UserEmail userEmail, Role userRole) {
        this._userName = userName;
        this._userEmail = userEmail;
        this._role = userRole;
    }

    @Override
    public UserName identity() {
        return _userName;
    }

    public UserEmail getUserEmail() {
        return _userEmail;
    }

    public void setUserEmail(UserEmail userEmail) {
        this._userEmail = userEmail;
    }

    public void setRoleName(UserName userName) {
        this._userName = userName;
    }

    public Role getRole() {
        return _role;
    }

    public void setRole(Role role) {
        this._role = role;
    }


    @Override
    public boolean sameAs(Object object) {
        if (object instanceof smartHomeDDD.domain.user.User oUser) {
            return this._userName.equals(oUser._userName);
        }
        return false;
    }


}
