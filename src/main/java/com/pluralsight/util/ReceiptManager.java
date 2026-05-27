package com.pluralsight.util;

import com.pluralsight.model.Order;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {
    private String receiptsFolder;

    public ReceiptManager(String receiptsFolder) {
        this.receiptsFolder = receiptsFolder;
    }

    public void saveReceipt(Order order) {
        // Create the receipts folder if it doesn't exist
        File folder = new File(receiptsFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Generate filename from order date/time: yyyyMMdd-hhmmss.txt
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = order.getOrderDateTime().format(formatter) + ".txt";
        String filePath = receiptsFolder + "/" + fileName;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(order.getOrderDetails());
            writer.close();
            System.out.println("Receipt saved: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}