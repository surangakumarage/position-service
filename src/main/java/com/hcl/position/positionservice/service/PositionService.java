package com.hcl.position.positionservice.service;

import com.hcl.position.positionservice.dto.PositionRequest;
import com.hcl.position.positionservice.dto.TradeRequest;
import com.hcl.position.positionservice.model.Position;
import com.hcl.position.positionservice.repository.PositoinRepository;
import com.hcl.position.positionservice.util.TRADE_TYPE;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PositionService {


    private final PositoinRepository positoinRepository;


    public void addPosition(PositionRequest positionRequest) {
        Position position = Position.builder().instruments_id(positionRequest.getInstruments_id())
                .portfolio_id(positionRequest.getPortfolio_id())
                .position_Name(positionRequest.getPosition_Name())
                .units(positionRequest.getUnits()).build();

        positoinRepository.save(position);
    }

    public void trade(TradeRequest tradeRequest) {


        Position position = positoinRepository.getById(tradeRequest.getPosition_id());
        if (null == position) {
            log.info("invalid position");
            return;
        }
        if ("BUY".equals(tradeRequest.getTradeType()))
        {
            position.setUnits(position.getUnits()+ tradeRequest.getUnits());
        } else if ("SELL".equals(tradeRequest.getTradeType()) && position.getUnits() >= tradeRequest.getUnits())
        {
            position.setUnits(position.getUnits()-  tradeRequest.getUnits());

        } else {
            log.info("invalid Trade type - {}", tradeRequest.getTradeType());
            return;

        }

        positoinRepository.save(position);
    }
}
