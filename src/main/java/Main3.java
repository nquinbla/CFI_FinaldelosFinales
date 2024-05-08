import A_CuentaUsuario.Cuenta_Usuario;
import A_CuentaUsuario.Tweet;
import A_CuentaUsuario.Utils;
import B_Decoración.decoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class Main3 {
    private static List<Cuenta_Usuario> usuarios = new ArrayList<>();
    private static Cuenta_Usuario currentUser;

    public static void main(String[] args) {
        cargarUsuarios();

        JFrame frame = new JFrame("Twitter: Inicio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.add(createButtonPanel(), BorderLayout.WEST);

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

    private static JPanel createButtonPanel() {
        JPanel imageButtonPanel = new JPanel();
        imageButtonPanel.setLayout(new BoxLayout(imageButtonPanel, BoxLayout.Y_AXIS));
        imageButtonPanel.setBackground(Color.GRAY);

        // Cargar las imágenes
        ImageIcon icon1 = new ImageIcon(new ImageIcon("src/main/resources/hogar.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon icon2 = new ImageIcon(new ImageIcon("src/main/resources/campana.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon icon3 = new ImageIcon(new ImageIcon("src/main/resources/sobre.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon icon4 = new ImageIcon(new ImageIcon("src/main/resources/usuario.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

        JButton button1 = new JButton(icon1); // botón de inicio
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Ya te encuentras en la página de inicio");
            }
        });

        JButton button2 = new JButton(icon2); // botón de notificaciones
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame notificationsFrame = new JFrame("Notificaciones");
                notificationsFrame.setSize(300, 200);
                notificationsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                notificationsFrame.add(createButtonPanel(), BorderLayout.WEST);
                notificationsFrame.setVisible(true);
            }
        });

        JButton button3 = new JButton(icon3); // botón de mensajes
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame messagesFrame = new JFrame("Mensajes");
                messagesFrame.setSize(300, 200);
                messagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                messagesFrame.add(createButtonPanel(), BorderLayout.WEST);
                messagesFrame.setVisible(true);
            }
        });

        JButton button4 = new JButton(icon4); // botón de perfil
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame profileFrame = new JFrame("Perfil");
                profileFrame.setSize(300, 200);
                profileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                profileFrame.add(createButtonPanel(), BorderLayout.WEST);
                profileFrame.setVisible(true);
            }
        });

        imageButtonPanel.add(button1);
        imageButtonPanel.add(button2);
        imageButtonPanel.add(button3);
        imageButtonPanel.add(button4);

        return imageButtonPanel;
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