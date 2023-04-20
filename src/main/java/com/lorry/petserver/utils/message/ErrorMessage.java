package com.lorry.petserver.utils.message;

import com.alibaba.fastjson.JSONObject;

public class ErrorMessage extends ResponseMessage {

    public ErrorMessage(String message) {
        jsonObject.put("code", 200);
        jsonObject.put("message", message);
        jsonObject.put("success", false);
        jsonObject.put("type", "error");
        jsonObject.put("data", null);
    }

    @Override
    public JSONObject getMessage() {
        return jsonObject;
    }
}
