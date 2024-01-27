package org.saqsy.calculator;


import org.saqsy.components.Bill;
import org.saqsy.components.Item;
import org.saqsy.components.Member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Logic {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Add Bill Name");
        String billName = input.readLine();
        System.out.println("Add Items below");
        List<Item> itemList = new ArrayList<>();
        while (true) {
            System.out.println("Enter Item name : ");
            String itemName = input.readLine();
            if (itemName.equals("q")) {
                break;
            }
            System.out.println("Enter Item Cost : ");
            double itemCost = Double.parseDouble(input.readLine());
            itemList.add(new Item(itemName, itemCost));
            System.out.println("Do you want to add one more item?");
        }
        System.out.println("Add Members below");
        List<Member> memberList = new ArrayList<>();
        while (true) {
            System.out.println("Enter Member name : ");
            String memberName = input.readLine();
            if (memberName.equals("q")) {
                break;
            }
            memberList.add(new Member(memberName));
            System.out.println("Do you want to add one more members?");
        }

        System.out.println("Add Members to Items contribution");
        for (Item item : itemList) {
            while (true) {
                System.out.println("Add members to this item : " + item.getName());
                for (Member member : memberList) {
                    System.out.println(member.getName() + "\n");
                }
                String memberName = input.readLine();
                if (memberName.equals("q")) {
                    break;
                }
                Member memberObject = memberList.stream().filter(member -> member.getName().equals(memberName)).findFirst().orElseGet(null);
                if (memberObject != null) {
                    System.out.println("You chose " + memberObject.getName() + " to contribute to " + item.getName());
                    item.addMember(memberObject);
                } else {
                    System.out.println("Could not find the member name, Please give exact name as displayed");
                }
                System.out.println("Do you want to continue to add members to this item? : " + item.getName());
            }
        }
        ItemConsumptionInformation info =
                new ItemConsumptionInformation(itemList, memberList);
        info.calculateExpenses();
        Bill bill = new Bill(billName, itemList);
        System.out.println("Here is the split result");
        System.out.println(bill.printBillTotal());
        for (Member member : memberList) {
            System.out.println(member.printExpense());
        }
    }

}
