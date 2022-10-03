package Task_3;

import com.google.gson.Gson;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static final String URL_PATH = "https://api.kanye.rest/";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();
        List<Quote> quotes = new ArrayList<>();
        Quote quote = new Quote();
        try {
            getKanyeWestQuote();
            userMenu(scanner, quote, gson, quotes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    // This method is responsible for the user menu
    public static void userMenu(Scanner scanner, Quote quote, Gson gson, List<Quote> quotes){

        System.out.println("Welcome to the Kanye West quotes program");
        System.out.println("Here you can:");
        System.out.println("1) Get a Kanye West quote - write 'next'");
        System.out.println("2) Write your quote - write 'write'");
        System.out.println("3) Call all quotes while the program is running- write 'all'");
        System.out.println("4) Exit the program- write 'exit'");

        try{
            // A loop that runs until the user exits the program
            while (true){
                System.out.println("Make your choice...");
                String choose = scanner.nextLine();
                if (choose.equals("next")){
                    quote = gson.fromJson(getKanyeWestQuote(), Quote.class);
                    System.out.println(quote.getQuote());
                    quotes.add(quote);
                }
                else if (choose.equals("write")){
                    Quote s = new Quote();
                    String userQuote = scanner.nextLine();
                    s.setQuote(userQuote);
                    quotes.add(s);
                }
                else if (choose.equals("all")){
                    for (Quote quote1 : quotes) {
                        System.out.println(quote1.getQuote());
                    }
                }
                else if (choose.equals("exit")){
                    return;
                }
                else {
                    System.out.println("Error: the query is written incorrectly!!!");
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    // This method allows us to take quotes from "https://api.kanye.rest/"
    public static String getKanyeWestQuote() throws IOException{

        URL url = new URL(URL_PATH);
        URLConnection connection = url.openConnection();
        StringBuilder result = new StringBuilder();
        String line;
        try (InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        }
    }
}
