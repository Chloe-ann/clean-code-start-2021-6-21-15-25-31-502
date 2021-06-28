package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class Address {
    private final String address;

    public Address(String address) {
        this.address = address;
    }

    public String getCity() {
        return getAddress().substring(getAddress().indexOf("省") + 1, getAddress().indexOf("市"));
    }

    public String getProvince() {
        return getAddress().substring(0, getAddress().indexOf("省"));
    }

    public String getAddress() {
        return address;
    }
}
