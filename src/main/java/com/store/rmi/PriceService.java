package com.store.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PriceService extends Remote {
    double getDiscountedPrice(double price) throws RemoteException;
}
