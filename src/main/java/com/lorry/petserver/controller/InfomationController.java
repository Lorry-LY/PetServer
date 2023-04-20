package com.lorry.petserver.controller;


import com.lorry.petserver.service.information.InformationService;
import com.lorry.petserver.utils.message.ResponseMessage;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/info")
public class InfomationController {

    @Resource
    private InformationService informationService;

    @RequestMapping(value = "/name", method = RequestMethod.GET, params = {"id"})
    public ResponseMessage getUserInformation(
            @RequestParam(value = "id") int ID
    ) {
        return informationService.getUserName();
    }

}
