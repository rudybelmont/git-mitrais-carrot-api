package com.mitrais.carrot.repositories;

import com.mitrais.carrot.models.SharingLevel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rudy@mitrais.com
 */
public interface SharingLevelRepository extends CrudRepository<SharingLevel, Integer> {

    /**
     * delete data
     *
     * @param deleted
     */
    @Override
    public void delete(SharingLevel deleted);

}
