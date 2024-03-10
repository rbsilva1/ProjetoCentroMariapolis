package br.upe.repositories;

import java.util.List;
import javax.persistence.TypedQuery;
import br.upe.models.Usuario;
import br.upe.utils.JPAUtil;

import static br.upe.utils.CpfValidacao.validarCPF;

public class UsuarioRepositorio {
  private static class SingletonHelper {
    private static final UsuarioRepositorio INSTANCE = new UsuarioRepositorio();
  }

  public static UsuarioRepositorio getInstance() {
    return SingletonHelper.INSTANCE;
  }

  // Método para criar usuários e adicioná-los ao banco de dados
  public void criarUsuario(Usuario usuario) {
    boolean cpfValido = validarCPF(usuario.getCpf());
    if (cpfValido) {
      JPAUtil.getInstance().getTransaction().begin();
      JPAUtil.getInstance().getEntityManager().persist(usuario);
      JPAUtil.getInstance().getTransaction().commit();
    } else {
      // Ajustar para caso não consiga criar o usuário
    }
  }

  // Método para mostrar todos os usuários cadastrados
  public List<Usuario> mostrarUsuarios() {
    TypedQuery<Usuario> query = JPAUtil.getInstance().getEntityManager().createQuery("SELECT u FROM Usuario u",
        Usuario.class);
    return query.getResultList();
  }

  // Método para atualizar os dados do usuário pelo CPF
  public void atualizarUsuario(String cpf, Usuario usuario) {
    Usuario usuarioExistente = JPAUtil.getInstance().getEntityManager().find(Usuario.class, cpf);
    if (usuarioExistente != null) {
      JPAUtil.getInstance().getTransaction().begin();
      usuarioExistente.setNome(usuario.getNome());
      JPAUtil.getInstance().getTransaction().commit();
    } else {
      // Usuário não encontrado, ajustar conforme necessário
    }
  }

  // Método para deletar o usuário pelo CPF
  public void deletarUsuario(String cpf) {
    Usuario usuarioExistente = JPAUtil.getInstance().getEntityManager().find(Usuario.class, cpf);
    if (usuarioExistente != null) {
      JPAUtil.getInstance().getTransaction().begin();
      JPAUtil.getInstance().getEntityManager().remove(usuarioExistente);
      JPAUtil.getInstance().getTransaction().commit();
    } else {
      // Usuário não encontrado, ajustar conforme necessário
    }
  }

  // Método para buscar um usuário pelo CPF
  public Usuario buscarUsuario(String cpf) {
    return JPAUtil.getInstance().getEntityManager().find(Usuario.class, cpf);
  }
}
