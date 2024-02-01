package br.upe.models;

import java.util.ArrayList;

public class UsuarioRepositorio {
  private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

  {
    this.usuarios.add(new Usuario(1, "Daniel", "12345678910", 1, "Evento 1"));
    this.usuarios.add(new Usuario(2, "Rodrigo", "12345678910", 1, "Evento 1"));
    this.usuarios.add(new Usuario(3, "Kaiky", "12345678910", 1, "Evento 1"));
    this.usuarios.add(new Usuario(4, "Vitorio", "12345678910", 1, "Evento 1"));
    this.usuarios.add(new Usuario(5, "Anderson", "12345678910", 1, "Evento 1"));
    this.usuarios.add(new Usuario(6, "Rodrigo", "12345678910", 1, "Evento 1"));
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
