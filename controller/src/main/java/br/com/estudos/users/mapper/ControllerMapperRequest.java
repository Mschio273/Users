package br.com.estudos.users.mapper;

import br.com.estudos.users.model.UserControllerRequest;
import br.com.estudos.users.model.UserServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ControllerMapperRequest {

    static UserServiceRequest toUserControllerRequest(UserControllerRequest userControllerRequest) {
        return Mappers.getMapper(ControllerMapperRequest.class).mapFromEntityUserController(userControllerRequest);
    }


    UserServiceRequest mapFromEntityUserController(UserControllerRequest userControllerRequest);

}
