package co.uk.skills.controller;

import co.uk.skills.dto.Response;
import co.uk.skills.entity.Skill;
import co.uk.skills.service.SkillService;
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
@RequestMapping(value = "/api/skill")
@OpenAPIDefinition(info = @Info(title = "Skill API",version = "1.0",description ="Skill API has a read and write permissions" ))
public class SkillsController {
    private SkillService skillService;

    @Autowired
    public SkillsController(SkillService skillService) {
        this.skillService = skillService;
    }

    @Operation(description = "save new skill",parameters = {@Parameter(in = ParameterIn.HEADER,name = "correlation_id",required = true)})
    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Skill>> createsSkill(@RequestBody Skill skill,@RequestHeader Map<String,String> header){
        MDC.put("correlationId",header.get("correlation_id"));
        return ResponseEntity.ok(CreateResponse.createResponse(skillService.addSkill(skill)));
    }

    @Operation(description = "fetch all skills by customer id",parameters = {@Parameter(in = ParameterIn.HEADER,name = "correlation_id",required = true)})
    @GetMapping(value = "byCustomerId/retrieveAll/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<List<Skill>>> getAllSkillsByCustomerId(@RequestParam("customerId") long customerId,@RequestHeader Map<String,String> header){
        MDC.put("correlationId",header.get("correlation_id"));
        return ResponseEntity.ok(CreateResponse.createResponse(skillService.getAllSkillsByCustomerId(customerId)));
    }
    @Operation(description = "fetch all skills ",parameters = {@Parameter(in = ParameterIn.HEADER,name = "correlation_id",required = true)})
    @GetMapping(value = "/retrieveAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<List<Skill>>> getAllSkill(@RequestHeader Map<String,String> header){
        MDC.put("correlationId",header.get("correlation_id"));
        return ResponseEntity.ok(CreateResponse.createResponse(skillService.getAll()));
    }

    @Operation(description = "update skill by skill id",parameters = {@Parameter(in = ParameterIn.HEADER,name = "correlation_id",required = true)})
    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Skill>> updateSkill(@RequestBody Skill skill,@RequestHeader Map<String,String> header){
        MDC.put("correlationId",header.get("correlation_id"));
        return ResponseEntity.ok(CreateResponse.createResponse(skillService.updateSkill(skill)));
    }

    @Operation(description = "delete skill by skill id",parameters = {@Parameter(in = ParameterIn.HEADER,name = "correlation_id",required = true)})
    @DeleteMapping(value = "/delete/bySkillId/{skillId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<String>> deleteSkill(@RequestParam("skillId") long skillId,@RequestHeader Map<String,String> header){
        MDC.put("correlationId",header.get("correlation_id"));
        return ResponseEntity.ok(CreateResponse.createResponse(skillService.delete(skillId)));
    }
    @Operation(description = "delete skills by customer id",parameters = {@Parameter(in = ParameterIn.HEADER,name = "correlation_id",required = true)})
    @DeleteMapping(value = "/delete/byCustomerId/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<String>> deleteSkillsByCustomerId(@RequestParam("customerId") long customerId,@RequestHeader Map<String,String> header){
        MDC.put("transactionId",header.get("correlation_id"));
        return ResponseEntity.ok(CreateResponse.createResponse(skillService.deleteAllSkillsByCustomerId(customerId)));
    }

}
