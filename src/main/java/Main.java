import A_CuentaUsuario.Cuenta_Usuario;
import A_CuentaUsuario.Tweet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Main {
    private JPanel panelMain;
    private JButton tweetButton;
    private JTextField tweetTextField;
    private Cuenta_Usuario currentUser;

    public Main(Cuenta_Usuario currentUser) {
        this.currentUser = currentUser;
        tweetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = tweetTextField.getText();
                try {
                    currentUser.tweet(new Tweet(message, LocalDate.now(), currentUser));
                    JOptionPane.showMessageDialog(null, "Tweet posted successfully");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        // Assume currentUser is already defined
        Cuenta_Usuario currentUser = new Cuenta_Usuario("alias", "email@example.com");

        JFrame frame = new JFrame("TwitterGUI");
        frame.setContentPane(new Main(currentUser).panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}