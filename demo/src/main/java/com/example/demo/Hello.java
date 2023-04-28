package com.example.demo;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class Hello {

    @GetMapping()
    public String hello(@RequestParam(value = "name") String name) {
        String msg = "Hello World " + name;
        return msg;
    }

    @PostMapping()
    public String sayHello(@RequestBody() Map<String, String> body) {
        String msg = "Say form Post " + body.get("name");
        return msg;
    }

    @PutMapping("/{name}")
    public String updateHello(@PathVariable String name, @RequestBody() NameDTO body) {
        String msg = "Say form Push  " + name + " " + body.getFirstname() + " " + body.getLastname();
        return msg;
    }

    @DeleteMapping("")
    public String deleteHello() {
        String msg = "Say form Delete";
        return msg;
    }
}
