package com.tw.academy.basic.$7_long_method;

public class LineItem {
	public static final String LINE_ITEM_SEPARATOR = "\t";
	public static final String LINE_SEPARATOR = "\n";
	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double price, int quantity) {
		super();
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    double totalAmount() {
        return price * quantity;
    }

	@Override
	public String toString() {
		return description + LINE_ITEM_SEPARATOR + price + LINE_ITEM_SEPARATOR + quantity + LINE_ITEM_SEPARATOR + totalAmount() + LINE_SEPARATOR;
	}


}