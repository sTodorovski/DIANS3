package mk.ukim.finki.dians.ehotels.service.impl;

import mk.ukim.finki.dians.ehotels.model.Category;

import mk.ukim.finki.dians.ehotels.repository.CategoryRepository;
import mk.ukim.finki.dians.ehotels.service.CategoryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }



    @Override
    public Category findCategoryByNameMK(String name) {
        return categoryRepository.findCategoryByName(name);
    }




    @Override
    public Category findCategoryByNameEN(String name) {

        return categoryRepository.findCategoryByNameEN(name.toUpperCase());
    }

    @Override
    public Category findCategoryByName(String language, String name) {
        if(language.equals("MK")){
            return this.findCategoryByNameMK(name);
        }
        else{
            return this.findCategoryByNameEN(name);
        }
    }


}
