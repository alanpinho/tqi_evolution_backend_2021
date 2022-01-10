package com.evolution.tqi.app.util.loan_application;

import com.evolution.tqi.app.loan_application.request.EmbeddedUserRequestBody;
import com.evolution.tqi.app.util.UserCreator;

public class EmbeddedUserRequestBodyCreator {
    public static EmbeddedUserRequestBody createEmbeddedUserRequestBody(){
        return EmbeddedUserRequestBody.builder()
                .id(UserCreator.createUser().getId())
                .build();
    }
}
