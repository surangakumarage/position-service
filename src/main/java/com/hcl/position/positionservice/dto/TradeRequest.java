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
public class TradeRequest {

    private Long position_id;
    private int units;
    private String tradeType;
    private String tradeValue;
}
