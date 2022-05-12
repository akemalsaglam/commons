package com.aks.commons.graphql;

import com.aks.commons.controller.BaseRequest;
import com.aks.commons.controller.BaseResponse;

import javax.validation.Valid;
import java.util.Optional;

public interface GraphQLMutationResolver<
        Request extends BaseRequest,
        Response extends BaseResponse,
        ID> {

    Optional<Response> update(@Valid Request requestModel);

    Optional<Response> insert(@Valid Request requestModel);

    void deleteById(@Valid ID id);

    void softDeleteById(@Valid ID id);
}


