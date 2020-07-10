package com.lambda.javapiggybank.controllers;

import com.lambda.javapiggybank.models.Coin;
import com.lambda.javapiggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CoinController {
    @Autowired
    CoinRepository coinrepos;
    // http://localhost:2019/total
    /*
    In your console in IntelliJ you should see:

```TEXT
    1 Quarter
    1 Dime
    5 Dollars
    3 Nickels
    7 Dimes
    1 Dollar
    10 Pennies
    The piggy bank holds 7.3
     */
    @GetMapping(value = "/total",
    produces = {"application/json"})
    public ResponseEntity<?> listTotal(){
        List<Coin> myList = new ArrayList<>();
        coinrepos.findAll().iterator().forEachRemaining(myList::add);
//        myList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        for(int i=0; i < myList.size(); i++) System.out.println(myList.get(i));
        double sum = 0;
        for(int i=0; i< myList.size(); i++) sum += myList.get(i).getQuantity() * myList.get(i).getValue();
        System.out.println("The piggy bank holds " + sum);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
