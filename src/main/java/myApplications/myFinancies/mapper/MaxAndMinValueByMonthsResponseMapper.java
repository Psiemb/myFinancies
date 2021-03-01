package myApplications.myFinancies.mapper;

import myApplications.myFinancies.dao.Expense;
import myApplications.myFinancies.dao.ExpenseDataBase;
import myApplications.myFinancies.dao.Month;
import myApplications.myFinancies.response.MaxAndMinValueByMonthsResponse;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Component
public class MaxAndMinValueByMonthsResponseMapper {

    public MaxAndMinValueByMonthsResponse maptoResponse(ExpenseDataBase expenseDataBase){
        List<Expense> expenses = expenseDataBase.getExpenses();
        if(Objects.isNull(expenses)){
            return null;
        }
        Double maxValue = expenses.stream() //strimuje listę obiektów z kilkoma polami
                .filter(e -> Objects.nonNull(e.getMonth()))
                .filter(e -> Month.JAN.equals(e.getMonth()))    // filtruję wszyskie obiekty ze stycznia
                .filter(e -> e.getValue() > 0)                 // filtruję wieksze od zera
                .max(Comparator.comparing(Expense::getValue))   //poszukuję obiektu z maksymalnym polem
                .map(Expense::getValue)                         //mapuje znaleziony obiekt ma wartość - czyli z tego obiektu wyciagam wartośc
                .orElse(0.0);                              // zabezpieczam się przed 0.0 -dzieki temu nie mam Optionala

        Double minValue = expenses.stream()
                .filter(e -> Month.JAN.equals(e.getMonth()))
                .filter(e -> e.getValue() > 0)
                .map(Expense::getValue)
                .min(Double::compareTo)
                .orElse(0.0);

        return new MaxAndMinValueByMonthsResponse(Month.JAN, maxValue, minValue);
    }

}
