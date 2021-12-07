package br.com.estudos.users.service;

import br.com.estudos.users.integration.CepIntegration;
import br.com.estudos.users.model.UserServiceRequest;
import br.com.estudos.users.model.UserServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

import static br.com.estudos.users.mapper.MapperToUserWithAdress.mapAddress;


@AllArgsConstructor
@Component
public class UserServiceFacade {

    final UserService userService;
    final CepIntegration cepIntegration;

    public List<UserServiceResponse> findAll() {
        return userService.findAll();
    }

    public UserServiceResponse findById(String id) {
        return userService.findById(id);
    }

    public UserServiceResponse save(UserServiceRequest user) {
        return userService.save(mapAddress(user, cepIntegration.findByCep(user.getCep())));
    }

    public UserServiceResponse update(String id, UserServiceRequest user) {
        return Stream.of(userService.findById(id))
                .map(address -> mapAddress(user, cepIntegration.findByCep(user.getCep())))
                .map(address -> userService.update(user.getId(), address))
                .findAny().orElseThrow();
    }

    public void deleteById(String id) {
        userService.deleteById(id);
    }
}