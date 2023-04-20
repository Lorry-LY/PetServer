package com.lorry.petserver.service.information;

import com.lorry.petserver.dao.information.InformationMapper;
import com.lorry.petserver.utils.message.ResponseMessage;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PersonInfoService implements InformationService{

    @Resource
    private InformationMapper informationMapper;

    @Override
    public ResponseMessage getUserName() {
        informationMapper.getName();
        return null;
    }
}
