package br.upe.facades;

import java.util.List;

import br.upe.models.Usuario;
import br.upe.repositories.UsuarioRepositorio;

public class FachadaUsuario {
  private UsuarioRepositorio usuarioRepositorio = UsuarioRepositorio.getInstance();

  public void criarUsuario(String cpf, String nome, int cafe, int almoco, int janta, String data) {
    Usuario usuario = new Usuario(cpf, nome, cafe, almoco, janta, data);
    usuarioRepositorio.criarUsuario(usuario);
  }

  public Usuario buscarUsuario(String cpf) {
    return usuarioRepositorio.buscarUsuario(cpf);
  }

  public List<Usuario> mostrarUsuarios() {
    return usuarioRepositorio.mostrarUsuarios();
  }

  public void atualizarUsuario(String cpf, Usuario usuario) {
    usuarioRepositorio.atualizarUsuario(cpf, usuario);
  }

  public void deletarUsuario(String cpf) {
    usuarioRepositorio.deletarUsuario(cpf);
  }
}