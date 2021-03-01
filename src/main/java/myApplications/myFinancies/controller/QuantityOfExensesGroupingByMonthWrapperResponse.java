package myApplications.myFinancies.controller;

import myApplications.myFinancies.response.QuantityOfExensesGroupingByMonthResponse;

import java.util.List;

public class QuantityOfExensesGroupingByMonthWrapperResponse {

    private List<QuantityOfExensesGroupingByMonthResponse> quantityOfExensesGroupingByMonthResponse;
    private String name = "Piotr";

    public QuantityOfExensesGroupingByMonthWrapperResponse(List<QuantityOfExensesGroupingByMonthResponse> quantityOfExensesGroupingByMonthResponse) {
        this.quantityOfExensesGroupingByMonthResponse = quantityOfExensesGroupingByMonthResponse;
    }

    public List<QuantityOfExensesGroupingByMonthResponse> getQuantityOfExensesGroupingByMonthResponse() {
        return quantityOfExensesGroupingByMonthResponse;
    }

    public void setQuantityOfExensesGroupingByMonthResponse(List<QuantityOfExensesGroupingByMonthResponse> quantityOfExensesGroupingByMonthResponse) {
        this.quantityOfExensesGroupingByMonthResponse = quantityOfExensesGroupingByMonthResponse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
