package com.project.hackathon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Position_Category")
@IdClass(PositionCategoryEntityId.class)
public class PositionCategoryEntity {
    @Id
    @NotNull(message = "{category_id in invalid}")
    @JoinColumn(name = "category_id")
    @ManyToOne
    private CategoryEntity categoryId;

    @Id
    @NotNull(message = "{position_id in invalid}")
    @JoinColumn(name = "position_id")
    @ManyToOne
    private PositionEntity positionId;

}
