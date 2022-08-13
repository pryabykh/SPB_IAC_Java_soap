package com.pryabykh.webservice.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@Data
public class SolutionDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String error;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String formula;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected Integer d;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected Double x1;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected Double x2;
}
