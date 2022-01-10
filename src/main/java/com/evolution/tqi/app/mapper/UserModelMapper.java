package com.evolution.tqi.app.mapper;

import com.evolution.tqi.app.register_user.model.UserModel;
import com.evolution.tqi.app.register_user.request.UserModelPostRequestBody;
import com.evolution.tqi.app.register_user.response.UserModelPostResponseBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserModelMapper {
    public static final UserModelMapper INSTANCE = Mappers.getMapper(UserModelMapper.class);

    public abstract UserModel toUserModel(UserModelPostRequestBody userModelPostRequestBody);

    public abstract UserModelPostResponseBody toUserModelPostResponseBody(UserModel userModel);

}
