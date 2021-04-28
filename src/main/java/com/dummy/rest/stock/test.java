package com.dummy.rest.stock;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/test/")
public class test {
    

    @GetMapping(value="/test1")
    public ResponseEntity<String> test1() {
        
        return new ResponseEntity<>("Test 1", HttpStatus.OK);
    }
    

}
