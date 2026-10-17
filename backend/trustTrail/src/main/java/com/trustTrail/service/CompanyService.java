package com.trustTrail.service;

import com.trustTrail.repository.CompanyRepository;
import com.trustTrail.requestDto.CompanyCreationRequestDto;
import com.trustTrail.responseDto.CompanyCreationResponseDto;
import org.springframework.stereotype.Service;
import com.falkordb.Record;

import com.falkordb.ResultSet;
import java.util.UUID;

@Service
public class CompanyService {

    CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyCreationResponseDto create(CompanyCreationRequestDto requestDto){
        String id = UUID.randomUUID().toString();
        System.out.println("service called");
        String graphName = "company_" + id.replace("-", "");
        ResultSet resultSet = companyRepository.createCompany(
                graphName,
                id,
                requestDto.getName(),
                requestDto.getTitle()
        );
        Record record = resultSet.iterator().next();

        CompanyCreationResponseDto response =
                new CompanyCreationResponseDto();

        response.setId((String) record.getValue("id"));
        response.setName((String) record.getValue("name"));
        response.setTitle((String) record.getValue("title"));

        return response;
    }
}
