package br.com.alura.rh.service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.interfaces.ValidacaoReajuste;
import br.com.alura.rh.model.Funcionario;

public class ValidaPeriodicidadeEntreAjustes implements ValidacaoReajuste {

	@Override
	public void validar(Funcionario funcionario,BigDecimal aumento) {
		LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
		long mesesEntreAjustes = ChronoUnit.MONTHS.between(dataUltimoReajuste, LocalDate.now());

		if (mesesEntreAjustes < 6) {
			throw new ValidacaoException(
					"O ajuste de salario deve representar menos que 40% do salário do funcionario");
		}
	}

}
