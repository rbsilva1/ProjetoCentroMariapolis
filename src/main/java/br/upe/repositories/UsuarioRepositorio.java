package br.upe.repositories;

import java.util.ArrayList;

import br.upe.models.Usuario;

public class UsuarioRepositorio {
  public static UsuarioRepositorio instance;
  private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

  public static UsuarioRepositorio getInstance() {
    if (instance == null) {
      instance = new UsuarioRepositorio();
    }
    return instance;
  }

  public ArrayList<Usuario> buscarTodos() {
    return this.usuarios;
  }

  public void salvar(Usuario usuario) {
    this.usuarios.add(usuario);
  }

  public void deletar(Usuario usuario) {
    this.usuarios.remove(usuario);
  }

  public void atualizar(Usuario usuario) {
    for (int i = 0; i < this.usuarios.size(); i++) {
      if (this.usuarios.get(i).getId() == usuario.getId()) {
        this.usuarios.set(i, usuario);
        break;
      }
    }
  }

  public Usuario buscarPorId(int id) {
    for (Usuario usuario : this.usuarios) {
      if (usuario.getId() == id) {
        return usuario;
      }
    }
    return null;
  }

  public Usuario buscarPorCpf(String cpf) {
    for (Usuario usuario : this.usuarios) {
      if (usuario.getCpf().equals(cpf)) {
        return usuario;
      }
    }
    return null;
  }
}
