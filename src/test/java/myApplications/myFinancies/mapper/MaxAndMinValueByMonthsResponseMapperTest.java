package myApplications.myFinancies.mapper;

import myApplications.myFinancies.dao.*;
import myApplications.myFinancies.response.MaxAndMinValueByMonthsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MaxAndMinValueByMonthsResponseMapperTest {

    private MaxAndMinValueByMonthsResponseMapper maxAndMinValueByMonthsResponseMapper;

    @BeforeEach
    void seUp() {
        this.maxAndMinValueByMonthsResponseMapper = new MaxAndMinValueByMonthsResponseMapper();
    }

    @Test
    public void checkIfTheSameObjects() {
        //given
        List<Expense> expenses = Arrays.asList(new Expense(LocalDate.now(), "rrrr", 234, Type.EXPENSES, Category.FOOD, Month.JAN),
                new Expense(LocalDate.now(), "rrrr", 55, Type.EXPENSES, Category.FOOD, Month.JAN));
        ExpenseDataBase expenseDataBase = new ExpenseDataBase();
        expenseDataBase.setExpenses(expenses);

        //when
        MaxAndMinValueByMonthsResponse result = maxAndMinValueByMonthsResponseMapper.maptoResponse(expenseDataBase);
        //then
//        assertEquals();
        //Todo jak porównać oczekiwany obiekt ze zwracamy
        assertEquals(234, result.getMaxValue());
    }

    @Test
    public void checkIfExpenseDataBaseIsNull() {
        //given
        ExpenseDataBase expenseDataBase = new ExpenseDataBase();
        expenseDataBase.setExpenses(null);

        //when
        MaxAndMinValueByMonthsResponse result = maxAndMinValueByMonthsResponseMapper.maptoResponse(expenseDataBase);
        //then

        assertNull(result);
    }

    @Test
    public void checkIfTheValueIsZeroMinValueShouldBeZero() {
        //given
        List<Expense> expenses = Arrays.asList(new Expense(LocalDate.now(), "rrrr", 0, Type.EXPENSES, Category.FOOD, Month.JAN),
                new Expense(LocalDate.now(), "rrrr", 0, Type.EXPENSES, Category.FOOD, Month.JAN));
        ExpenseDataBase expenseDataBase = new ExpenseDataBase();
        expenseDataBase.setExpenses(expenses);

        //when
        MaxAndMinValueByMonthsResponse result = maxAndMinValueByMonthsResponseMapper.maptoResponse(expenseDataBase);
        //then

        assertEquals(0, result.getMinValue());
    }

    @Test
    public void checkIfTheMinValueIsMinus() {
        //given
        List<Expense> expenses = Arrays.asList(new Expense(LocalDate.now(), "rrrr", -111, Type.EXPENSES, Category.FOOD, Month.JAN),
                new Expense(LocalDate.now(), "rrrr", -88, Type.EXPENSES, Category.FOOD, Month.JAN));
        ExpenseDataBase expenseDataBase = new ExpenseDataBase();
        expenseDataBase.setExpenses(expenses);

        //when
        MaxAndMinValueByMonthsResponse result = maxAndMinValueByMonthsResponseMapper.maptoResponse(expenseDataBase);
        //then

        assertEquals(0, result.getMinValue());
    }

    @Test
    public void checkIfTheMaxValueIsMinus() {
        //given
        List<Expense> expenses = Arrays.asList(new Expense(LocalDate.now(), "rrrr", -111, Type.EXPENSES, Category.FOOD, Month.JAN),
                new Expense(LocalDate.now(), "rrrr", -88, Type.EXPENSES, Category.FOOD, Month.JAN));
        ExpenseDataBase expenseDataBase = new ExpenseDataBase();
        expenseDataBase.setExpenses(expenses);

        //when
        MaxAndMinValueByMonthsResponse result = maxAndMinValueByMonthsResponseMapper.maptoResponse(expenseDataBase);
        //then

        assertEquals(0, result.getMaxValue());
    }
}