package br.com.analiserisco.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.com.analiserisco.model.AnaliseRiscoTO;

public class ListAnaliseRisco implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private static Map<Integer, AnaliseRiscoTO> listAnaliseRisco;
	
	public static Map<Integer, AnaliseRiscoTO> getListAnaliseRisco(){
		if(listAnaliseRisco == null){
			listAnaliseRisco = new HashMap<Integer, AnaliseRiscoTO>();
		}
		
		return listAnaliseRisco;
	}

}
