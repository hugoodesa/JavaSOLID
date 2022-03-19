package br.com.alura.rh.interfaces;

import java.math.BigDecimal;

import br.com.alura.rh.model.Funcionario;

public interface ValidacaoReajuste {

	public void validar(Funcionario funcionario,BigDecimal aumento);
	
}
