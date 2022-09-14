package com.aks.commons.graphql;

import com.aks.commons.controller.BaseRequest;
import com.aks.commons.controller.BaseResponse;
import com.aks.commons.jpa.BaseEntity;

import javax.validation.Valid;
import java.util.Optional;

public interface GraphQLMutationResolver<
        Request extends BaseRequest,
        Response extends BaseResponse,
        Entity extends BaseEntity,
        ID> {

    Optional<Response> update(@Valid Request requestModel);
    Optional<Response> insert(@Valid Request requestModel);

    Entity updateAndReturnEntity(@Valid Request requestModel);
    Entity insertAndReturnEntity(@Valid Request requestModel);

    void deleteById(@Valid ID id);

    void softDeleteById(@Valid ID id);
}


