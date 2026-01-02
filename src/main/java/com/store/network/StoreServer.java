package com.store.network;

import java.net.*;
import java.io.*;

public class StoreServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        Socket client = server.accept();

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        out.println("Connected to Store Server");

        server.close();
    }
}