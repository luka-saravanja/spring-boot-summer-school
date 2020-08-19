package com.ag04smarts.sha.controller;


import com.ag04smarts.sha.utils.MappingConstants;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = MappingConstants.APACHE)
public class ApacheCommonLibController {

    @PostMapping
    public ResponseEntity<?> testApacheLib(
        @RequestParam("number") int number,
        @RequestParam("copies") int copies
    ) {
        Bag<Integer> bag = new HashBag<>();

        bag.add(number, copies);

        return ResponseEntity.ok(bag.toArray());
    }
}
