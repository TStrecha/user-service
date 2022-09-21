package cz.thomas.messagingapp.userservice.controller;

import cz.thomas.messagingapp.userservice.dto.BasicResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Health check controller for user service", tags = "health-check-controller")
public class HealthController {

    @GetMapping("/health-check")
    @ApiOperation("Health check")
    public BasicResponseDTO healthCheck(){
        return BasicResponseDTO.builder()
                .httpStatus(HttpStatus.OK)
                .customResponse("I am alive.")
                .build();
    }

}
