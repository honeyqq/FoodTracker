package ua.com.foodtrackerfinal.entity.food_per_day;

import lombok.*;
import ua.com.foodtrackerfinal.entity.Food;
import ua.com.foodtrackerfinal.entity.user.User;

import javax.persistence.*;
import java.time.LocalDate;

//TODO передумать и переделать

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "food_per_day")
public class FoodPerDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private LocalDate localDate;

    @ManyToOne
    private Food eatenFood;

    @OneToOne
    private User user;
}

