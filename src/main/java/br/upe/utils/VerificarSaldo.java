package br.upe.utils;

import br.upe.models.*;
import br.upe.repositories.*;

// Em casos de retorno nulo ou saldo insuficiente, levar para a tela de compra

public class VerificarSaldo {
    public UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();

    public String verificarSaldoPorCpf(String CPF) {
        Usuario usuario = usuarioRepositorio.buscarPorCpf(CPF);
        if (usuario != null) {
            if (usuario.getRefeicoes() != 0) {
                return "Liberar catraca";
            } else {
                return "Saldo insuficiente";
            }
        }
        return "Usuário não cadastrado";
    }

    public String verificarSaldoPorID(int ID) {
        Usuario usuario = usuarioRepositorio.buscarPorId(ID);
        if (usuario != null) {
            if(usuario.getRefeicoes() != 0) {
                return "Liberar catraca";
            } else {
                return "Saldo insuficiente";
            }
        }
        return "Usuário não cadastrado";
    }
}
