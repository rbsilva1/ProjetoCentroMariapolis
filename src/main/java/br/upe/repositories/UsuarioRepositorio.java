package br.upe.repositories;

import java.util.ArrayList;
import java.util.List;

import br.upe.models.Usuario;
import static br.upe.utils.CpfValidacao.validarCPF;

public class UsuarioRepositorio {
  private List<Usuario> usuarios = new ArrayList<Usuario>();

  {
    new Usuario("100.868.754-50", "Vitório Fernandes de Amorim", 3, 3, 3, "12/09/2002");
  }

  private static class SingletonHelper {
    private static final UsuarioRepositorio INSTANCE = new UsuarioRepositorio();
  }

  public static UsuarioRepositorio getInstance() {
    return SingletonHelper.INSTANCE;
  }

  // Método para criar usuários e adicioná-los a uma lista
  public void criarUsuario(Usuario usuario) {
    usuarios.add(usuario);// Teste para tentar adicionar sem passar pela validação

    boolean cpfValido = validarCPF(usuario.getCpf());
    if (cpfValido) {
      usuarios.add(usuario);
    } else {
    }
  }

  // Método para mostrar todos os usuários cadastrados
  public Usuario mostrarUsuarios() {
    if (!usuarios.isEmpty()) {
      for (Usuario usuario : usuarios) {
        return usuario;
      }
    }

    return null;
  }

  // Método para atualizar os dados do usuário pelo CPF
  public void atualizarUsuario(String cpf, Usuario usuario) {
    boolean encontrado = false;
    for (int i = 0; i < usuarios.size(); i++) {
      if (usuarios.get(i).getCpf().equals(cpf)) {
        usuarios.set(i, usuario);
        encontrado = true;
        break;
      }
    }
    if (!encontrado) {
    }
  }

  // Método para deletar o usuário pelo CPF
  public void deletarUsuario(String cpf) {
    boolean encontrado = false;
    for (int i = 0; i < usuarios.size(); i++) {
      if (usuarios.get(i).getCpf().equals(cpf)) {
        usuarios.remove(i);
        encontrado = true;
        break;
      }
    }
    if (!encontrado) {
    }
  }

  // Método para buscar um usuário pelo CPF
  public Usuario buscarUsuario(String cpf) {
    Usuario usuarioEncontrado = null;
    boolean encontrado = false;
    for (Usuario usuario : usuarios) {
      if (usuario.getCpf().equals(cpf)) {
        usuarioEncontrado = usuario;
        encontrado = true;
        break;
      }
    }
    if (encontrado) {
      return usuarioEncontrado;
    }
    return null;
  }

  // Métodos getter e setter para a lista de usuários
  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }
}
