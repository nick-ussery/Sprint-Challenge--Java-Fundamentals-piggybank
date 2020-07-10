package com.piggybank.piggybank.controllers;

import com.piggybank.piggybank.models.Coin;
import com.piggybank.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController
{
    @Autowired
    CoinRepository coinRepos;
    private List<Coin> findCoin(List<Coin> myList, CheckCoin tester)
    {
        List<Coin> tempList = new ArrayList<>();
        for(Coin c: myList)
        {
            if(tester.test(c))
            {
                tempList.add(c);
            }
        }
        return tempList;
    }

    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> listTotal()
    {
        List<Coin> myList = new ArrayList<>();
        coinRepos.findAll().iterator().forEachRemaining(myList::add);
        System.out.println(myList);
        double total=0;
        for(Coin c:myList)
        {
//            System.out.println(c);
            total += c.getValue();
        }
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

}
