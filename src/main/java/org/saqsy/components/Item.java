package org.saqsy.components;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Item implements ICostTransform {

    private String name;
    private double cost;
    Set<Member> memberList = new HashSet<>();

    private double splitCost;

    public Item(String itemName,double itemCost) {
        this.name = itemName;
        this.cost = setAmountToTwoDecimal(itemCost);
    }

    public double getSplitCost() {
        return splitCost;
    }


    public Set<Member> getMemberList() {
        return memberList;
    }

    public void addMember(Member member) {
        memberList.add(member);
        this.splitCost = setAmountToTwoDecimal(cost/memberList.size());
    }

    public void addMembers(List<Member> members) {
        memberList.addAll(members);
        this.splitCost = setAmountToTwoDecimal(cost/memberList.size());
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
