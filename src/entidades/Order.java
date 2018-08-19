package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.StatusPedido;

public class Order {

	private Date momento = new Date();
	private StatusPedido status;

	private Cliente cliente;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

	List<OrderItem> items = new ArrayList<>();

	public Order() {

	}

	public Order(Date momento, StatusPedido status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void addItems(OrderItem item) {
		items.add(item);
	}

	public void removeItems(OrderItem item) {
		items.remove(item);
	}

	public double total() {
		double soma = 0;

		for (OrderItem list : items) {
			soma += list.subTotal();
		}
		return soma;
	}

	public String toString() {
		StringBuilder sbr = new StringBuilder();
		sbr.append("Hora do Pedido: " + sdf.format(momento) + "\n").append("Status do Pedido: " + status + "\n")
				.append("Cliente: " + cliente + "\n").append("Itens do Pedido: " + "\n");

		for (OrderItem listItens : items) {
			sbr.append(listItens.getProduto().getNomeProduto() + ", $ " + String.format("%.2f", listItens.getPreco())
					+ ", Quantidade: " + listItens.getQuantidade() + ", Subtotal: $"
					+ String.format("%.2f", listItens.subTotal()) + "\n");
		}

		sbr.append("Total: " + total());
		return sbr.toString();
	}

}
