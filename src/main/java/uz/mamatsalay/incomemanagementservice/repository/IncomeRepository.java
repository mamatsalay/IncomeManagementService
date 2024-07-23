package uz.mamatsalay.incomemanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.mamatsalay.incomemanagementservice.model.Income;

import java.time.LocalDateTime;
import java.util.Optional;

public interface IncomeRepository extends JpaRepository<Income, Long> {

    Optional<Income> findByUserIdAndDateBetween(Long userId, LocalDateTime start, LocalDateTime end);

}