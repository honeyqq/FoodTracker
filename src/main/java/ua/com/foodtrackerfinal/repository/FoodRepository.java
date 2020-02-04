package ua.com.foodtrackerfinal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.foodtrackerfinal.entity.Food;

import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    Page<Food> findAll(Pageable pageable);

    Optional<Food> findById(Long id);
}
