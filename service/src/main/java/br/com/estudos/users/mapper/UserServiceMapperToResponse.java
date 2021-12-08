package br.com.estudos.users.mapper;

import br.com.estudos.users.entity.UserEntity;
import br.com.estudos.users.model.UserServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserServiceMapperToResponse {
    static UserServiceResponse toUserServiceResponse(UserEntity userEntity) {
        return Mappers.getMapper(UserServiceMapperToResponse.class).mapFromResponseToEntity(userEntity);
    }

    UserServiceResponse mapFromResponseToEntity(UserEntity userEntity);
}
