package smartHomeDDD.domain.role;

import org.springframework.stereotype.Component;
import smartHomeDDD.domain.valueobject.RoleName;

@Component
public class ImplFactoryRole implements FactoryRole {

    public Role createRole(RoleName roleName) {
        return new Role(roleName);
    }

}
