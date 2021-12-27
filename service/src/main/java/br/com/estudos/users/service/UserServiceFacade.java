package br.com.estudos.users.service;

import br.com.estudos.users.integration.CepIntegration;
import br.com.estudos.users.model.UserServiceRequest;
import br.com.estudos.users.model.UserServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.estudos.users.mapper.MapperToUserWithAdress.mapAddress;

@AllArgsConstructor
@Service
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
        return userService.update(id, mapAddress(user, cepIntegration.findByCep(user.getCep())));
    }

    public void deleteById(String id) {
        userService.deleteById(id);
    }
}