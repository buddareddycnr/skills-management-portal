package co.uk.skills.controller;

import co.uk.skills.dto.Response;
import co.uk.skills.entity.Organization;
import co.uk.skills.service.OrganizationService;
import co.uk.skills.util.CreateResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/organization")
@OpenAPIDefinition(info = @Info(title = "Organization Api",version = "1.0",description ="Organization API has a read and write permissions" ))
public class OrganizationController {
    private OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }
    @Operation(description = "save organization",parameters = {@Parameter(in = ParameterIn.HEADER,name = "correlation_id",required = true)})
    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Organization>> createOrganization(@RequestBody Organization organization,@RequestHeader Map<String,String> header){
        MDC.put("correlationId",header.get("correlation_id"));
    return ResponseEntity.ok(CreateResponse.createResponse(organizationService.saveOrUpdateOrganization(organization)));
    }
    @Operation(description = "retrieve all organization details",parameters = {@Parameter(in = ParameterIn.HEADER,name = "correlation_id",required = true)})
    @GetMapping(value = "/retrieveAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<List<Organization>>> getAllOrganization(@RequestHeader Map<String,String> header){
        MDC.put("correlationId",header.get("correlation_id"));
        return ResponseEntity.ok(CreateResponse.createResponse(organizationService.getAllOrganization()));
    }

    @Operation(description = "update organization details",parameters = {@Parameter(in = ParameterIn.HEADER,name = "correlation_id",required = true)})
    @PatchMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateOrganization(@RequestBody Organization organization,@RequestHeader Map<String,String> header){
        MDC.put("correlationId",header.get("correlation_id"));
        organizationService.saveOrUpdateOrganization(organization);
        return (ResponseEntity) ResponseEntity.noContent();
    }
    @Operation(description = "delete organization details",parameters = {@Parameter(in = ParameterIn.HEADER,name = "correlation_id",required = true)})
    @DeleteMapping(value = "/delete/{organizationId}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<String>> deleteOrganization(@PathVariable("organizationId") Long organizationId,@RequestHeader Map<String,String> header){
        MDC.put("transactionId",header.get("correlation_id"));
        return ResponseEntity.ok(CreateResponse.createResponse(organizationService.deleteOrganization(organizationId)));
    }

}
