package br.upe.repositories;

import java.util.ArrayList;

import br.upe.models.Usuario;

public interface IUsuarioRepositorio {
  public ArrayList<Usuario> buscarTodos();

  public void salvar(Usuario usuario);

  public void deletar(Usuario usuario);

  public void atualizar(Usuario usuario);

  public Usuario buscarPorId(int id);

  public Usuario buscarPorCpf(String cpf);
}
