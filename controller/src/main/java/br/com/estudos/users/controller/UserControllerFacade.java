package br.com.estudos.users.controller;

import br.com.estudos.users.mapper.ControllerMapperResponse;
import br.com.estudos.users.model.UserControllerRequest;
import br.com.estudos.users.model.UserControllerResponse;
import br.com.estudos.users.model.UserServiceRequest;
import br.com.estudos.users.model.UserServiceResponse;
import br.com.estudos.users.service.UserServiceFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.estudos.users.mapper.ControllerMapperRequest.toUserControllerRequest;
import static br.com.estudos.users.mapper.ControllerMapperRequestWithId.toUserControllerRequestWithId;
import static br.com.estudos.users.mapper.ControllerMapperResponse.toUserControllerResponse;

@AllArgsConstructor
@Component
//todo diferença component service
public class UserControllerFacade {

    private final UserServiceFacade serviceFacade;

    public List<UserControllerResponse> findAll() {
        return serviceFacade.findAll().stream()
                .map(ControllerMapperResponse::toUserControllerResponse)
                .collect(Collectors.toList());
    }

    public UserControllerResponse findById(String id) {
        UserServiceResponse userId = serviceFacade.findById(id);
        return toUserControllerResponse(userId);
    }

    //todo criar testes facade, controller, service
    //todo criar outro toUserControllerRequest
    public UserControllerResponse save(UserControllerRequest userControllerRequest) {
        UserServiceRequest userServiceRequest = toUserControllerRequest(userControllerRequest);
        UserServiceResponse userSave = serviceFacade.save(userServiceRequest);
        return toUserControllerResponse(userSave);
    }

    public UserControllerResponse update(String id, UserControllerRequest userControllerRequest) {
        UserServiceRequest userServiceRequest = toUserControllerRequestWithId(userControllerRequest, id);
        UserServiceResponse userUpdate = serviceFacade.update(id, userServiceRequest);
        return toUserControllerResponse(userUpdate);
    }

    public void delete(String id) {
        serviceFacade.deleteById(id);
    }
}