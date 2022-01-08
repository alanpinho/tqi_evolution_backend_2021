package com.evolution.tqi.app.mapper;

import com.evolution.tqi.app.loan_application.model.LoanModel;
import com.evolution.tqi.app.loan_application.request.LoanRequestBody;
import com.evolution.tqi.app.loan_application.response.LoanResponseBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class LoanModelMapper {

    public static final LoanModelMapper INSTANCE = Mappers.getMapper(LoanModelMapper.class);

    public abstract LoanModel toLoanModel(LoanRequestBody request);

    public abstract LoanResponseBody toLoanResponseBody(LoanModel request);
}
