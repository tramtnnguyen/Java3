package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Scanner;
import java.util.*;


public class CsvtoJson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
                System.out.println("Menu:");
                System.out.println("1. Option 1");
                System.out.println("2. Option 2");
                System.out.println("3. Option 3");
                System.out.println("0. Exit");
                System.out.print("Select an option: ");
                int selectedOption = scanner.nextInt();


                switch (selectedOption) {
                    case 1:
                        System.out.println("You selected Option 1.");
                        GetonlyBaseQuestion("/Users/tramtnnguyen/Downloads/DataCollection.csv");
                        break;
                    case 2:
                        System.out.println("You selected Option 2.");
                        readCsvUsingBufferReader("/Users/tramtnnguyen/Downloads/output.csv");
                        break;
                    case 3:
                        System.out.println("You selected Option 3.");
                        GetonlyBaseQuestion("/Users/tramtnnguyen/Downloads/DataCollection.csv");
                        readCsvUsingBufferReader("/Users/tramtnnguyen/Downloads/output.csv");
                        break;
                    case 0:
                        System.out.println("Exiting the program.");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid option.");
                }
            }

    }
       // GetonlyBaseQuestion("/Users/tramtnnguyen/Downloads/DataCollection.csv");
       // readCsvUsingBufferReader("/Users/tramtnnguyen/Downloads/DataCollection.csv");



    private static void GetonlyBaseQuestion(String input){
        String inputFile = input;   // Replace with your input CSV file path
        String outputFile = "/Users/tramtnnguyen/Downloads/output.csv"; // Replace with the desired output file path

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileWriter fw = new FileWriter(outputFile);

            String line;
            HashSet<String> seenStrings = new HashSet<>();
            String inputString =" ";
            boolean isDuplicate = false;
            Scanner scanner = new Scanner(new File(inputFile));
            while ((line = br.readLine()) != null && !inputString.isEmpty()) {

                // Split CSV line by comma
                String[] data = line.split(",");
                inputString = data[0];
                // Modify the data or process it as needed
                // For example, let's concatenate the second and third columns
                String modifiedLine = data[0];
                if(!seenStrings.contains(inputString) && !data[0].equals("smalltalk")){
                    inputString = modifiedLine;
                    seenStrings.add(inputString);
                    System.out.println();
                    fw.write(modifiedLine + "\n"); // Write modified data to output CSV file
                }
            }

            br.close();
            fw.close();

            System.out.println("File processing complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void readCsvUsingBufferReader(String filePath) {

        String line = "";
        String deleimeter = ",";
        String encoding = "UTF-8";
         int id =1;
         String x = "REQ_00";
         String type ="REQUEST";
        List<Data> datas = new ArrayList<Data>();

        try {
            BufferedReader reader  = new BufferedReader( new InputStreamReader(new FileInputStream(filePath),encoding));
            try {
                while((line = reader.readLine()) !=null){
                    //      System.out.println("User data : "+ line);

                    Id test = new Id(x,id);
                    String n = Integer.toString(id);
                    String m = test.getX()+n;
                    String[] userData = line.split(deleimeter);

                    datas.add(new Data(m,type,m,userData[0]));
                  //   System.out.println(userData[0]);
                     id++;
                }
                System.out.println("org.example.Data json : " + new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create().toJson(datas));
                try {
                    FileWriter writer = new FileWriter("/Users/tramtnnguyen/Downloads/sample1.json");
                    writer.write(new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create().toJson(datas));
                    writer.close();
                    System.out.println("Program code has been written to sample1sample.json");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}





