package com.hcl.position.positionservice.repository;

import com.hcl.position.positionservice.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositoinRepository extends JpaRepository<Position, Long> {
}
