package dat3.recipe.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.recipe.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {
    private Integer id;
    private String name;
    private LocalDateTime created;
    private LocalDateTime edited;

    public String getName() {
        return name;
    }

    public CategoryDto(Category category, boolean includeAll) {
        this.id = category.getId();
        this.name = category.getName();
        System.out.println("Category Name: " + this.name);  // Add this line for printing
        if (includeAll) {
            this.created = category.getCreated();
            this.edited = category.getEdited();
        }
    }
}
