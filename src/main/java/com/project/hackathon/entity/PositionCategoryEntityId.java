package com.project.hackathon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionCategoryEntityId implements Serializable {
    private Long categoryId;
    private Long positionId;
}
