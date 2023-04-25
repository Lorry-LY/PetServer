package com.lorry.petserver.controller;


import com.alibaba.fastjson.JSONObject;
import com.lorry.petserver.service.information.PersonInfoServiceInterface;
import com.lorry.petserver.utils.message.ResponseMessage;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class InformationController {

    @Resource
    private PersonInfoServiceInterface informationService;

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public ResponseMessage getUserInformation(
            @RequestBody JSONObject body
    ) {
        String ID = body.getString("ID");
        return informationService.getUserInfo(ID);
    }

    @RequestMapping(value = "/info/avatar",method = RequestMethod.POST)
    public ResponseMessage getUserAvatarImage(
            @RequestBody JSONObject body
    ){
        String ID = body.getString("ID");
        return informationService.getUserAvatarImage(ID);
    }

    @RequestMapping(value = "/info/background",method = RequestMethod.POST)
    public ResponseMessage getUserBackgroundImage(
            @RequestBody JSONObject body
    ){
        String ID = body.getString("ID");
        return informationService.getUserBackgroundImage(ID);
    }

}
