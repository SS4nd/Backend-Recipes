package dat3.recipe.service;

import dat3.recipe.dto.CategoryDto;
import dat3.recipe.entity.Category;
import dat3.recipe.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<String> getAllCategories() {
    List<Category> categories =  categoryRepository.findAll();
    return categories.stream().map(Category::getName).toList();
  }

  @Transactional
  public CategoryDto addCategory(CategoryDto request) {
    String categoryName = request.getName();
    System.out.println(categoryName);
    if (categoryRepository.findByName(categoryName).isPresent()) {
      throw new RuntimeException("Category already exists");
    }

    Category newCategory = new Category(categoryName);
    categoryRepository.save(newCategory);
    return new CategoryDto(newCategory, true);
  }

}
