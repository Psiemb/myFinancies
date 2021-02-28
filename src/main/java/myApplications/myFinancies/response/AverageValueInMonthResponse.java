package myApplications.myFinancies.response;

import myApplications.myFinancies.dao.Month;

public class AverageValueInMonthResponse {

    private Month month;
    private double average;

    public AverageValueInMonthResponse(Month month, double average) {
        this.month = month;
        this.average = average;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
