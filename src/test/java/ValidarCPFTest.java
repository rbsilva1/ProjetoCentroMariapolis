import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static br.upe.utils.CPF_Validacao.validarCPF;

public class ValidarCPFTest {
  @Test
  @DisplayName("Deve retornar verdadeiro para CPF válido")
  public void testarCPFValido() {
    assertTrue(validarCPF("116.706.480-10"));
  }

  @Test
  @DisplayName("Deve retornar falso para CPF inválido")
  public void testarCPFInvalido() {
    assertFalse(validarCPF("116.706.480-11"));
  }  

  @Test
  @DisplayName("Deve retornar falso para CPF com menos de 11 dígitos")
  public void testarCPFMenosDigitos() {
    assertFalse(validarCPF("116.706.480-1"));
  }

  @Test
  @DisplayName("Deve retornar falso para CPF 11 dígitos iguais")
  public void testarCPF11DigitosIguais() {
    assertFalse(validarCPF("111.111.111-11"));
  }
}
