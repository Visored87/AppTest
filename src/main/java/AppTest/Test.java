package AppTest;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.MatteBorder;
import java.util.HashMap;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Test extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private HashMap<String, String> userCredentials;

    // Constructor for initializing the login interface
    Test() {
        this.setTitle("Admission Aid");
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(0, 133, 62)); // Set green background
        this.setResizable(false);

        // Initialize user credentials
        userCredentials = new HashMap<>();
        // Add multiple user credentials
        userCredentials.put("jagui87", "J@va17");
        userCredentials.put("htorres6", "Barc@4Ever");

        // Creates the side panel sidePanel
        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(Color.WHITE);
        sidePanel.setPreferredSize(new Dimension(200, 1000));
        sidePanel.setBorder(new MatteBorder(0, 0, 0, 5, new Color(50, 50, 50)));
        this.add(sidePanel, BorderLayout.WEST);

        // Creates the log in panel loginPanel. This is where the JButton, JLabels, etc will be
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(new Color(0, 133, 62)); // used the RGB color from UNT for the background of one of the panels

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Admission Aid Tool");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // Creates the labels for username and password along with customizing the font
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Creates the JTextField usernameField and the JPasswordField passwordField along with customizing the font
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));


        // Creates the log in button and customizing the looks of the button and also adding the Action Listener
        loginButton = new JButton("Log in");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBackground(new Color(100, 149, 237));
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(e -> attemptLogin());

        // Add key listener to password field to handle Enter key press
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    attemptLogin();
                }
            }
        });

        //BorderLayout for the Jpanel for the loginPanel and layout constraints
        constraints.gridx = 0; constraints.gridy = 0; constraints.gridwidth = 2;
        loginPanel.add(titleLabel, constraints);

        constraints.gridwidth = 1; constraints.gridy = 1; constraints.gridx = 0;
        loginPanel.add(usernameLabel, constraints);
        constraints.gridx = 1;
        loginPanel.add(usernameField, constraints);

        constraints.gridy = 2; constraints.gridx = 0;
        loginPanel.add(passwordLabel, constraints);
        constraints.gridx = 1;
        loginPanel.add(passwordField, constraints);

        constraints.gridy = 3; constraints.gridwidth = 2; constraints.gridx = 0;
        loginPanel.add(loginButton, constraints);

        this.add(loginPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    // Method to validate login credentials that are entered by the user
    private void attemptLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            this.dispose(); // Close the login frame
            new Welcome(); // Open the Welcome JFrame
        } else {
            JOptionPane.showMessageDialog(this, "Wrong username/password. Please try again!", "Login Error", JOptionPane.ERROR_MESSAGE);
            // Clear username and password fields
            usernameField.setText("");
            passwordField.setText("");
            usernameField.requestFocus(); // Set focus back to username field
        }
    }
}