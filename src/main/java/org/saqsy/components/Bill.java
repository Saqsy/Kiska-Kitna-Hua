package org.saqsy.components;

import java.util.ArrayList;
import java.util.List;

public class Bill implements ICostTransform {
    private String billName;
    private List<Item> itemList;
    private double billTotal;

    public Bill(String billName, List<Item> itemList) {
        this.billName = billName;
        this.itemList = itemList;
        this.billTotal = setAmountToTwoDecimal(itemList.stream().mapToDouble(item -> item.getCost()).sum());
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public double getBillTotal() {
        return billTotal;
    }

    public String printBillTotal() {
        return "Total bill for " + billName + " is " + billTotal;
    }


}
