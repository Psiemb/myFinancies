package myApplications.myFinancies.response;

import myApplications.myFinancies.dao.Month;

import java.util.List;

public class QuantityOfExensesGroupingByMonthResponse {

    private Month month;
    private long iloscWydatków;
    private int wiek = 32;

    public QuantityOfExensesGroupingByMonthResponse() {
    }

    public QuantityOfExensesGroupingByMonthResponse(Month month, long iloscWydatków) {
        this.month = month;
        this.iloscWydatków = iloscWydatków;
    }

    public QuantityOfExensesGroupingByMonthResponse(List<QuantityOfExensesGroupingByMonthResponse> collect) {

    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public long getIloscWydatków() {
        return iloscWydatków;
    }

    public void setIloscWydatków(long iloscWydatków) {
        this.iloscWydatków = iloscWydatków;
    }
}
