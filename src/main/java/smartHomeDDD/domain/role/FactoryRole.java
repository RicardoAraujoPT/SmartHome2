package smartHomeDDD.domain.role;

import smartHomeDDD.domain.valueobject.RoleName;

/**
 * A factory interface for creating instances of {@link Role}.
 */
public interface FactoryRole {

    Role createRole(RoleName roleName);
}
