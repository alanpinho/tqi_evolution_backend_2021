package com.evolution.tqi.app.util.loan_application;

import com.evolution.tqi.app.loan_application.response.EmbeddedUserResponseBody;
import com.evolution.tqi.app.util.UserCreator;

public class EmbeddedUserResponseBodyCreator {
    public static EmbeddedUserResponseBody createEmbeddedUserResponseBody(){
        return EmbeddedUserResponseBody.builder()
                .id(UserCreator.createUser().getId())
                .build();
    }
}
