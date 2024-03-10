package br.upe.repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import br.upe.models.Usuario;
import static br.upe.utils.CpfValidacao.validarCPF;

public class UsuarioRepositorio {

  private static final EntityManager entityManager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
  private static final EntityTransaction transaction = entityManager.getTransaction();

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
      transaction.begin();
      entityManager.persist(usuario);
      transaction.commit();
    } else {
      // Ajustar para caso não consiga criar o usuário
    }
  }

  // Método para mostrar todos os usuários cadastrados
  public List<Usuario> mostrarUsuarios() {
    TypedQuery<Usuario> query = entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class);
    return query.getResultList();
  }

  // Método para atualizar os dados do usuário pelo CPF
  public void atualizarUsuario(String cpf, Usuario usuario) {
    Usuario usuarioExistente = entityManager.find(Usuario.class, cpf);
    if (usuarioExistente != null) {
      transaction.begin();
      usuarioExistente.setNome(usuario.getNome());
      transaction.commit();
    } else {
      // Usuário não encontrado, ajustar conforme necessário
    }
  }

  // Método para deletar o usuário pelo CPF
  public void deletarUsuario(String cpf) {
    Usuario usuarioExistente = entityManager.find(Usuario.class, cpf);
    if (usuarioExistente != null) {
      transaction.begin();
      entityManager.remove(usuarioExistente);
      transaction.commit();
    } else {
      // Usuário não encontrado, ajustar conforme necessário
    }
  }

  // Método para buscar um usuário pelo CPF
  public Usuario buscarUsuario(String cpf) {
    return entityManager.find(Usuario.class, cpf);
  }
}
