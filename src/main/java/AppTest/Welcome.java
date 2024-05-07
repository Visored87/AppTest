package AppTest;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.MatteBorder;

public class Welcome extends JFrame {
    private JPanel contentPanel;

    Welcome() {
        this.setTitle("Welcome");
        this.setSize(1600, 1000); // Set the size to match the Test.java JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout()); // Use BorderLayout
        this.getContentPane().setBackground(new Color(0, 133, 62)); // Set green background

        // Add side panel
        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(Color.WHITE);
        sidePanel.setPreferredSize(new Dimension(200, 1000));
        sidePanel.setBorder(new MatteBorder(0, 0, 0, 5, new Color(50, 50, 50)));
        sidePanel.setLayout(new GridLayout(4, 1, 10, 10)); // Set GridLayout with 4 rows and 1 column
        this.add(sidePanel, BorderLayout.WEST);

        // Add buttons to the side panel
        JButton freshmenButton = new JButton("Freshmen");
        JButton transferButton = new JButton("Transfer");
        JButton internationalButton = new JButton("International");
        JButton graduateButton = new JButton("Graduate");

        freshmenButton.setFont(new Font("Arial", Font.BOLD, 14));
        transferButton.setFont(new Font("Arial", Font.BOLD, 14));
        internationalButton.setFont(new Font("Arial", Font.BOLD, 14));
        graduateButton.setFont(new Font("Arial", Font.BOLD, 14));

        freshmenButton.addActionListener(e -> {
            updateContent(new FreshmenInfo());
        });
        transferButton.addActionListener(e -> {
            updateContent(new TransferInfo());
        });
        internationalButton.addActionListener(e -> {
            updateContent(new International_Info());
        });
        graduateButton.addActionListener(e -> {
            updateContent(new GraduateInfo());
        });

        sidePanel.add(freshmenButton);
        sidePanel.add(transferButton);
        sidePanel.add(internationalButton);
        sidePanel.add(graduateButton);

        // Initialize content panel
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Add content panel to the main frame
        this.add(contentPanel, BorderLayout.CENTER);

        // Add components or customize the welcome screen as needed
        JLabel welcomeLabel = new JLabel("Welcome to the Application!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.WHITE);
        this.add(welcomeLabel, BorderLayout.NORTH);

        this.setVisible(true);
    }

    private void updateContent(JPanel panel) {
        // Update the content panel with the specified panel
        contentPanel.removeAll();
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args) {
        // Launch the application
        SwingUtilities.invokeLater(() -> new Welcome());
    }
}
