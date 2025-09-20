package com.emrecan.services.budget.mapper;

import com.emrecan.services.budget.model.Category;
import com.emrecan.services.budget.model.CategoryDto;
import com.emrecan.services.budget.model.CreateCategoryReq;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
  CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

  Category mapDtoToCategory(CategoryDto categoryDto);

  List<Category> mapDtosToCategories(List<CategoryDto> categoryDtos);

  CategoryDto mapCategoryToDto(Category category);

  List<CategoryDto> mapCategoriesToDtos(List<Category> category);

  Category mapSaveRequestToCategory(String userId, CreateCategoryReq createCategoryReq);
}
