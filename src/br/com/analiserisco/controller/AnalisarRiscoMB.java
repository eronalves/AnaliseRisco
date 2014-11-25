package br.com.analiserisco.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.analiserisco.data.ListAnaliseRisco;
import br.com.analiserisco.model.AnaliseRiscoTO;
import br.com.analiserisco.model.StatusAnaliseEnum;

@ViewScoped
@ManagedBean
public class AnalisarRiscoMB implements Serializable{
	private static final long serialVersionUID = 1L;

	private AnaliseRiscoTO analise;
	
	private List<AnaliseRiscoTO> listAnaliseRisco;

	public AnaliseRiscoTO getAnalise() {
		return analise;
	}

	public void setAnalise(AnaliseRiscoTO analise) {
		this.analise = analise;
	}

	public List<AnaliseRiscoTO> getListAnaliseRisco() {
		if(listAnaliseRisco == null){			
			listAnaliseRisco = new ArrayList<AnaliseRiscoTO>();
			
			for (Map.Entry<Integer, AnaliseRiscoTO> mapAnalise : ListAnaliseRisco.getListAnaliseRisco().entrySet()) {
				if(mapAnalise.getValue().getStatus() == StatusAnaliseEnum.ANALISE){
					listAnaliseRisco.add(mapAnalise.getValue());
				}
			}
		}
		
		return listAnaliseRisco;
	}
	
	public void onClickAprovar(){
		if(analise != null){
			AnaliseRiscoTO analiseRisco = ListAnaliseRisco.getListAnaliseRisco().get(analise.getPedido()); 
			analiseRisco.setStatus(StatusAnaliseEnum.APROVADO);
			
			listAnaliseRisco = null;
			
		enviarMensagemInfo("", "Pedido " + String.valueOf(analise.getPedido()) + " aprovado.");
		}
	}
	
	public void onClickReprovar(){
		if(analise != null){
			AnaliseRiscoTO analiseRisco = ListAnaliseRisco.getListAnaliseRisco().get(analise.getPedido()); 
			analiseRisco.setStatus(StatusAnaliseEnum.REPROVADO);
			
			listAnaliseRisco = null;
			
			enviarMensagemInfo("", "Pedido " + String.valueOf(analise.getPedido()) + " reprovado."); 
		}
	}
	
	public void onClickAtualizar(){
		listAnaliseRisco = null;
	}
	
	public void enviarMensagemInfo(String titulo, String mensagem){
		FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage(titulo, mensagem) );        		
	}

}
