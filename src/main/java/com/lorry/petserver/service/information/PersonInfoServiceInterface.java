package com.lorry.petserver.service.information;

import com.lorry.petserver.utils.message.ResponseMessage;

public interface PersonInfoServiceInterface {

    ResponseMessage getUserName();

    ResponseMessage getUserInfo(String id);

    ResponseMessage getUserAvatarImage(String id);

    ResponseMessage getUserBackgroundImage(String id);
}
