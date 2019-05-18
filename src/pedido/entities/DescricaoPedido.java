package pedido.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pedido.enums.StatusPedido;

public class DescricaoPedido {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date data;
	private StatusPedido status;
	
	private Cliente cliente;
	
	private List<Item>listaItens = new ArrayList<>();

	public DescricaoPedido(Date data, StatusPedido status, Cliente cliente) {
		this.data = data;
		this.status = status;
		this.cliente = cliente;
	}

	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	public static void setSdf(SimpleDateFormat sdf) {
		DescricaoPedido.sdf = sdf;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public List<Item> getListaItens() {
		return listaItens;
	}

	public void addItem (Item item) {
		listaItens.add(item);
	}
	
	public void removeitem (Item item) {
		listaItens.remove(item);
	}
	
	public Double total() {
		double soma = 0.0;
		
		for(Item lista:listaItens) {
			soma += lista.subTotal();
		}
		return soma;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Data pedido: ");
		sb.append(sdf.format(data) + "\n");
		sb.append("Status: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("-Itens- " + "\n");
		for(Item lista:listaItens) {
			sb.append(lista);
		}
		sb.append("Preço total: R$");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
	
}
