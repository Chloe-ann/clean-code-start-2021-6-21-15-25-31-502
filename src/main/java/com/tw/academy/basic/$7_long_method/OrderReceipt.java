package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
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


        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');

            double salesTax = lineItem.totalAmount() * TAX_RATE;
            totSalesTx += salesTax;

            tot += lineItem.totalAmount() + salesTax;
        }


        output.append(RECEIPT_SALES_TAX).append('\t').append(totSalesTx);


        output.append(RECEIPT_TOTAL_AMOUNT).append('\t').append(tot);
        return output.toString();
    }

    private StringBuilder buildHeader(StringBuilder output) {
        return output.append(RECEIPT_HEADER);
    }
}