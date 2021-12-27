package mk.ukim.finki.dians.ehotels.repository;

import mk.ukim.finki.dians.ehotels.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

Category findCategoryByName(String name);
Category findCategoryByNameEN(String name);
Category findCategoryById(Long id);
Category findCategoryByNameContains(String name);


}
