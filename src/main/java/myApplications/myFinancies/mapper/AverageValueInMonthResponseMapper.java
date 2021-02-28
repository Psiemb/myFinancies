package myApplications.myFinancies.mapper;

import myApplications.myFinancies.dao.Expense;
import myApplications.myFinancies.dao.ExpenseDataBase;
import myApplications.myFinancies.dao.Month;
import myApplications.myFinancies.response.AverageValueInMonthResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

@Component
public class AverageValueInMonthResponseMapper {

    public AverageValueInMonthResponse mapToResponse(ExpenseDataBase expenseDataBase) {
        List<Expense> expenses = expenseDataBase.getExpenses();

        Stream<Double> doubleStream = expenses.stream()
                .map(Expense::getValue);

        DoubleStream doubleStream1 = expenses.stream()
                .mapToDouble(Expense::getValue);

        Double reduce = expenses.stream()
                .filter(e -> Month.JAN.equals(e.getMonth()))
                .filter(e -> e.getValue() > 0)
//                .mapToDouble(Expense::getValue)
                .mapToDouble(Expense::getValue)
                .reduce(0.0, Double::sum);
        //ToDO czy istnieje inny sposób na zrobienie średniej

        long count = expenses.stream()
                .filter(e -> Month.JAN.equals(e.getMonth()))
                .count();
        if (count == 0) {
            return null;
        }
        double average = reduce / count;

        return new AverageValueInMonthResponse(Month.JAN, average);
    }
}
