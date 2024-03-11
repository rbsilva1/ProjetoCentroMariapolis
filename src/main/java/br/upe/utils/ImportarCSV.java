package br.upe.utils;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.upe.models.Usuario;
import javafx.stage.FileChooser;

public class ImportarCSV {
  public static List<Usuario> ImportarCSVUsuario() throws Exception {
    FileChooser fileChooser = new FileChooser();
    File selectedFile = fileChooser.showOpenDialog(null);
    String line = "";
    List<Usuario> usuarios = new ArrayList<Usuario>();
    BufferedReader br = new BufferedReader(new java.io.FileReader(selectedFile));
    while ((line = br.readLine()) != null) {
      String[] values = line.split(",");
      Usuario usuario = new Usuario(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]),
          Integer.parseInt(values[4]), values[5]);
      usuarios.add(usuario);
    }
    br.close();

    return usuarios;
  }

  // public static List<Evento> ImportarCSVEvento() throws Exception {
  // FileChooser fileChooser = new FileChooser();
  // File selectedFile = fileChooser.showOpenDialog(null);
  // String line = "";
  // List<Evento> eventos = new ArrayList<Evento>();
  // BufferedReader br = new BufferedReader(new java.io.FileReader(selectedFile));
  // while ((line = br.readLine()) != null) {
  // String[] values = line.split(",");
  // Evento evento = new Evento(values[0], values[1], values[2], values[3]);
  // eventos.add(evento);
  // }
  // br.close();

  // return eventos;
  // }
}
