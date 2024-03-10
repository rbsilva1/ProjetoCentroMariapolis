package br.upe.repositories;

import java.util.List;

import javax.persistence.EntityManager;
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
    EntityManager entityManager = JPAUtil.getEntityManager();

    boolean cpfValido = validarCPF(usuario.getCpf());

    if (cpfValido) {
      entityManager.getTransaction().begin();
      entityManager.persist(usuario);
      entityManager.getTransaction().commit();
    } else {
      // Ajustar para caso não consiga criar o usuário
    }
  }

  // Método para mostrar todos os usuários cadastrados
  public List<Usuario> mostrarUsuarios() {
    EntityManager entityManager = JPAUtil.getEntityManager();

    TypedQuery<Usuario> query = entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class);

    return query.getResultList();
  }

  // Método para atualizar os dados do usuário pelo CPF
  public void atualizarUsuario(String cpf, Usuario usuario) {
    EntityManager entityManager = JPAUtil.getEntityManager();

    Usuario usuarioExistente = entityManager.find(Usuario.class, cpf);
    if (usuarioExistente != null) {
      entityManager.getTransaction().begin();
      usuarioExistente.setNome(usuario.getNome());
      entityManager.getTransaction().commit();
    } else {
      // Usuário não encontrado, ajustar conforme necessário
    }
  }

  // Método para deletar o usuário pelo CPF
  public void deletarUsuario(String cpf) {
    EntityManager entityManager = JPAUtil.getEntityManager();

    Usuario usuarioExistente = entityManager.find(Usuario.class, cpf);
    if (usuarioExistente != null) {
      entityManager.getTransaction().begin();
      entityManager.remove(usuarioExistente);
      entityManager.getTransaction().commit();
    } else {
      // Usuário não encontrado, ajustar conforme necessário
    }
  }

  // Método para buscar um usuário pelo CPF
  public Usuario buscarUsuario(String cpf) {
    EntityManager entityManager = JPAUtil.getEntityManager();

    Usuario usuario = entityManager.find(Usuario.class, cpf);

    return usuario;
  }
}
