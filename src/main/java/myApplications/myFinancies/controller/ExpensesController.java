package myApplications.myFinancies.controller;

import myApplications.myFinancies.dao.Expense;
import myApplications.myFinancies.dao.ExpenseDataBase;
import myApplications.myFinancies.dao.Month;
import myApplications.myFinancies.dao.Type;
import myApplications.myFinancies.mapper.AverageValueInMonthResponseMapper;
import myApplications.myFinancies.mapper.ExpenseWrapperResponseMapper;
import myApplications.myFinancies.mapper.MaxAndMinValueByMonthsResponseMapper;
import myApplications.myFinancies.response.AverageValueInMonthResponse;
import myApplications.myFinancies.response.MaxAndMinValueByMonthsResponse;
import myApplications.myFinancies.response.QuantityOfExensesGroupingByMonthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class ExpensesController {

    // Deo - interfejse
    @Autowired
    private ExpenseDataBase expenseDataBase;

    @Autowired
    private ExpenseWrapperResponseMapper expenseWrapperResponseMapper;

    @Autowired
    private MaxAndMinValueByMonthsResponseMapper maxAndMinValueByMonthsResponseMapper;

    @Autowired
    private AverageValueInMonthResponseMapper averageValueInMonthResponseMapper;

    @GetMapping("/test")
    public QuantityOfExensesGroupingByMonthResponse test() {
        List<Expense> expenses1 = expenseDataBase.getExpenses();
//        Map<Month, Long> maps = expenses1.stream()
//                .collect(Collectors.groupingBy(Expense::getMonth, Collectors.counting()));
//
        long count = expenses1.stream()
                .filter(e -> Month.JAN.equals(e.getMonth()))
                .count();
        QuantityOfExensesGroupingByMonthResponse quantityOfExensesGroupingByMonthResponse = new QuantityOfExensesGroupingByMonthResponse();
        quantityOfExensesGroupingByMonthResponse.setMonth(Month.JAN);
        quantityOfExensesGroupingByMonthResponse.setIloscWydatków(count);

        return quantityOfExensesGroupingByMonthResponse;
//        return new ExpenceGroupingResponse(Month.JAN, count);
    }

    @GetMapping("/test2/{requestedId}")
    public ResponseEntity<QuantityOfExensesGroupingByMonthWrapperResponse> transactionQuantity(@PathVariable String requestedId) {
        QuantityOfExensesGroupingByMonthWrapperResponse quantityOfExensesGroupingByMonthWrapperResponse = expenseWrapperResponseMapper.mapToResponse(expenseDataBase.getExpenses());

        return ResponseEntity.ok(quantityOfExensesGroupingByMonthWrapperResponse);
    }

    @GetMapping("/maxAndMinValue")
    public ResponseEntity<MaxAndMinValueByMonthsResponse> maxAndMinValueOfExpensesInJanuary() {
        MaxAndMinValueByMonthsResponse maxAndMinValueByMonthsResponse = maxAndMinValueByMonthsResponseMapper.maptoResponse(expenseDataBase);

        return ResponseEntity.ok(maxAndMinValueByMonthsResponse);
    }

    @GetMapping("/averageValue")
    public ResponseEntity<AverageValueInMonthResponse> averageValue() {
        AverageValueInMonthResponse averageValueInMonthResponse = averageValueInMonthResponseMapper.mapToResponse(expenseDataBase);

        return ResponseEntity.ok(averageValueInMonthResponse);
    }


//        List<Expense> expenses1 = expenseDataBase.getExpenses();
//        Map<Month, Long> maps = expenses1.stream()
//                .collect(Collectors.groupingBy(Expense::getMonth, Collectors.counting()));
//
//        List<ExpenceGroupingResponse> collect = maps.entrySet().stream()
//                .map(e -> new ExpenceGroupingResponse(e.getKey(), e.getValue()))
//                .collect(Collectors.toList());

//

//        return new ExpenseWrapperResponse(collect);
//        Category category = getCategory(requestedId);
//
//        List<Expense> expenses = expenseDataBase.getExpenses();
//
//        long count = expenses.stream()
//                .filter(e -> category.equals(e.getCategory()))
//                .count();
//        System.out.println("Ilość kategori " + category + "w bazie danych wynosi: "+ count);
//
//
//    }
//    public Category getCategory(String requestedId) {
//        for (Category value : Category.values()) {
//            if (value.getId().equals((requestedId))) {
//                return value;
//            }
//        }

//        return null;

//    }


    @GetMapping("/expenses/{requestedId}")
    public List<Expense> monthlyExpenses(@PathVariable String requestedId) {
        final Month month = getMonthExpense(requestedId);
//        if (month == null) {
        if (Objects.isNull(month)) {
            return Collections.emptyList();
        }
        List<Expense> expenses = expenseDataBase.getExpenses();

        return expenses.stream()
                .filter(e -> month.equals(e.getMonth()))
                .filter(e -> Type.EXPENSES.equals(e.getType()))
                .collect(Collectors.toList());
    }

    @GetMapping("/inflow/{requestedId}")
    public List<Expense> monthlyInflow(@PathVariable String requestedId) {
        final Month month = getMonthInflow(requestedId);
        if (Objects.isNull(month)) {
            return Collections.emptyList();
        }
        List<Expense> expenses = expenseDataBase.getExpenses();
        return expenses.stream()
                .filter(e -> month.equals(e.getMonth()))
                .filter(e -> Type.INFLOW.equals(e.getType()))
                .collect(Collectors.toList());
    }

    private Month getMonthExpense(String requestedId) {
        for (Month value : Month.values()) {
            if (value.getId().equals(requestedId)) {
                return value;
            }
        }

        return null;
    }

    private Month getMonthInflow(String requestedId) {
        for (Month value : Month.values()) {
            if (value.getId().equals(requestedId)) {
                return value;
            }
        }

        return null;
    }
}
