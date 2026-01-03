package com.store.rmi;

import java.rmi.server.UnicastRemoteObject;

public class PriceServiceImpl extends UnicastRemoteObject
        implements PriceService {

    public PriceServiceImpl() throws Exception {}

    public double getDiscountedPrice(double price) {
        return price * 0.9;
    }
}
