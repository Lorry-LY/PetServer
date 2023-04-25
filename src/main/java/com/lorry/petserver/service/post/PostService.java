package com.lorry.petserver.service.post;

import com.alibaba.fastjson.JSONObject;
import com.lorry.petserver.dao.information.PersonInfoMapperInterface;
import com.lorry.petserver.dao.post.PostMapperInterface;
import com.lorry.petserver.utils.message.ErrorMessage;
import com.lorry.petserver.utils.message.ResponseMessage;
import com.lorry.petserver.utils.message.SuccessMessage;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements PostServiceInterface {

    @Resource
    private PostMapperInterface postMapper;

    @Resource
    private PersonInfoMapperInterface personInfoMapper;

    @Override
    public ResponseMessage getPostInfo() {
        List<JSONObject> postInfos = postMapper.getPostInfo();
        if (postInfos==null)return new ErrorMessage("mapper错误");
        for(JSONObject postInfo : postInfos){
            JSONObject userInfo = personInfoMapper.getUserInfo(postInfo.getString("author_id"));
            postInfo.put("author_name",userInfo.getString("name"));
        }
        return new SuccessMessage<>("all data",postInfos);
    }

    @Override
    public ResponseMessage getPostInfo(String id) {
        JSONObject jsonObject = postMapper.getPostInfo(id);
        if (jsonObject==null)return new ErrorMessage("mapper错误");
        return new SuccessMessage<>("all data",jsonObject);
    }

    @Override
    public ResponseMessage getPostImage(String id, String image) {
        JSONObject jsonObject = null;
        try {
            jsonObject = postMapper.getPostImage(id,image);
            if (jsonObject==null)throw new Exception();
        }catch (Exception e){
            return new ErrorMessage("mapper错误");
        }
        return new SuccessMessage<>("success",jsonObject);
    }
}
