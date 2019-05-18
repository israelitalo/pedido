package pedido.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import pedido.entities.Cliente;
import pedido.entities.DescricaoPedido;
import pedido.entities.Item;
import pedido.entities.Produto;
import pedido.enums.StatusPedido;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data:");
		
		System.out.print("Nome: ");
		String nomeCliente = sc.next();
		System.out.print("E-mail: ");
		String email = sc.next();
		System.out.print("Data de Nascimento (dd/mm/yyyy): ");
		Date dataNascimento = sdf.parse(sc.next());
		
		Cliente cl1 = new Cliente(nomeCliente, email, dataNascimento);
		
		System.out.println("-Verificação do Status do pedido-");
		System.out.print("Status: ");
		StatusPedido status = StatusPedido.valueOf(sc.next());
		
		DescricaoPedido pedido1 = new DescricaoPedido(new Date(), status, cl1);
		
		System.out.printf("Quantos produtos serão acrescentados ao pedido?");
		int contador = sc.nextInt();
		
		for(int i=1; i<=contador;i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Produto: ");
			String nomeProduto = sc.next();
			System.out.print("Preço do produto: ");
			Double precoProduto = sc.nextDouble();
			Produto p1 = new Produto(nomeProduto, precoProduto);
			System.out.print("Quantidade: ");
			int quantidade = sc.nextInt();
			Item item1 = new Item(quantidade, precoProduto, p1);
			pedido1.addItem(item1);
		
		}
		
		System.out.println("Order Summary:");
		System.out.println(pedido1);
		
		sc.close();
	}

}
