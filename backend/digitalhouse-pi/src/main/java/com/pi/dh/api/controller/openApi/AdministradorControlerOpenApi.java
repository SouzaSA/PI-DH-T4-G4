package com.pi.dh.api.controller.openApi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.pi.dh.dto.AdministradorDTO;
import com.pi.dh.exceptions.config.Problem;
import com.pi.dh.request.AdministradorRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Controller de Administrador")
public interface AdministradorControlerOpenApi {
	
	@ApiOperation("Cadastrar um Administrador")
	@ApiResponses({ @ApiResponse(code = 201, message = "Administrador cadastrado", response = AdministradorDTO.class) })	
	ResponseEntity<?> salvar(
			@ApiParam(name = "corpo", value = "Representação de um novo administrador", required = true) 
			@Valid AdministradorRequest administradorRequest);
	
	@ApiOperation(value = "Buscar todos os administrador", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, message = "Buscar todos os administradores", response = AdministradorDTO.class) })
	List<AdministradorDTO> listar();
	
	@ApiOperation(value = "Buscar administrador pelo ID", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, message = "Buscar administrador pelo ID", response = AdministradorDTO.class),
			@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class) })
	@ApiImplicitParam(name = "id", value = "ID a ser buscado", required = true, dataType = "int", paramType = "path", example = "1")
	AdministradorDTO buscarPorId(Long id);
	
	@ApiOperation(value = "Excluir administrador pelo ID", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 204, message = "Cliente excluído com sucesso", response = AdministradorDTO.class),
			@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class) })
	@ApiImplicitParam(name = "id", value = "Id a ser excluído", required = true, dataType = "int", paramType = "path", example = "1")
	void excluir(Long id);

}
