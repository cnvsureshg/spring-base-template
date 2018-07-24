package com.spring.jdbcgradle.Controller;

import com.spring.jdbcgradle.Commons.ResponseModels;
import lombok.Data;
import lombok.Getter;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Getter
@Data
@RequestMapping(value = "/api/v1/model")
@RestController
public class ResourceControllerModel {

    private ResponseModels responseModels = new ResponseModels();

    /****
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity index() {
        JSONObject successResponse = responseModels.responses("retrieve", "success");
        JSONObject failureResponse = responseModels.responses("retrieve", "failure");

        return ResponseEntity.ok(successResponse);
    }

    /*****
     *
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public ResponseEntity getById(@PathVariable Integer id) {
        JSONObject successResponse = responseModels.responses("retrieve", "success");
        JSONObject failureResponse = responseModels.responses("retrieve", "failure");
        if (true) {

        } else return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(failureResponse);
        return ResponseEntity.ok(successResponse);
    }

    /****
     *
     * @param reqObject
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity store(@RequestBody JSONObject reqObject) {
        JSONObject successResponse = responseModels.responses("create", "success");
        JSONObject failureResponse = responseModels.responses("create", "failure");

        return ResponseEntity.ok(successResponse);
    }

    /****
     *
     * @param object
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    @ResponseBody
    public ResponseEntity update(@RequestBody JSONObject object, @PathVariable Integer id) {
        JSONObject successResponse = responseModels.responses("update", "success");
        JSONObject failureResponse = responseModels.responses("update", "failure");

        return ResponseEntity.ok(successResponse);
    }

    /****
     *
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseBody
    public ResponseEntity destroy(@PathVariable Integer id) {
        JSONObject successResponse = responseModels.responses("destroy", "success");
        JSONObject failureResponse = responseModels.responses("destroy", "failure");

        return ResponseEntity.ok(successResponse);
    }

}
