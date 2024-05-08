import A_CuentaUsuario.Cuenta_Usuario;
import A_CuentaUsuario.Tweet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Main {
    private JPanel panelMain;
    private JButton tweetButton;
    private JTextField tweetTextField;
    private Cuenta_Usuario currentUser;

    public Main(Cuenta_Usuario currentUser) {
        panelMain = new JPanel();
        panelMain.setPreferredSize(new Dimension(800, 500));


        this.currentUser = currentUser;
        tweetButton = new JButton();
        tweetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tweetMessage = tweetTextField.getText();
                if (!tweetMessage.isEmpty()) {
                    Tweet newTweet = new Tweet(tweetMessage, LocalDate.now(), currentUser);
                    currentUser.tweet(newTweet);
                    tweetTextField.setText(""); // Clear the text field after tweeting
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a tweet message.");
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
