package com.xp.Model;

public enum TicketType {
    CHILD(75),
    ADULT(140),
    SENIOR(90);

    private final double price;

    TicketType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
