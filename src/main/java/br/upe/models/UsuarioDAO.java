package br.upe.models;

import java.util.ArrayList;

public class UsuarioDAO {
  public static UsuarioDAO instance;
  private UsuarioRepositorio usuarioRepositorio;

  private UsuarioDAO(UsuarioRepositorio usuarioRepositorio) {
    this.usuarioRepositorio = usuarioRepositorio;
  }

  public static UsuarioDAO getInstance() {
    if (instance == null) {
      instance = new UsuarioDAO(new UsuarioRepositorio());
    }
    return instance;
  }

  public void salvar(Usuario usuario) {
    // Salva o usuário no banco de dados
    this.usuarioRepositorio.salvar(usuario);
  }

  public void atualizar(Usuario usuario) {
    // Atualiza o usuário no banco de dados
    this.usuarioRepositorio.atualizar(usuario);
  }

  public void deletar(Usuario usuario) {
    // Deleta o usuário do banco de dados
    this.usuarioRepositorio.deletar(usuario);
  }

  public Usuario buscarPorId(int id) {
    // Busca o usuário no banco de dados
    if (this.usuarioRepositorio.buscarPorId(id) != null) {
      return this.usuarioRepositorio.buscarPorId(id);
    }

    return null;
  }

  public Usuario buscarPorCpf(String cpf) {
    // Busca o usuário no banco de dados
    if (this.usuarioRepositorio.buscarPorCpf(cpf) != null) {
      return this.usuarioRepositorio.buscarPorCpf(cpf);
    }

    return null;
  }

  public ArrayList<Usuario> buscarTodos() {
    // Busca todos os usuários no banco de dados
    return this.usuarioRepositorio.buscarTodos();
  }

}
