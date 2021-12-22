package br.com.estudos.users.controller;

import br.com.estudos.users.model.UserControllerRequest;
import br.com.estudos.users.model.UserControllerResponse;
import br.com.estudos.users.swagger.annotations.*;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/user")
@Api(value = "API REST de cadastro de usuário")
//todo crossorigin
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserController {

    private final UserControllerFacade controllerFacade;

    @GetMapping
    @ResponseStatus(OK)
    @UserGetAllCode
    public List<UserControllerResponse> findAll() {
        return controllerFacade.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    @UserGetByIdCode
    public UserControllerResponse findById(@PathVariable String id) {
        return controllerFacade.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
   @SaveCode
    public UserControllerResponse save(@RequestBody @Valid UserControllerRequest user) {
        return controllerFacade.save(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    @UpdateCode
    public UserControllerResponse update(@PathVariable String id, @RequestBody @Valid UserControllerRequest user) {
        return controllerFacade.update(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    @DeleteCode
    public void delete(@PathVariable String id) {
        controllerFacade.delete(id);
    }

}