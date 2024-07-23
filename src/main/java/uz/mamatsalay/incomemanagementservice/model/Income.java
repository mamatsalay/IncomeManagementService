package uz.mamatsalay.incomemanagementservice.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double amount;

    @Column
    private String description;

    @Column
    private LocalDateTime date;

    @ManyToOne
    private User user;

}
