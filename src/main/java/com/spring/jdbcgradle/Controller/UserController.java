package com.spring.jdbcgradle.Controller;

import com.spring.jdbcgradle.Commons.ResponseModels;
import com.spring.jdbcgradle.Commons.Roles;
import com.spring.jdbcgradle.Entity.User;
import com.spring.jdbcgradle.Repository.UserRepository;
import lombok.Data;
import lombok.Getter;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Getter
@Data
@RequestMapping(value = "/api/v1/user")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private ResponseModels responseModels = new ResponseModels();

    @RequestMapping(method = RequestMethod.GET)
    public JSONObject index() {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{user_id}")
    @ResponseBody
    public ResponseEntity getById(@PathVariable Integer user_id) {
        JSONObject successResponse = responseModels.responses("retrieve", "success");
        JSONObject failureResponse = responseModels.responses("retrieve", "failure");
        Optional<User> byId = userRepository.findById(user_id);
        if (byId.isPresent()) {
            User user = byId.get();
            successResponse.put("content", user);
        } else return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(failureResponse);
        return ResponseEntity.ok(successResponse);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity store(@RequestBody User user) {
        JSONObject successResponse = responseModels.responses("create", "success");
        JSONObject failureResponse = responseModels.responses("create", "failure");

        if (userRepository.findByFirstname(user.getFirstname()).size() > 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(failureResponse);
        }
        user.setRole(Roles.USER);
        userRepository.save(user);
        successResponse.put("content", user);
        return ResponseEntity.ok(successResponse);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{user_id}")
    @ResponseBody
    public ResponseEntity update(@PathVariable Integer user_id, @RequestBody User userRequest) {
        JSONObject successResponse = responseModels.responses("update", "success");
        JSONObject failureResponse = responseModels.responses("update", "failure");

        if (userRepository.findByFirstname(userRequest.getFirstname()).size() > 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(failureResponse);
        }
        Optional<User> byId = userRepository.findById(user_id);
        if (!byId.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failureResponse);
        }
        Optional<ResponseEntity<JSONObject>> jsonObjectResponseEntity = byId.map(user -> {
            user.setFirstname(userRequest.getFirstname());
            userRepository.save(user);
            return ResponseEntity.ok(successResponse);
        });
        if (jsonObjectResponseEntity.isPresent())
            return ResponseEntity.ok(successResponse);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(failureResponse);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{user_id}")
    @ResponseBody
    public ResponseEntity destroy(@PathVariable Integer user_id) {
        JSONObject successResponse = responseModels.responses("destroy", "success");
        JSONObject failureResponse = responseModels.responses("destroy", "failure");

        Optional<Boolean> aBoolean = userRepository.findById(user_id).map(post -> {
            userRepository.delete(post);
            return true;
        });
        if (aBoolean.isPresent())
            return ResponseEntity.ok(successResponse);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failureResponse);
    }
}