package com.tw.academy.basic.$7_long_method;

import java.util.List;

public class Order {
    String customerName;
    String address;
    List<LineItem> lineItems;

    public Order(String customerName, String address, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.address = address;
        this.lineItems = lineItems;
    }

    public double calculateTotalAmount() {
        double totalAmount = 0d;
        for (LineItem lineItem : lineItems) {
            totalAmount += lineItem.totalAmount() + lineItem.calculateTaxAmount();
        }
        return totalAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }
}
