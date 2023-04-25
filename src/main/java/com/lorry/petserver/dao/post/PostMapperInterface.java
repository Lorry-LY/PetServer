package com.lorry.petserver.dao.post;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.List;

public interface PostMapperInterface {
    List<JSONObject> getPostInfo();

    JSONObject getPostInfo(String id);

    JSONObject getPostImage(String id, String image) throws Exception;
}
