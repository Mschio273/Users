package br.com.estudos.users.mapper;

import br.com.estudos.users.entity.UserEntity;
import br.com.estudos.users.model.UserServiceRequest;
import br.com.estudos.users.model.UserServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserServiceMapper {

    static UserEntity toUserEntityService(UserServiceRequest userServiceRequest) {
        return Mappers.getMapper(UserServiceMapper.class).mapFromEntityToRequest(userServiceRequest);
    }

    static UserServiceResponse toUserServiceResponse(UserEntity userEntity) {
        return Mappers.getMapper(UserServiceMapper.class).mapFromResponseToEntity(userEntity);
    }

    UserEntity mapFromEntityToRequest(UserServiceRequest userServiceRequest);

    UserServiceResponse mapFromResponseToEntity(UserEntity userEntity);
}
