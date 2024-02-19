package br.upe.utils;

import br.upe.models.*;
import br.upe.repositories.*;

// Em casos de retorno nulo ou saldo insuficiente, levar para a tela de compra

public class VerificarSaldo {
    public String verificarSaldoPorCpf(String cpf) {
        Usuario usuario = UsuarioRepositorio.getInstance().buscarUsuario(cpf);
        if (usuario != null) {
            if (usuario.getAlmoco() != 0 || usuario.getJanta() != 0 || usuario.getCafe() != 0) {
                return "Liberar catraca";
            } else {
                return "Saldo insuficiente";
            }
        }
        return "Usuário não cadastrado";
    }
}
