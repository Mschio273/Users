package br.com.estudos.users.swagger.annotations;

import br.com.estudos.users.exception.StandardError;
import br.com.estudos.users.model.UserControllerResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import static br.com.estudos.users.swagger.annotations.ConstantsSwagger.GET_ALL_USERS_DESCRIPTION;
import static br.com.estudos.users.swagger.annotations.ConstantsSwagger.SAVE_USER_SUMARY;

@ApiResponses({
        @ApiResponse(code = 201, message = "User cadastrado com sucesso", response = UserControllerResponse[].class),
        @ApiResponse(code = 400, message = "Não foi possivel realizar a chamada", response = StandardError.class),
        @ApiResponse(code = 500, message = "Erro server-side", response = StandardError.class),
        @ApiResponse(code = 404, message = "Recurso não encontrado", response = StandardError.class)
})
@ApiOperation(value = SAVE_USER_SUMARY, notes = GET_ALL_USERS_DESCRIPTION)
public @interface SaveCode {
}
