package ua.com.foodtrackerfinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.foodtrackerfinal.entity.Food;
import ua.com.foodtrackerfinal.exception.FoodNotFoundException;
import ua.com.foodtrackerfinal.repository.FoodRepository;

@Service
public class FoodService {

    private FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Page<Food> findAll (Pageable pageable) {
        return foodRepository.findAll(pageable);
    }

    public Food findById(Long id) throws FoodNotFoundException {
        return foodRepository.findById(id).orElseThrow(FoodNotFoundException::new);
    }
}
