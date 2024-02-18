package br.upe.repositories;

import java.util.ArrayList;

import br.upe.models.Usuario;
import static br.upe.utils.CPF_Validacao.validarCPF;

public class UsuarioRepositorio {
  private static UsuarioRepositorio instânciaRepositorio;
  private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

  private UsuarioRepositorio() {
    // Construtor privado para impedir instanciação direta.
  }

  public static UsuarioRepositorio getInstance() {
    if (instânciaRepositorio == null) {
      instânciaRepositorio = new UsuarioRepositorio();
    }
    return instânciaRepositorio;
  }

  // Método para criar usuários e adicioná-los a uma lista
  public void criarUsuario(Usuario usuario) {
    usuarios.add(usuario);// Teste para tentar adicionar sem passar pela validação 
    
    
    boolean cpfValido = validarCPF(usuario.getCpf());
    if (cpfValido) {
      usuarios.add(usuario);
    } else {
      System.out.println("Insira um CPF válido para criar o cadastro!\n");
    }
  }

  // Método para mostrar todos os usuários cadastrados
  public Usuario mostrarUsuarios() {
    if (usuarios.isEmpty()) {
      System.out.println("Não há clientes cadastrados no Sistema!\n");
      
    }
    for (Usuario usuario : usuarios) {
      System.out.println(usuario);
      return usuario;
    }
    return null;
  }

  // Método para atualizar os dados do usuário pelo CPF
  public void atualizarUsuario(String cpf, Usuario usuario) {
    boolean encontrado = false;
    for (int i = 0; i < usuarios.size(); i++) {
      if (usuarios.get(i).getCpf().equals(cpf)) {
        usuarios.set(i, usuario);
        System.out.println("Dados atualizados com sucesso!\n");
        encontrado = true;
        break;
      }
    }
    if (!encontrado) {
      System.out.println("Usuário não encontrado!\n");
    }
  }

  // Método para deletar o usuário pelo CPF
  public void deletarUsuario(String cpf) {
    boolean encontrado = false;
    for (int i = 0; i < usuarios.size(); i++) {
      if (usuarios.get(i).getCpf().equals(cpf)) {
        usuarios.remove(i);
        System.out.println("Cliente Removido com Sucesso!\n");
        encontrado = true;
        break;
      }
    }
    if (!encontrado) {
      System.out.println("Cliente não encontrado!\n");
    }
  }

  // Método para buscar um usuário pelo CPF
  public void buscarUsuario(String cpf) {
    boolean encontrado = false;
    for (Usuario usuario : usuarios) {
      if (usuario.getCpf().equals(cpf)) {
        System.out.println(usuario);
        encontrado = true;
        break;
      }
    }
    if (!encontrado) {
      System.out.println("Usuário não encontrado!\n");
    }
  }

  // Métodos getter e setter para a lista de usuários
  public ArrayList<Usuario> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(ArrayList<Usuario> usuarios) {
    this.usuarios = usuarios;
  }
}
