package uz.mamatsalay.incomemanagementservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.mamatsalay.incomemanagementservice.model.Income;
import uz.mamatsalay.incomemanagementservice.repository.IncomeRepository;

import java.time.LocalDateTime;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;


    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Transactional
    public Income createIncome(Income input) {
        Income income = new Income();
        income.setAmount(input.getAmount());
        income.setDate(LocalDateTime.now());
        income.setDescription(input.getDescription());

        return incomeRepository.save(income);
    }
}
