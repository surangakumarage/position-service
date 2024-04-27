package com.hcl.position.positionservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_position")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Position {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long position_id;
        private Long instruments_id;
        private Long portfolio_id;
        private String position_Name;
        private int units;



}
