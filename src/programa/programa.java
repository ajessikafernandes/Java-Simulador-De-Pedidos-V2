package programa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Cliente;
import entidades.Order;
import entidades.OrderItem;
import entidades.Produto;
import enums.StatusPedido;

public class programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner ler = new Scanner (System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Cliente
		System.out.println("Entre com os dados do Cliente: ");
		System.out.print("Nome Cliente: ");
		String nome = ler.nextLine();
		System.out.print("Email: ");
		String email = ler.nextLine();
		System.out.print("Data de Nascimento: ");
		Date dataNascimento = sdf.parse(ler.nextLine()); //Exceção
				
		Cliente cliente = new Cliente(nome, email, dataNascimento);
		
		//Pedido
		System.out.println("Entre com os dados do Pedido: ");
		System.out.print("Status do Pedido: ");
		StatusPedido status = StatusPedido.valueOf(ler.nextLine());
		System.out.print("Informe a quantidade de Itens: ");
		int qtd = ler.nextInt();
		ler.nextLine();
		
		Order order = new Order(new Date (), status, cliente);
		
		for (int cont = 1; cont <= qtd; cont++) {
			System.out.println("Entre com os dados do pedido #" + cont + " :");
			System.out.print("Nome do Produto: ");
			String nomeProduto = ler.nextLine();
			System.out.print("Valor do Item: $");
			double preco = ler.nextDouble();
			Produto produto = new Produto(nomeProduto, preco);
			
			System.out.print("Quantidade: ");
			int quantidade = ler.nextInt();
			
			OrderItem orderItems = new OrderItem(preco, quantidade, produto);
			order.addItems(orderItems);
			
			ler.nextLine();
			
		}
		
		System.out.println("");
		System.out.println("Sumário do Pedido: ");
		System.out.println(order);
		
		ler.close();
	}
	
}
