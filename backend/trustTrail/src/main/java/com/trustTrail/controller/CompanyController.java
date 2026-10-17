package com.trustTrail.controller;

import com.trustTrail.requestDto.CompanyCreationRequestDto;
import com.trustTrail.responseDto.CompanyCreationResponseDto;
import com.trustTrail.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/companies")
public class CompanyController {

    CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyCreationResponseDto> createCompany(@RequestBody CompanyCreationRequestDto request){
        return ResponseEntity.ok(companyService.create(request));
    }



}
