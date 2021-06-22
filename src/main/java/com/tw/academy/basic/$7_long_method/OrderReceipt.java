package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    public static final String LINE_ITEM_SEPARATOR = "\t";
    public static final String RECEIPT_HEADER = "======Printing Orders======\n";
    public static final String RECEIPT_SALES_TAX = "Sales Tax";
    public static final String RECEIPT_TOTAL_AMOUNT = "Total Amount";
    public static final double TAX_RATE = .10;
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    //Deprecated
    public String printCustomerName() {
        return order.getCustomerName();
    }

    //todo: rename -- Tom
    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        buildHeader(output);
        buildCustomerInfo(output);
        buildItemsInfo(output);
        buildTotalSalesTax(output, order.calculateTotalSalesTax());
        buildTotalAmount(output, order.calculateTotalAmount());
        return output.toString();
    }

    private void buildItemsInfo(StringBuilder receipt) {
        receipt.append(order.getOrderItemsInfo());
    }

    private StringBuilder buildTotalAmount(StringBuilder output, double totalAmount) {
        return output.append(RECEIPT_TOTAL_AMOUNT).append(LINE_ITEM_SEPARATOR).append(totalAmount);
    }

    private StringBuilder buildTotalSalesTax(StringBuilder output, double totalSalesTax) {
        return output.append(RECEIPT_SALES_TAX).append(LINE_ITEM_SEPARATOR).append(totalSalesTax);
    }

    private void buildCustomerInfo(StringBuilder output) {
        output.append(order.getCustomerInfo());
    }

    private StringBuilder buildHeader(StringBuilder output) {
        return output.append(RECEIPT_HEADER);
    }
}