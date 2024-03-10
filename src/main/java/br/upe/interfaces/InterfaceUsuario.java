package br.upe.interfaces;

import java.util.List;

import br.upe.models.Usuario;
import br.upe.repositories.UsuarioRepositorio;

public interface InterfaceUsuario {

    public UsuarioRepositorio getInstance();

    public void criarUsuario(Usuario usuario);

    public List<Usuario> mostrarUsuarios();

    public void atualizarUsuario();

    public void deletarUsuario(String cpf);

    public Usuario buscUsuario(String cpf);
}
