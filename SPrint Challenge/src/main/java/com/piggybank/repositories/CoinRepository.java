package com.piggybank.repositories;

import com.piggybank.models.Coin;
import org.springframework.data.repository.CrudRepository;

public interface CoinRepository extends CrudRepository<Coin, Long>
{

}
