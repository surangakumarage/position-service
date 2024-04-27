package com.hcl.position.positionservice.service;

import com.hcl.position.positionservice.dto.PositionRequest;
import com.hcl.position.positionservice.model.Position;
import com.hcl.position.positionservice.repository.PositoinRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PositionService {


    private final PositoinRepository  positoinRepository;


    public void addPosition(PositionRequest positionRequest) {
        Position position = Position.builder().instruments_id(positionRequest.getInstruments_id())
                .portfolio_id(positionRequest.getPortfolio_id())
                .position_Name(positionRequest.getPosition_Name())
                .units(positionRequest.getUnits()).build();

        positoinRepository.save(position);
    }
}
