package br.com.estudos.users.mapper;

import br.com.estudos.users.model.UserControllerRequest;
import br.com.estudos.users.model.UserServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ControllerMapperRequestWithId {

    static UserServiceRequest toUserControllerRequestWithId(UserControllerRequest userControllerRequest, String id) {
        return Mappers.getMapper(ControllerMapperRequestWithId.class).mapFromEntityUserControllerWithId(userControllerRequest, id);
    }

    @Mapping(target = "id", source = "id")
    UserServiceRequest mapFromEntityUserControllerWithId(UserControllerRequest userControllerRequest, String id);

}
