import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static br.upe.utils.CPF_Validacao.validarCPF;

public class ValidarCPFTest {
  @Test
  @DisplayName("Teste de CPF válido")
  public void testarCPFValido() {
    assertTrue(validarCPF("116.706.480-10"));
  }

  @Test
  @DisplayName("Teste de CPF inválido")
  public void testarCPFInvalido() {
    assertFalse(validarCPF("116.706.480-11"));
  }  
}
