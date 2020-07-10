package com.piggybank.controllers;

import com.piggybank.models.Coin;
import com.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
            if(c.getQuantity()>1)
            {
                System.out.println(c.getQuantity() + " " + c.getNameplural());
            }else
            {
                System.out.println(c.getQuantity() + " " + c.getName());
            }
            total += c.getValue()*c.getQuantity();
        }
        System.out.println("The piggy bank  holds " + total);
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

    @GetMapping(value ="/money/{amount}", produces = {"application/json"})
    public ResponseEntity<?> reduceAmount(@PathVariable double amount)
    {
        List<Coin> myList = new ArrayList<>();
        coinRepos.findAll().iterator().forEachRemaining(myList::add);
        double newAmt =amount;
        double total=0;
        for(Coin c: myList)
        {
            total += c.getQuantity()*c.getValue();
        }
        if(amount > total)
        {
            System.out.println("Money not available");
            return new ResponseEntity<>("Money not available", HttpStatus.OK);
        }else
        {
            if(amount > 1)
            {
                for(Coin c: myList)
                {
                    if(c.getName()=="Dollar")
                    {
                        if(c.getQuantity()*c.getValue() < amount)
                        {
                            newAmt -
                        }
                    }
                }
            }
        }

        total=0;
        for(Coin c: myList)
        {
            total += c.getQuantity()*c.getValue();
        }

        return new ResponseEntity<>(myList + "New Total" + total, HttpStatus.OK);
    }

}
