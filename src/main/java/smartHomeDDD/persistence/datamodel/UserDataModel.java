package smartHomeDDD.persistence.datamodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import smartHomeDDD.domain.role.Role;
import smartHomeDDD.domain.user.FactoryUser;
import smartHomeDDD.domain.user.User;
import smartHomeDDD.domain.valueobject.RoleName;
import smartHomeDDD.domain.valueobject.UserEmail;
import smartHomeDDD.domain.valueobject.UserName;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER")
public class UserDataModel {

    @Id
    @Column(name = "user_id")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "role")
    private String role;

    public UserDataModel() {
    }

    public UserDataModel(User user) {
        this.userName = user.identity().toString();
        this.userEmail = user.getUserEmail().toString();
        this.role = user.getRole().toString();
    }

    public static User toDomain(FactoryUser factoryUser, UserDataModel userDataModel) {
        UserName userName = new UserName(userDataModel.userName);
        UserEmail userEmail = new UserEmail(userDataModel.userEmail);

        RoleName roleName = RoleName.valueOf(userDataModel.role);
        Role role = new Role(roleName);

        User user = factoryUser.createUser(userName, userEmail, role);

        return user;
    }

    public static Iterable<User> toDomain(FactoryUser factoryUser, Iterable<UserDataModel> userDataModels) {
        List<User> users = new ArrayList<>();
        for (UserDataModel userDataModel : userDataModels) {
            users.add(toDomain(factoryUser, userDataModel));
        }
        return users;
    }


}
