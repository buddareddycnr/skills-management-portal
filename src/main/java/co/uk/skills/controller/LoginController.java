package co.uk.skills.controller;

import co.uk.skills.dto.LoginDto;
import co.uk.skills.dto.Response;
import co.uk.skills.entity.Customer;
import co.uk.skills.service.LoginService;
import co.uk.skills.util.CreateResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/customer/")
@OpenAPIDefinition(info = @Info(title = "Login API",version = "1.0",description ="Authenticate the customer" ))
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;

    }
    @Operation(description = "authenticate user",parameters = {@Parameter(in = ParameterIn.HEADER,name = "correlation_id",required = true)})
    @PostMapping(value = "/login")
    public ResponseEntity<Response<Boolean>> login(@RequestBody LoginDto login, @RequestHeader Map<String,String> header){
        MDC.put("transactionId",header.get("correlation_id"));
        loginService.login(login.getUserName(), login.getPassword());
        return ResponseEntity.ok(CreateResponse.createResponse(Boolean.TRUE));
    }
    @PostMapping(value = "/logout")
    public Customer logout(){
        var customer = new Customer();
        return customer;
    }
}
