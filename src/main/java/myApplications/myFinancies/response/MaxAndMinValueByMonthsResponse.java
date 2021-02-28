package myApplications.myFinancies.response;

import myApplications.myFinancies.dao.Expense;
import myApplications.myFinancies.dao.Month;

public class MaxAndMinValueByMonthsResponse {

    private Month month;
    private Expense expense;
    private double maxValue;
    private double minValue;

    public MaxAndMinValueByMonthsResponse(Month month, double maxValue, double minValue) {
        this.month = month;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }
}
