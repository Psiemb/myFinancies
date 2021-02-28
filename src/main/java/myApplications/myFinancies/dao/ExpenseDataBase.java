package myApplications.myFinancies.dao;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExpenseDataBase {
    public ExpenseDataBase() {
    }

    public ExpenseDataBase(List<Expense> expenses) {
        this.expenses = expenses;
    }

    private List<Expense> expenses = createData();

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    private List<Expense> createData() {
        List<Expense> result = new ArrayList<>();
        result.add(new Expense(LocalDate.now(), "rower", 1850, Type.EXPENSES, Category.SPORT_AND_FUN, Month.JAN));
        result.add(new Expense(LocalDate.now(), "A", 850, Type.EXPENSES, Category.SPORT_AND_FUN, Month.JAN));
        result.add(new Expense(LocalDate.now(), "B", 750, Type.EXPENSES, Category.SPORT_AND_FUN, Month.JAN));
        result.add(new Expense(LocalDate.now(), "C", 9950, Type.EXPENSES, Category.SPORT_AND_FUN, Month.JAN));
        result.add(new Expense(LocalDate.now(), "D", 18050, Type.INFLOW, Category.UNCATEGORIZED, Month.JAN));
        result.add(new Expense(LocalDate.now().minusMonths(1), "bagietka", 3, Type.EXPENSES, Category.FOOD, Month.FEB));
        return result;
    }

}
