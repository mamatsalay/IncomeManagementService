package uz.mamatsalay.incomemanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.mamatsalay.incomemanagementservice.model.Income;


public interface IncomeRepository extends JpaRepository<Income, Long> {

}