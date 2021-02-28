package myApplications.myFinancies.mapper;

import myApplications.myFinancies.controller.QuantityOfExensesGroupingByMonthWrapperResponse;
import myApplications.myFinancies.dao.*;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class ExpenseWrapperResponseMapperTest {

    private ExpenseWrapperResponseMapper expenseWrapperResponseMapper;

    @BeforeEach
    void setUp() {
        this.expenseWrapperResponseMapper = new ExpenseWrapperResponseMapper();
    }

    @Test
    public void checkedIfExpensesDataBaseMonthIsNull() {
        //given
//        List<Expense> expenses
        List<Expense> expenses = Arrays.asList(new Expense(LocalDate.now(), "rrrr", 234, Type.EXPENSES, Category.FOOD, null),
                new Expense(LocalDate.now(), "rrrr", 234, Type.EXPENSES, Category.FOOD, null));
//        Expense expense = new Expense(LocalDate.now(), "rrrr", 234, Type.EXPENSES,Category.FOOD, null);

        //when
        QuantityOfExensesGroupingByMonthWrapperResponse result = expenseWrapperResponseMapper.mapToResponse(expenses);

        //then
        Assertions.assertEquals(0, result.getQuantityOfExensesGroupingByMonthResponse().size());
    }
    @Test
    public void checkedIfExpensesDataBaseGroupingByMonth() {
        //given
//        List<Expense> expenses
        List<Expense> expenses = Arrays.asList(new Expense(LocalDate.now(), "rrrr", 234, Type.EXPENSES, Category.FOOD, Month.JAN),
                new Expense(LocalDate.now(), "rrrr", 234, Type.EXPENSES, Category.FOOD, Month.FEB));
//        Expense expense = new Expense(LocalDate.now(), "rrrr", 234, Type.EXPENSES,Category.FOOD, null);

        //when
        QuantityOfExensesGroupingByMonthWrapperResponse result = expenseWrapperResponseMapper.mapToResponse(expenses);

        //then
        Assertions.assertEquals(2, result.getQuantityOfExensesGroupingByMonthResponse().size());
    }
    @Test
    public void checkedIfNameIsNullOrTypeIsNull() {
        //given
//        List<Expense> expenses
        List<Expense> expenses = Arrays.asList(new Expense(null, null, 234, null, Category.FOOD, Month.JAN),
                new Expense(LocalDate.now(), "rrrr", 234, Type.EXPENSES, Category.FOOD, Month.FEB));
//        Expense expense = new Expense(LocalDate.now(), "rrrr", 234, Type.EXPENSES,Category.FOOD, null);

        //when
        QuantityOfExensesGroupingByMonthWrapperResponse result = expenseWrapperResponseMapper.mapToResponse(expenses);

        //then
        Assertions.assertEquals(2, result.getQuantityOfExensesGroupingByMonthResponse().size());
    }
    @Test
    public void checkedIfAllParametersAreNullAnfValueIsZero() {
        //given
//        List<Expense> expenses
        List<Expense> expensesArray = Arrays.asList(new Expense(null, null, 0, null, null, null),
                new Expense(LocalDate.now(), "rrrr", 234, Type.EXPENSES, Category.FOOD, Month.FEB));
        ExpenseDataBase expenseDataBase = new ExpenseDataBase();
        expenseDataBase.setExpenses(expensesArray);
//        Expense expense = new Expense(LocalDate.now(), "rrrr", 234, Type.EXPENSES,Category.FOOD, null);

        //when
        QuantityOfExensesGroupingByMonthWrapperResponse result = expenseWrapperResponseMapper.mapToResponse(expenseDataBase.getExpenses());

        //then
        Assertions.assertEquals(1, result.getQuantityOfExensesGroupingByMonthResponse().size());
    }
    @Test
    public void checkedIfAllValueIsZMinus() {
        //given
//        List<Expense> expenses
        List<Expense> expenses = Arrays.asList(new Expense(LocalDate.now(), "Aa", -110, Type.EXPENSES, Category.FOOD, Month.JAN),
                new Expense(LocalDate.now(), "rrrr", 234, Type.EXPENSES, Category.FOOD, Month.FEB));
//        Expense expense = new Expense(LocalDate.now(), "rrrr", 234, Type.EXPENSES,Category.FOOD, null);

        //when
        QuantityOfExensesGroupingByMonthWrapperResponse result = expenseWrapperResponseMapper.mapToResponse(expenses);

        //then
        Assertions.assertEquals(1, result.getQuantityOfExensesGroupingByMonthResponse().size());
    }
    @Test
    public void checkedIfExpenseDataBaseIsNull() {
        //when
        QuantityOfExensesGroupingByMonthWrapperResponse result = expenseWrapperResponseMapper.mapToResponse(null);

        //then
        assertNull(result);
    }
}