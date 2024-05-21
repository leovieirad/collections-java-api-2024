package OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
	private List<Item>itemList;
	
	public CarrinhoDeCompras() {
		this.itemList = new ArrayList<>();
	}
	
	public void adicionarItem(String nome, double preco, int quantidade) {
		itemList.add(new Item(nome, preco, quantidade));
	}
	
	public void removerItem(String nome) {
		List<Item> itensParaRemover = new ArrayList<>();
		if (!itemList.isEmpty()) {
			for(Item i : itemList) {
				if (i.getNome().equalsIgnoreCase(nome)) {
					itensParaRemover.add(i);
				}
			}
			itemList.removeAll(itensParaRemover);	
		}else {
			System.out.println("O carrinho de compras está vazio!");
		}
	}
	  
	public double calcularValorTotal() {
		double valorTotal = 0d;
		if (!itemList.isEmpty()) {
			for (Item item : itemList) {
				double valorItem =item.getPreco() * item.getQuantidade();
				valorTotal += valorItem;
			}
			return valorTotal;
		}else {
			throw new RuntimeException("O carrinho de compras está vazio!");
		}
	}
	
	public void exibirItens() {
		if (!itemList.isEmpty()) {
			System.out.println(itemList);
		} else {
			System.out.println("O carrinho de compras está vazio!");
		}
	}

	@Override
	public String toString() {
		return "CarrinhoDeCompras{" +
	        "itens=" + itemList +
	        '}';
	  }
	
	public static void main(String[] args) {
		
		CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
		
		carrinhoDeCompras.adicionarItem("Caneta", 2d, 3);
		carrinhoDeCompras.adicionarItem("Caderno", 35d, 1);
		carrinhoDeCompras.adicionarItem("Lápis", 2d, 2);
		carrinhoDeCompras.adicionarItem("Borracha", 2d, 2);
		
		carrinhoDeCompras.exibirItens();
		
		carrinhoDeCompras.removerItem("Caneta");
		
		carrinhoDeCompras.exibirItens();
		
		System.out.println("O valor total da compra é = "+ carrinhoDeCompras.calcularValorTotal());
	}
}