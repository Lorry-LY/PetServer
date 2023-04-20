package com.lorry.petserver.utils.message;

import com.alibaba.fastjson.JSONObject;

public abstract class ResponseMessage {

    protected JSONObject jsonObject = new JSONObject();

    abstract public JSONObject getMessage();

}
