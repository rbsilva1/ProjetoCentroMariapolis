package br.upe.repositories;

import java.util.ArrayList;

import br.upe.models.Usuario;

public class UsuarioRepositorio {
  public static UsuarioRepositorio instânciaRepositorio;
  private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

  public static UsuarioRepositorio getInstance() {
    if (instânciaRepositorio == null) {
      instânciaRepositorio = new UsuarioRepositorio();
    }
    return instânciaRepositorio;
  }

  // Metódo de Criar os usuários e adicionar em um Array List
  public void criarUsuario(Usuario usuario) {
    usuarios.add(usuario);
  }

  // Metódo de Mostrar todos os clientes cadastrados
  public Usuario MostrarUsuarios() {
    if (usuarios.isEmpty()) {
      System.out.println("Não há clientes cadastrados no Sistema !\n");
    }
    for (int i = 0; i < usuarios.size();i++) {
      System.out.println(usuarios.get(i));
      return usuarios.get(i);
    }
    return null;
  }

  // Metodo de atualizar os dados do cliente, procurando atráves do CPF do cliente
  public void atualizarUsuario(String cpf, Usuario usuario) {
    if (usuarios.isEmpty()) {
      System.out.println("Não há clientes cadastrados no Sistema !\n");
    }
    for (int i = 0; i < usuarios.size(); i++) {
      if (usuarios.get(i).getCpf().equals(cpf)) {
        usuarios.set(i, usuario);
        System.out.println("Dados atualizados com sucesso !\n");
      } else {
        System.out.println("Usuário não encontrado !\n");
      }
    }
  }

  // Metodo de deletar o usuário, procurando atráves do CPF
  public void deletarUsuario(String cpf) {
    if (usuarios.isEmpty()) {
      System.out.println("Não há clientes cadastrados no Sistema !\n");
    }
    for (int i = 0; i < usuarios.size(); i++) {
      if (usuarios.get(i).getCpf().equals(cpf)) {
        usuarios.remove(i);
        System.out.println("Cliente Removido com Sucesso !\n");
      } else {
        System.out.println("Cliente não encontrado !\n");
      }
    }
  }

  // Metodo de buscar o usuário especifico através do CPF
  public void buscarUsuario(String cpf) {
    if (usuarios.isEmpty()) {
      System.out.println("Não há clientes cadastrados no Sistema !\n");
    }
    for (int i = 0; i < usuarios.size(); i++) {
      if (usuarios.get(i).getCpf().equals(cpf)) {
        System.out.println(usuarios.get(i));
      }
    }
  }
}
