package com.hcl.position.positionservice.controller;
import com.hcl.position.positionservice.dto.PositionRequest;
import com.hcl.position.positionservice.dto.TradeRequest;
import com.hcl.position.positionservice.service.PositionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/position")
@RequiredArgsConstructor
@Slf4j
public class PositionController {

    private final PositionService positionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPosition(@RequestBody PositionRequest positionRequest) {
        log.info("Add Position");
        positionService.addPosition(positionRequest);
    }


    @PostMapping("/trade")
    @ResponseStatus(HttpStatus.CREATED)
    public void trade(@RequestBody TradeRequest tradeRequest) {
        log.info("Trade");
        positionService.trade(tradeRequest);
    }
}
