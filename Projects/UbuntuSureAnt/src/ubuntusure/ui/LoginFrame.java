package ubuntusure.ui;

import ubuntusure.dao.UserDao;
import ubuntusure.model.UserRole;
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private final JTextField username = new JTextField("officer", 18);
    private final JPasswordField password = new JPasswordField("UbuntuDemo123!", 18);

    public LoginFrame() {
        setTitle("UbuntuSure | Sign in");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(440, 250);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(7, 7, 7, 7);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0; g.gridy = 0; panel.add(new JLabel("Username"), g);
        g.gridx = 1; panel.add(username, g);
        g.gridx = 0; g.gridy++; panel.add(new JLabel("Password"), g);
        g.gridx = 1; panel.add(password, g);
        JButton signIn = new JButton("Sign in");
        g.gridx = 1; g.gridy++; panel.add(signIn, g);
        add(panel, BorderLayout.CENTER);
        add(new JLabel("Demo accounts are documented in README.md", SwingConstants.CENTER), BorderLayout.SOUTH);
        signIn.addActionListener(e -> login());
        getRootPane().setDefaultButton(signIn);
    }

    private void login() {
        try {
            UserRole role = new UserDao().authenticate(username.getText().trim(), new String(password.getPassword()));
            if (role == null) {
                JOptionPane.showMessageDialog(this, "Invalid username or password.", "Sign-in failed", JOptionPane.ERROR_MESSAGE);
                return;
            }
            dispose();
            new DashboardFrame(username.getText().trim(), role).setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Could not connect to MySQL. Check the database setup and Connector/J.\n" + ex.getMessage(),
                    "Database connection error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
