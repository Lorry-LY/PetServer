package com.lorry.petserver.service.post;


import com.lorry.petserver.utils.message.ResponseMessage;

public interface PostServiceInterface {


    ResponseMessage getPostInfo();

    ResponseMessage getPostInfo(String id);

    ResponseMessage getPostImage(String id, String image);
}
