package br.com.estudos.users.mapper;

import br.com.estudos.users.model.UserControllerRequest;
import br.com.estudos.users.model.UserControllerResponse;
import br.com.estudos.users.model.UserServiceRequest;
import br.com.estudos.users.model.UserServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ControllerMapper {

    static UserServiceRequest toUserControllerRequest(UserControllerRequest userControllerRequest) {
        return Mappers.getMapper(ControllerMapper.class).mapFromEntityUserController(userControllerRequest);
    }

    static UserControllerResponse toUserControllerResponse(UserServiceResponse userServiceResponse) {
        return Mappers.getMapper(ControllerMapper.class).mapFromServiceRequestToResponse(userServiceResponse);
    }
    UserServiceRequest mapFromEntityUserController(UserControllerRequest userControllerRequest);

    UserControllerResponse mapFromServiceRequestToResponse(UserServiceResponse userServiceResponse);

}
