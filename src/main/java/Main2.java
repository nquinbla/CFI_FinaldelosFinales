import A_CuentaUsuario.Cuenta_Usuario;
import A_CuentaUsuario.Tweet;
import A_CuentaUsuario.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class Main2 {
    private static List<Cuenta_Usuario> usuarios = new ArrayList<>();
    private static Cuenta_Usuario currentUser;

    public static void main(String[] args) {
        cargarUsuarios();

        JFrame frame = new JFrame("Twitter GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        JPanel topPanel = new JPanel();
        JTextField userText = new JTextField(20);
        JButton loadUserButton = new JButton("Cargar usuario");
        JButton sortButton = new JButton("Ordenar usuarios por email");
        topPanel.add(userText);
        topPanel.add(loadUserButton);
        topPanel.add(sortButton);
        panel.add(topPanel, BorderLayout.NORTH);

        JTextArea resultArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        JTextField tweetText = new JTextField(20);
        JButton tweetButton = new JButton("Publicar tweet");
        bottomPanel.add(tweetText);
        bottomPanel.add(tweetButton);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        loadUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String alias = userText.getText();
                currentUser = buscarUsuario(alias);
                if (currentUser == null) {
                    resultArea.append("Usuario no encontrado\n");
                } else {
                    resultArea.append("Usuario cargado: " + currentUser + "\n");
                }
            }
        });

        tweetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentUser == null) {
                    resultArea.append("No hay un usuario cargado\n");
                } else {
                    String mensaje = tweetText.getText();
                    try {
                        Tweet tweet = new Tweet(mensaje, LocalDate.now(), currentUser);
                        currentUser.tweet(tweet);
                        resultArea.append("Tweet publicado\n");
                    } catch (IllegalArgumentException ex) {
                        resultArea.append("Error: " + ex.getMessage() + "\n");
                    }
                }
            }
        });

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarUsuariosPorEmail();
                resultArea.append("Usuarios ordenados por email:\n");
                for (Cuenta_Usuario usuario : usuarios) {
                    resultArea.append(usuario + "\n");
                }
            }
        });
    }

    private static void cargarUsuarios() {
        try {
            Scanner scanner = new Scanner(new File("usuarios.txt"));
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");
                String alias = partes[0];
                String email = partes[1];
                usuarios.add(new Cuenta_Usuario(alias, email));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }
    }

    private static Cuenta_Usuario buscarUsuario(String alias) {
        for (Cuenta_Usuario usuario : usuarios) {
            if (usuario.getAlias().equals(alias)) {
                return usuario;
            }
        }
        return null;
    }

    private static void ordenarUsuariosPorEmail() {
        usuarios.sort(Comparator.comparing(Cuenta_Usuario::getEmail));
    }
}