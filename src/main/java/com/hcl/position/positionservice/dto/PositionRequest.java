package com.hcl.position.positionservice.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PositionRequest {

    private Long instruments_id;
    private Long portfolio_id;
    private String position_Name;
    private int units;



}
