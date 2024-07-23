package uz.mamatsalay.incomemanagementservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link uz.mamatsalay.incomemanagementservice.model.Income}
 */
@Getter
@Setter
public class IncomeDto {
    private Double amount;
    private String description;
    private LocalDateTime date;
}