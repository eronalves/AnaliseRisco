package br.com.analiserisco.model;

import java.io.Serializable;

public class AnaliseRiscoTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int pedido;
	
	private String cliente;
	
	private double valor;
	
	private StatusAnaliseEnum status; 

	public int getPedido() {
		return pedido;
	}

	public void setPedido(int pedido) {
		this.pedido = pedido;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public StatusAnaliseEnum getStatus() {
		return status;
	}

	public void setStatus(StatusAnaliseEnum status) {
		this.status = status;
	}

}
