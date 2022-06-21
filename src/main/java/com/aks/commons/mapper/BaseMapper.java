package com.aks.commons.mapper;


import com.aks.commons.controller.BaseRequest;
import com.aks.commons.controller.BaseResponse;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface BaseMapper<Entity, Request extends BaseRequest, Response extends BaseResponse> {

    Response mapEntityToResponse(Entity entity);

    List<Response> mapEntityListToResponseList(List<Entity> entity);

    Entity mapRequestToEntity(Request request);

    Entity mapRequestToEntity(Request request, @MappingTarget Entity entity);

    List<Entity> mapRequestListToEntitylist(List<Request> request);
}
