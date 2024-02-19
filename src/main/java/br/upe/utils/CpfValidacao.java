package br.upe.utils;

public class CpfValidacao {
    private CpfValidacao() {
    }

    public static boolean validarCPF(String cpf) {// Método de Verificação de CPF
        // Removendo caracteres especiais do CPF e deixando somente os números
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verificando se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verificando se todos os dígitos do CPF são iguais, o que torna o CPF inválido
        boolean digitosIguais = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                digitosIguais = false;
                break;
            }
        }
        if (digitosIguais) {
            return false;
        }

        // Calculando o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int resto = soma % 11;
        int digitoVerificador1 = (resto < 2) ? 0 : (11 - resto);

        // Verificando o primeiro dígito verificador
        if (digitoVerificador1 != Character.getNumericValue(cpf.charAt(9))) {
            return false;
        }

        // Calculando o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        resto = soma % 11;
        int digitoVerificador2 = (resto < 2) ? 0 : (11 - resto);

        // Verificando o segundo dígito verificador
        return (digitoVerificador2 == Character.getNumericValue(cpf.charAt(10)));
    }
}
