package ua.com.foodtrackerfinal.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name_ua", nullable = false)
    private String nameUa;

    @Column(name = "name_en", nullable = false)
    private String nameEn;

    @Column(name = "portion", nullable = false)
    private float portion; //in grams

    @Column(name = "calories", nullable = false)
    private String calories;
}
