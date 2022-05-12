package com.aks.commons.graphql;

import com.aks.commons.controller.BaseResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface GraphQLQueryResolver<Response extends BaseResponse, ID> {

    Optional<Response> getById(@Valid ID id);

    List<Response> getAll();
}


