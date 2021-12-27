package br.com.estudos.users.controller;

import br.com.estudos.users.mapper.ControllerMapperResponse;
import br.com.estudos.users.model.UserControllerRequest;
import br.com.estudos.users.model.UserControllerResponse;
import br.com.estudos.users.model.UserServiceRequest;
import br.com.estudos.users.service.UserServiceFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.estudos.users.mapper.ControllerMapperRequest.toUserControllerRequest;
import static br.com.estudos.users.mapper.ControllerMapperRequestWithId.toUserControllerRequestWithId;
import static br.com.estudos.users.mapper.ControllerMapperResponse.toUserControllerResponse;

@AllArgsConstructor
@Service
public class UserControllerFacade {

    private final UserServiceFacade serviceFacade;

    public List<UserControllerResponse> findAll() {
        return serviceFacade.findAll().stream()
                .map(ControllerMapperResponse::toUserControllerResponse)
                .collect(Collectors.toList());
    }

    public UserControllerResponse findById(String id) {
        return toUserControllerResponse(serviceFacade.findById(id));
    }

    //todo criar testes facade, controller, service
    public UserControllerResponse save(UserControllerRequest userControllerRequest) {
        UserServiceRequest userServiceRequest = toUserControllerRequest(userControllerRequest);
        return toUserControllerResponse(serviceFacade.save(userServiceRequest));
    }

    public UserControllerResponse update(String id, UserControllerRequest userControllerRequest) {
        UserServiceRequest userServiceRequest = toUserControllerRequestWithId(userControllerRequest, id);
        return toUserControllerResponse(serviceFacade.update(id, userServiceRequest));
    }

    public void delete(String id) {
        serviceFacade.deleteById(id);
    }
}