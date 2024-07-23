package uz.mamatsalay.incomemanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class IncomeManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IncomeManagementServiceApplication.class, args);
    }

}
