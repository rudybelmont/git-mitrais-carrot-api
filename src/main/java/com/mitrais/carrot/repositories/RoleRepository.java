package com.mitrais.carrot.repositories;

/**
 *
 * @author Febri_MW251@mitrais.com
 */
import com.mitrais.carrot.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {

    /**
     * find by role name
     *
     * @param roleName
     * @return
     */
    public Role findByRoleName(String roleName);

}
