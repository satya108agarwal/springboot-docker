package com.vmw.rpm.springbootdocker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RestController
public class FileController {

  @GetMapping("/")
  ResponseEntity helloThere(){
    return ResponseEntity.ok("Hi There");
  }

  @PostMapping("/createFile")
  public ResponseEntity<String> createFile() {
    try {
      File file = new File("/mnt/data/newFile.txt");
      if (file.createNewFile()) {
        FileWriter writer = new FileWriter(file);
        writer.write("This is some sample text that we're writing to the file!");
        writer.close();
        return ResponseEntity.ok("File created and text written successfully!");
      } else {
        return ResponseEntity.badRequest().body("File already exists!");
      }
    } catch ( Exception e) {
      e.printStackTrace();
      System.out.println(e.fillInStackTrace());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while creating or writing to file!" +e.fillInStackTrace());
    }
  }
}
