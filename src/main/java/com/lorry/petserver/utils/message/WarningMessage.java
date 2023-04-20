package com.lorry.petserver.utils.message;

import com.alibaba.fastjson.JSONObject;

public class WarningMessage extends ResponseMessage {
    JSONObject jsonObject = new JSONObject();

    public WarningMessage(String message) {
        jsonObject.put("code", 249);
        jsonObject.put("message", message);
        jsonObject.put("success", false);
        jsonObject.put("type", "warning");
        jsonObject.put("data", null);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}