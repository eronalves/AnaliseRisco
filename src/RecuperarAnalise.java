import java.io.Serializable;

import br.com.analiserisco.data.ListAnaliseRisco;
import br.com.analiserisco.model.AnaliseRiscoTO;
import br.com.analiserisco.model.MensagemTO;


public class RecuperarAnalise implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public MensagemTO recuperarAnalise(int pedido){
		MensagemTO mensagem = new MensagemTO();
		
		AnaliseRiscoTO analise = ListAnaliseRisco.getListAnaliseRisco().get(pedido);
		if(analise == null){
			mensagem.setCodigo(404);
			mensagem.setDescricao("Não encontrado solicitação de análise para esse pedido.");
		} else{
			mensagem.setCodigo(analise.getStatus().getIndex());
			mensagem.setDescricao(analise.getStatus().getValue());			
		}
		
		return mensagem;
	}

}
