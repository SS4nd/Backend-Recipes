package dat3.recipe.api;

import dat3.recipe.dto.CategoryDto;
import dat3.recipe.dto.RecipeDto;
import dat3.recipe.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

  CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  public List<String> getAllCategories() {
    return categoryService.getAllCategories();
  }

  @PostMapping
  public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto request) {
    CategoryDto addedCategory = categoryService.addCategory(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(addedCategory);
  }

}

