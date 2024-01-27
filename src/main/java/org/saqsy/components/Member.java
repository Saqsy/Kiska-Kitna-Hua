package org.saqsy.components;


public class Member implements ICostTransform {
    private String name;

    private double expense;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getExpense() {
        return expense;
    }

    public String printExpense() {
        return name + " : " + expense;
    }
    public void addExpense(double expense) {
        this.expense = setAmountToTwoDecimal(this.expense + expense);
    }
}
