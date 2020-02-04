package ua.com.foodtrackerfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.foodtrackerfinal.entity.food_per_day.FoodPerDay;

import java.util.List;
import java.util.Optional;

public interface FoodPerDayRepository extends JpaRepository<FoodPerDay, Long> {
    List<FoodPerDay> findFoodPerDayByUser(FoodPerDay foodPerDay);

    Optional<FoodPerDay> findFoodPerDayById(Long id);
}
