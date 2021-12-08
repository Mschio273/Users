package br.com.estudos.users.mapper;

import br.com.estudos.users.entity.UserEntity;
import br.com.estudos.users.model.UserServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserServiceMapperToEntity {

    static UserEntity toUserEntityService(UserServiceRequest userServiceRequest) {
        return Mappers.getMapper(UserServiceMapperToEntity.class).mapFromEntityToRequest(userServiceRequest);
    }

    UserEntity mapFromEntityToRequest(UserServiceRequest userServiceRequest);

}
