package br.com.analiserisco.model;

public enum StatusAnaliseEnum {

    ANALISE("Em Análise", 0), APROVADO("Aprovado", 1), REPROVADO("Reprovado", 2);
	
	String value;
	
	int index;
	
	StatusAnaliseEnum(String value, int index){
		this.value = value;
		this.index = index;
	}

	public String getValue() {
		return value;
	}
	
	public int getIndex() {
		return index;
	}

	public static StatusAnaliseEnum getEnumByValue(String value){
		if(value.equals(ANALISE.getValue())){
			return ANALISE;
		} else if(value.equals(APROVADO.getValue())){
			return APROVADO;
		} else if(value.equals(REPROVADO.getValue())){
			return REPROVADO;
		} else {
			return null;
		}
	}
	
	public static StatusAnaliseEnum getEnumByIndex(int index){
		if(index == ANALISE.getIndex()){
			return ANALISE;
		} else if(index == APROVADO.getIndex()){
			return APROVADO;
		} else if(index == REPROVADO.getIndex()){
			return REPROVADO;
		} else{
			return null;
		}
	}
}
