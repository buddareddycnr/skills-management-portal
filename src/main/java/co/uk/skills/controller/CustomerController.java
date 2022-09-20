package co.uk.skills.controller;

import co.uk.skills.dto.Response;
import co.uk.skills.entity.Customer;
import co.uk.skills.service.CustomerService;
import co.uk.skills.util.CreateResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/customer")
@OpenAPIDefinition(info = @Info(title = "Customer Api",version = "1.0",description ="Customer API has a read and write permissions" ))
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @Operation(description = "save customer details",parameters = {@Parameter(in = ParameterIn.HEADER,name = "correlation_id",required = true)})
    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Customer>> createCustomer(@RequestBody Customer request, @RequestHeader Map<String,String> header){
        MDC.put("correlationId",header.get("correlation_id"));
        return ResponseEntity.ok(CreateResponse.createResponse(customerService.saveOrUpdate(request)));
    }
    @Operation(description = "retrieve all customers details",parameters = {@Parameter(in = ParameterIn.HEADER,name = "correlation_id",required = true)})
    @GetMapping(value = "/retrieveAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<List<Customer>>> getAllCustomers(@RequestHeader Map<String,String> header){
        MDC.put("correlationId",header.get("correlation_id"));
        return ResponseEntity.ok(CreateResponse.createResponse(customerService.retrieveAll()));
    }
    @Operation(description = "update customer details",parameters = {@Parameter(in = ParameterIn.HEADER,name = "correlation_id",required = true)})
    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomer(@RequestBody Customer request,@RequestHeader Map<String,String> header){
        MDC.put("correlationId",header.get("correlation_id"));
        customerService.saveOrUpdate(request);
        return (ResponseEntity) ResponseEntity.noContent();
    }
    @Operation(description = "delete customer by customer id",parameters = {@Parameter(in = ParameterIn.HEADER,name = "correlation_id",required = true)})
    @DeleteMapping(value = "/customer/delete/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<String>> deleteCustomer(@PathVariable("customerId") long customerId,@RequestHeader Map<String,String> header){
        MDC.put("correlationId",header.get("correlation_id"));
        return ResponseEntity.ok(CreateResponse.createResponse(customerService.deleteCustomer(customerId)));
    }

}
