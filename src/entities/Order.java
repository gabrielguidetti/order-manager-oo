package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	public static SimpleDateFormat sdfDayHour = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static SimpleDateFormat sdfDay = new SimpleDateFormat("dd/MM/yyyy");

	private Date moment;
	private OrderStatus status;
	
	private Client client;
	List<OrderItem> orderItems = new ArrayList<>();
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem orderItem) {
		orderItems.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem) {
		orderItems.remove(orderItem);
	}
	
	public Double total() {
		Double sum = 0.0;
		for(OrderItem o : orderItems){
			sum += o.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment: ");
		sb.append(sdfDayHour.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client.getName());
		sb.append("("+sdfDay.format(client.getBirthDate())+") - ");
		sb.append(client.getEmail() + "\n");
		sb.append("Order items: \n");
		for(OrderItem oi : orderItems){
			sb.append(oi.getProduct().getName() + ", ");
			sb.append("$"+oi.getPrice()+", ");
			sb.append("Quantity: "+oi.getQuantity()+", ");
			sb.append("Subtotal: $"+oi.subTotal() + "\n");
		}
		sb.append("Total price: $"+ total());
		return sb.toString();
	}
}
