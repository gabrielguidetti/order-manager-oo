package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name,email,birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.next();
		
		Order order = new Order(new Date(),OrderStatus.valueOf(status),client);
		
		System.out.print("How many items to this order? ");
		int qtd = sc.nextInt();
		sc.nextLine();
		
		for(int i = 1; i <= qtd; i++){
			System.out.println("Enter #"+i+" item data:");
			System.out.print("Product name: ");
			String pName = sc.next();
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			OrderItem orderItem = new OrderItem(quantity, price, new Product(pName,price));
			order.addItem(orderItem);
		}
		
		System.out.println(order);
		
		sc.close();
	}

}
