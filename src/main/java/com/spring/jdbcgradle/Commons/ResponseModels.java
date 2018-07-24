package com.spring.jdbcgradle.Commons;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ResponseModels {
    public JSONObject responses(String keyword, String status) {
        JSONObject response = new JSONObject();
        JSONObject statusObject = new JSONObject();
        response.put("content", new JSONArray());
        switch (keyword) {
            case "create":
                if (status.equals("success")) {
                    statusObject.put("code", 200);
                    statusObject.put("message", "Successfully created!");
                } else if (status.equals("unauthorized")) {
                    statusObject.put("message", "Unauthorized to created!");
                    statusObject.put("code", 401);
                } else {
                    statusObject.put("code", 409);
                    statusObject.put("message", "Failed to create!");
                }
                break;
            case "update":
                if (status.equals("success")) {
                    statusObject.put("message", "Successfully updated!");
                    statusObject.put("code", 200);
                } else if (status.equals("unauthorized")) {
                    statusObject.put("message", "Unauthorized to update!");
                    statusObject.put("code", 401);
                } else {
                    statusObject.put("message", "Failed to update!");
                    statusObject.put("code", 400);
                }
                break;
            case "retrieve":
                if (status.equals("success")) {
                    statusObject.put("code", 200);
                    statusObject.put("message", "Successfully retrieved!");
                } else if (status.equals("unauthorized")) {
                    statusObject.put("code", 401);
                    statusObject.put("message", "Unauthorized to retrieve!");
                } else {
                    statusObject.put("message", "Failed to retrieve!");
                    statusObject.put("code", 400);
                }
                break;
            case "destroy":
                if (status.equals("success")) {
                    statusObject.put("message", "Successfully deleted!");
                    statusObject.put("code", 200);
                } else if (status.equals("unauthorized")) {
                    statusObject.put("message", "Unauthorized to delete!");
                    statusObject.put("code", 401);
                } else {
                    statusObject.put("message", "Failed to delete!");
                    statusObject.put("code", 400);
                }
                break;
            default:
                statusObject.put("message", "Successfully deleted!");
                statusObject.put("code", 200);
                break;
        }

        response.put("status", statusObject);
        return response;
    }
}
