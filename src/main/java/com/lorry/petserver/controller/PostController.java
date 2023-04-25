package com.lorry.petserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.lorry.petserver.service.post.PostServiceInterface;
import com.lorry.petserver.utils.message.ResponseMessage;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Resource
    private PostServiceInterface postService;

    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public ResponseMessage getPostInfo(
            @RequestBody JSONObject body
    ){
        String ID = body.getString("ID");
        if(ID==null)return postService.getPostInfo();
        return postService.getPostInfo(ID);
    }

    @RequestMapping(value = "/info/img",method = RequestMethod.POST)
    public ResponseMessage getPostImage(
            @RequestBody JSONObject body
    ){
        String ID = body.getString("ID");
        String image = body.getString("image");
        return postService.getPostImage(ID,image);
    }

}
