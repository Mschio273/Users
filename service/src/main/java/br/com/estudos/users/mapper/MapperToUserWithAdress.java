package br.com.estudos.users.mapper;

import br.com.estudos.users.entity.UserEntity;
import br.com.estudos.users.model.Address;
import br.com.estudos.users.model.UserServiceRequest;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(componentModel = "spring")
public interface MapperToUserWithAdress {

    static UserEntity mapAddress(UserServiceRequest user, Address address) {
        return Mappers.getMapper(MapperToUserWithAdress.class).toCepServiceResponse(user);
    }

    @Mapping(target = "address", ignore = true)
    UserEntity toCepServiceResponse(UserServiceRequest user);

    @AfterMapping
    default void map(@MappingTarget UserServiceRequest.UserServiceRequestBuilder user, Address cep) {
        Address address = Address.builder()
                .cep(cep.getCep())
                .bairro(cep.getBairro())
                .complemento(cep.getComplemento())
                .ibge(cep.getIbge())
                .localidade(cep.getLocalidade())
                .logradouro(cep.getLogradouro())
                .uf(cep.getUf())
                .build();

        user.address(address);
    }
}
