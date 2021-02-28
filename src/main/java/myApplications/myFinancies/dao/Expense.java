package myApplications.myFinancies.dao;

import java.time.LocalDate;
import java.util.Objects;

public class Expense {

    private LocalDate localDate;
    private String name;
    private double value;
    private Type type;
    private Category category;
    private Month month;
    private int wiek;

    public Expense() {
    }

    public Expense(LocalDate localDate, String name, double value, Type type, Category category, Month month) {
        this.localDate = localDate;
        this.name = name;
        this.value = value;
        this.type = type;
        this.category = category;
        this.month = month;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expense)) return false;
        Expense expense = (Expense) o;
        return Double.compare(expense.value, value) == 0 &&
                wiek == expense.wiek &&
                localDate.equals(expense.localDate) &&
                name.equals(expense.name) &&
                type == expense.type &&
                category == expense.category &&
                month == expense.month;
    }

    @Override
    public int hashCode() {
        return Objects.hash(localDate, name, value, type, category, month, wiek);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "localDate=" + localDate +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", type=" + type +
                ", category=" + category +
                ", month=" + month +
                '}';
    }
}
