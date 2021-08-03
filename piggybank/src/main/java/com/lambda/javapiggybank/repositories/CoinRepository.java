package com.lambda.javapiggybank.repositories;

import com.lambda.javapiggybank.models.Coin;
import org.springframework.data.repository.CrudRepository;

public interface CoinRepository extends CrudRepository<Coin, Long> {
}
