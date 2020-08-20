package com.ag04smarts.sha.controller;


import java.lang.reflect.Array;

import com.ag04smarts.sha.utils.MappingConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api(description = "This is basic Apache Common Lib example controller")
@RestController
@RequestMapping(value = MappingConstants.APACHE)
public class ApacheCommonLibController {

    @ApiOperation(value = "Get an Array of 'number' which is copied 'copies' times ", response = Array.class)
    @PostMapping
    public ResponseEntity<?> testApacheLib(
        @ApiParam(value = "Number which will be printed in array", required = true) @RequestParam("number") int number,
        @ApiParam(value = "Number of copies of selected number in array", required = true) @RequestParam("copies") int copies
    ) {
        Bag<Integer> bag = new HashBag<>();

        bag.add(number, copies);

        return ResponseEntity.ok(bag.toArray());
    }
}
