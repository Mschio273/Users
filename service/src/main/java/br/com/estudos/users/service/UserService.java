package br.com.estudos.users.service;

import br.com.estudos.users.entity.UserEntity;
import br.com.estudos.users.exception.NotFoundException;
import br.com.estudos.users.mapper.UserServiceMapperToResponse;
import br.com.estudos.users.model.UserServiceResponse;
import br.com.estudos.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.estudos.users.exception.ErrorConstants.ID_NAO_ENCONTRADO;
import static br.com.estudos.users.mapper.UserServiceMapperToResponse.toUserServiceResponse;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserServiceResponse> findAll() {
        return userRepository.findAll().stream()
                .map(UserServiceMapperToResponse::toUserServiceResponse)
                .collect(Collectors.toList());
    }

    public UserServiceResponse findById(String id) {
        return toUserServiceResponse(userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ID_NAO_ENCONTRADO)));
    }

    public UserServiceResponse save(UserEntity user) {
        return toUserServiceResponse(userRepository.save(user));
    }

    //todo dando save
    public UserServiceResponse update(String id, UserEntity user) {
        return toUserServiceResponse(userRepository.save(user));
    }

    public void deleteById(String id) {
        userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ID_NAO_ENCONTRADO));
        userRepository.deleteById(id);
    }
}