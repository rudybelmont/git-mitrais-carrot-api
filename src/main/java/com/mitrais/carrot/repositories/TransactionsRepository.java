package com.mitrais.carrot.repositories;

import com.mitrais.carrot.models.Transactions;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rudy@mitrais.com
 */
public interface TransactionsRepository extends CrudRepository<Transactions, Integer> {

}
