package smartHomeDDD.persistence.datamodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "ROLE")
public class RoleDataModel {

    @Id
    @Column(name = "role_id")
    private String roleName;

    public RoleDataModel() {
    }
}
