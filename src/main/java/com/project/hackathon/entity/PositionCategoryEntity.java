package com.project.hackathon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Position_Category")
public class PositionCategoryEntity {
//    @EmbeddedId
//    private PositionCategoryId id;

//    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    @Id
    @JoinColumn
    @ManyToOne
    private CategoryEntity category;

//    @JoinColumn(name = "position_id", referencedColumnName = "id", insertable = false, updatable = false)
    @Id
    @JoinColumn
    @ManyToOne
    private PositionEntity position;

}
