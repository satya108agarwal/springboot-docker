package com.vmw.rpm.springbootdocker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RestController
public class ConfigController {

@Value("${test.propname:my default value}")
private String propname;

@Value("${test.key1:my default value for key1}")
private String key1;

  @GetMapping("/config")
  ResponseEntity config(){
    return ResponseEntity.ok("Hi There propname value is ..." +propname +" ...key 1 "+key1);
  }


}