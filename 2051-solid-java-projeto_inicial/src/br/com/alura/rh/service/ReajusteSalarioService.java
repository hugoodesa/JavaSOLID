package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.interfaces.ValidacaoReajuste;
import br.com.alura.rh.model.Funcionario;

public class ReajusteSalarioService implements ValidacaoReajuste {

	@Override
	public void validar(Funcionario funcionario, BigDecimal aumento) {

		BigDecimal percentualAumento = funcionario.getSalario().divide(funcionario.getSalario(),RoundingMode.HALF_UP);
		
		if(percentualAumento.compareTo(new BigDecimal(0.4))>=0) {
			throw new ValidacaoException("O ajuste de salario deve representar menos que 40% do salário do funcionario");
		}
		
		
	}

}
