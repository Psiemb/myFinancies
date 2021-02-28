package myApplications.myFinancies.mapper;

import myApplications.myFinancies.controller.QuantityOfExensesGroupingByMonthWrapperResponse;
import myApplications.myFinancies.dao.Expense;
import myApplications.myFinancies.dao.Month;
import myApplications.myFinancies.response.QuantityOfExensesGroupingByMonthResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ExpenseWrapperResponseMapper {

    public QuantityOfExensesGroupingByMonthWrapperResponse mapToResponse(List<Expense> expenses) {
        if (Objects.isNull(expenses)) {
            return null;
        }

        Map<Month, Long> maps = expenses.stream()
                .filter(e -> Objects.nonNull(e.getMonth()))

                .filter(expense -> expense.getValue() > 0)
                //Todo jak zrobić aby sie zabezpieczyć przed ujamną wartoscią przy typie Expenses i doatnia przy Inflow
                .collect(Collectors.groupingBy(Expense::getMonth, Collectors.counting()));

        List<QuantityOfExensesGroupingByMonthResponse> collect = maps.entrySet().stream()
                .map(e -> new QuantityOfExensesGroupingByMonthResponse(e.getKey(), e.getValue()))
                .collect(Collectors.toList());

        return new QuantityOfExensesGroupingByMonthWrapperResponse(collect);
    }
}
