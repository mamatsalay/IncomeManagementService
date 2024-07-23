package uz.mamatsalay.incomemanagementservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mamatsalay.incomemanagementservice.model.Income;
import uz.mamatsalay.incomemanagementservice.service.IncomeService;

@RestController
@RequestMapping("/income")
public class    IncomeController {

    private final IncomeService incomeService;
    public IncomeController(IncomeService incomeService) {

        this.incomeService = incomeService;
    }

    @PostMapping("/create")
    public ResponseEntity<Income> create(@RequestBody Income input) {
        Income createdIncome = incomeService.createIncome(input);
        return new ResponseEntity<>(createdIncome, HttpStatus.CREATED);
    }

}
