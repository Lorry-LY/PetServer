package com.lorry.petserver.controller;


import com.lorry.petserver.service.information.InformationService;
import com.lorry.petserver.utils.message.ResponseMessage;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class InformationController {

    @Resource
    private InformationService informationService;

    @RequestMapping(value = "/info", method = RequestMethod.GET,params = {"id"})
    public ResponseMessage getUserInformation(
            @RequestParam(value = "id") String ID
    ) {
        return informationService.getUserInfo(ID);
    }

    @RequestMapping(value = "/info/avatar",method = RequestMethod.GET,params = {"id"})
    public ResponseMessage getUserAvatarImage(
            @RequestParam(value = "id") String ID
    ){
        return informationService.getUserAvatarImage(ID);
    }

    @RequestMapping(value = "/info/background",method = RequestMethod.GET,params = {"id"})
    public ResponseMessage getUserBackgroundImage(
            @RequestParam(value = "id") String ID
    ){
        return informationService.getUserBackgroundImage(ID);
    }

}
