package myApplications.myFinancies.dao;

import myApplications.myFinancies.controller.OfferResponse;

public class ExpenceMain {

    public static void main(String[] args) {

        Expense expense = new Expense();
        expense.setName("AAAAAA");
        Expense aaaa = expense;
        Expense expense2 = new Expense();
        expense2.setName("AAAAAA");

        OfferResponse offerResponse = new OfferResponse();

        boolean result = expense.equals(expense2);

        System.out.println(result);

        System.out.println(expense.hashCode());
        System.out.println(expense.hashCode());
        System.out.println(expense.hashCode());
        System.out.println(expense.hashCode());
        System.out.println(expense.hashCode());
        System.out.println(expense.hashCode());
        System.out.println(expense.hashCode());
        System.out.println(expense.hashCode());
        System.out.println(expense.hashCode());
        System.out.println(expense.hashCode());
        System.out.println(expense.hashCode());


    }
}
