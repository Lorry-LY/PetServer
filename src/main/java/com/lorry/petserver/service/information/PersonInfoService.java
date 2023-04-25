package com.lorry.petserver.service.information;

import com.alibaba.fastjson.JSONObject;
import com.lorry.petserver.dao.information.PersonInfoMapperInterface;
import com.lorry.petserver.utils.message.ErrorMessage;
import com.lorry.petserver.utils.message.ResponseMessage;
import com.lorry.petserver.utils.message.SuccessMessage;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PersonInfoService implements PersonInfoServiceInterface {

    @Resource
    private PersonInfoMapperInterface informationMapper;

    @Override
    public ResponseMessage getUserName() {
        informationMapper.getName();
        return null;
    }

    @Override
    public ResponseMessage getUserInfo(String id) {
        JSONObject userInfo = informationMapper.getUserInfo(id);
        if(userInfo==null)return new ErrorMessage("信息不存在");
        return new SuccessMessage<>("success",userInfo);
    }

    @Override
    public ResponseMessage getUserAvatarImage(String id) {
        JSONObject userInfo = null;
        try {
            userInfo = informationMapper.getUserAvatarImage(id);
            if(userInfo==null)throw new Exception();
        } catch (Exception e) {
            return new ErrorMessage("头像不存在");
        }
        return new SuccessMessage<>("success",userInfo);
    }

    @Override
    public ResponseMessage getUserBackgroundImage(String id) {
        JSONObject userInfo = null;
        try {
            userInfo = informationMapper.getUserBackgroundImage(id);
            if(userInfo==null)throw new Exception();
        } catch (Exception e) {
            return new ErrorMessage("背景图片不存在");
        }
        return new SuccessMessage<>("success",userInfo);
    }
}
