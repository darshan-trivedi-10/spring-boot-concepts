package com.learning.spring_boot.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private static final Map<Integer, String> users = new HashMap<>();

    static {
        users.put(1, "Alice");
        users.put(2, "Bob");
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id) throws Exception {
        if (!users.containsKey(id)){
            throw new ResourceNotFoundException("User with ID " + id + " not found");
        }

        if (id == 1){
            throw new Exception("Something Went Wrong !!");
        }

        return users.get(id);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

//    This will throw 500
//    @ExceptionHandler(ResourceNotFoundException.class)
//    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource Not Found")
//    public void handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletResponse response) throws IOException {
//        response.sendError(HttpStatus.FORBIDDEN.value(), "Hello");
//    }

}