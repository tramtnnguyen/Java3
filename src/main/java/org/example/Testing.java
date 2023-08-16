package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Testing {
    public static void main(String[] args) {
        String csvFilePath = "/Users/tramtnnguyen/Downloads/output.csv"; // Đường dẫn tới tệp CSV đầu vào

        try {
            CSVReader reader = new CSVReaderBuilder(new FileReader(csvFilePath)).withSkipLines(1).build();

            JSONArray jsonArray = new JSONArray();
            String[] headers = reader.readNext();
            String[] line;

            while ((line = reader.readNext()) != null) {
                JSONObject jsonObject = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i], line[i]);
                }
                jsonArray.put(jsonObject);
            }

            // In dữ liệu JSON ra màn hình
            System.out.println(jsonArray.toString(4)); // 4 là số khoảng trắng để hiển thị thụt lề
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}




