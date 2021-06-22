package com.tw.academy.basic.$7_long_method;

import java.util.List;

public class Order {
    private String customerName;
    private String address;
    private List<LineItem> lineItems;

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

    public double calculateTotalSalesTax() {
        double totalSalesTax = 0d;
        for (LineItem lineItem : lineItems) {
            totalSalesTax += lineItem.calculateTaxAmount();
        }
        return totalSalesTax;
    }

    public String getCustomerInfo() {
        return customerName + address;
    }

    public String getOrderItemsInfo() {
        String orderItemsInfo = "";
        for (LineItem lineItem : lineItems) {
            orderItemsInfo += lineItem.toString();
        }
        return orderItemsInfo;
    }

    public String getCustomerName() {
        return customerName;
    }
}
