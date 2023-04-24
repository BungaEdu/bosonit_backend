package com.example.block6pathvariableheaders;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @PostMapping("/greeting")
    public Greeting greetingPost(@RequestBody Greeting greeting) {
        return greeting;
    }

    @GetMapping("/user/{id}")
    public String getUserId(@PathVariable Long id) {
        return id.toString();
    }

    @PutMapping("/post")
    public Map<String, String> getParams(@RequestParam(name = "var1", required = true) String var1,
                                         @RequestParam(name = "var2", required = true) String var2) {
        Map<String, String> map = new HashMap<>();
        map.put("var1", var1);
        map.put("var2", var2);
        return map;
    }
}