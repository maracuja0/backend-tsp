package com.project.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Position")
public class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @NotBlank(message = "{name is invalid}")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "{description is invalid}")
    @Column(name = "description")
    private String description;

    //TODO: Разобраться с этим полем, надо оно или нет
    @Column(name = "type")
    private Boolean type;

    @Column(name = "link")
    private String link;

    @NotNull(message = "{creator_id in invalid}")
    @JoinColumn(name = "creator_id")
    @ManyToOne
    private CreatorEntity creatorId;

    @Column(name = "date")
    @NotNull(message = "{date is invalid}")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ManyToMany(fetch = FetchType.EAGER,
                cascade = {
                        CascadeType.PERSIST,
                        CascadeType.MERGE
                }
    )
    @JoinTable(
            name = "Position_Category",
            joinColumns = @JoinColumn(name = "position_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
//    private Set<CategoryEntity> categories = new HashSet<>();
    private Set<CategoryEntity> categories;

    public void addCategory(CategoryEntity category){
        this.categories.add(category);
        category.getPositions().add(this);
    }

    public void removeCategory(Long categoryId){
        CategoryEntity category = this.categories.stream().filter(t -> Objects.equals(t.getId(), categoryId)).findFirst().orElse(null);
        if (category != null) {
            this.categories.remove(category);
            category.getPositions().remove(this);
        }
    }

//    public Long getCategoryId() {
//        return this.categories.;
//    }
}
