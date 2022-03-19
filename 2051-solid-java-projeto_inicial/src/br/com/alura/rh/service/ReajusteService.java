package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.rh.interfaces.ValidacaoReajuste;
import br.com.alura.rh.model.Funcionario;

public class ReajusteService {

	List<ValidacaoReajuste> validacoes = new ArrayList<>();
	
	public ReajusteService() {
	}

	public ReajusteService(List<ValidacaoReajuste> validacoes) {
		this.validacoes = validacoes;
	}

	public void realizarValidacoes(Funcionario funcionario , BigDecimal aumento) {
		for (ValidacaoReajuste validacaoReajuste : this.validacoes) {
			validacaoReajuste.validar(funcionario, aumento);
		}
		
		BigDecimal novoSalario = funcionario.getSalario().add(aumento);
		funcionario.atualizarSalario(novoSalario);
		System.out.println("Aumentado salario com sucesso !");
	}
	
}
