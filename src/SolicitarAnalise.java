import java.io.Serializable;

import br.com.analiserisco.data.ListAnaliseRisco;
import br.com.analiserisco.model.AnaliseRiscoTO;
import br.com.analiserisco.model.MensagemTO;
import br.com.analiserisco.model.StatusAnaliseEnum;


public class SolicitarAnalise implements Serializable{
	private static final long serialVersionUID = 1L;

	public MensagemTO solicitarAnalise(int pedido, String cliente, double valor){
		MensagemTO mensagem = new MensagemTO();
		
		if (ListAnaliseRisco.getListAnaliseRisco().containsKey(pedido)) {
			mensagem.setCodigo(2);
			mensagem.setDescricao("O pedido solicitado j� se encontra em an�lise.");	
		} else {			
			AnaliseRiscoTO analise = new AnaliseRiscoTO();
			analise.setPedido(pedido);
			analise.setCliente(cliente);
			analise.setValor(valor);
			analise.setStatus(StatusAnaliseEnum.ANALISE);
			
			ListAnaliseRisco.getListAnaliseRisco().put(pedido, analise);
			
			mensagem.setCodigo(1);
			mensagem.setDescricao("Solicita��o de An�lise realizada com sucesso.");
		}
		
		return mensagem;
	}
}
