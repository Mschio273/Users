package br.com.estudos.users.swagger.annotations;

import br.com.estudos.users.exception.StandardError;
import br.com.estudos.users.model.UserControllerResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import static br.com.estudos.users.swagger.annotations.ConstantsSwagger.DELETE_USER_SUMARY;
import static br.com.estudos.users.swagger.annotations.ConstantsSwagger.GET_ALL_USERS_DESCRIPTION;

@ApiResponses({
        @ApiResponse(code = 204, message = "O recurso não existe", response = UserControllerResponse[].class),
        @ApiResponse(code = 400, message = "Não foi possivel realizar a chamada", response = StandardError.class),
        @ApiResponse(code = 500, message = "Erro server-side", response = StandardError.class),
        @ApiResponse(code = 404, message = "Recurso não encontrado", response = StandardError.class)
})
@ApiOperation(value = DELETE_USER_SUMARY, notes = GET_ALL_USERS_DESCRIPTION)
public @interface DeleteCode {
}
