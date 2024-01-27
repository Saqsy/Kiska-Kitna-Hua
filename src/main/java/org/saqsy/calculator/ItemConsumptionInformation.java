package org.saqsy.calculator;

import org.saqsy.components.Item;
import org.saqsy.components.Member;

import java.util.List;
import java.util.stream.Collectors;


public class ItemConsumptionInformation {
    private List<Item> items;
    private List<Member> members;

    public ItemConsumptionInformation(List<Item> items, List<Member> members) {
        this.items = items;
        this.members = members;
    }

    public void calculateExpenses() {
        for (Member member: members) {
            List<Item> itemsConsumedByMember = items.stream().filter(item -> item.getMemberList().contains(member)).collect(Collectors.toList());
            for (Item item : itemsConsumedByMember){
                member.addExpense(item.getSplitCost());
            }
        }
    }
}
