package com.lorry.petserver.dao.information;

import com.alibaba.fastjson.JSONObject;

public interface InformationMapper {

    JSONObject getName();

    JSONObject getUserInfo(String id);

    JSONObject getUserAvatarImage(String id) throws Exception;

    JSONObject getUserBackgroundImage(String id) throws Exception;
}
