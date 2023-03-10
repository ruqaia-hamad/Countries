import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Main {

	public static void main(String[] args) throws InstantiationException, Throwable {

		Scanner sc = new Scanner(System.in);
		boolean isExitMenu3 = true;
		while (isExitMenu3) {
			System.out.println("\t\t++++++++++++++++++++++++++++++++++");
			System.out.println("\t\t+ WELCOME TO THE SYSTEM          +");
			System.out.println("\t\t++++++++++++++++++++++++++++++++++\n");
			System.out.println("Please Choose Number From Menu:       \n");
			System.out.println(" =====================================");
			System.out.println("|  [1]READ FROM THE API               |");
			System.out.println("|  [2]INSERT TO THE DB                |");
			System.out.println("|  [3]DELETE THE DATA FROM DB         |");
			System.out.println("|  [4]UPDATE THE DATA IN DB           |");
			System.out.println("|  [5]EXIT                            |");
			System.out.println(" =====================================");
			Integer num = sc.nextInt();

			switch (num) {
			case 1:
				Read.read();
				break;
			case 2:
				Insert.insert();
				break;
			case 3 :
				Delete.deleteById();
				break;
			case 4 :
				Update.update();
				break;
			case 5 :
				System.out.println("THANK YOU");
				isExitMenu3=false; 
				
			}
		}
	}
}
