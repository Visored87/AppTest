package AppTest;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

// This class provides a UI panel to display information specific to transfer applicants.
public class TransferInfo extends JPanel {
    // Constructor sets up the panel with different text areas for information.
    public TransferInfo() {
        setLayout(new BorderLayout());

        // Section for "How to Apply" with a non-editable text area.
        JTextArea howToApplyTextArea = new JTextArea();
        howToApplyTextArea.setEditable(false);
        JScrollPane howToApplyScrollPane = new JScrollPane(howToApplyTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\TransferInfoTextFiles\\Transfer_Apply.txt", howToApplyTextArea);

        // Section for "Documents Required" tab with a non-editable text area.
        JTextArea documentsRequiredTextArea = new JTextArea();
        documentsRequiredTextArea.setEditable(false);
        JScrollPane documentsRequiredScrollPane = new JScrollPane(documentsRequiredTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\TransferInfoTextFiles\\Transfer_Docs.txt", documentsRequiredTextArea);

        // Section for "Application Status" tab with a non-editable text area.
        JTextArea applicationStatusTextArea = new JTextArea();
        applicationStatusTextArea.setEditable(false);
        JScrollPane applicationStatusScrollPane = new JScrollPane(applicationStatusTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\TransferInfoTextFiles\\Transfer_App_Status.txt", applicationStatusTextArea);

        // Section for "Will I get in?" tab with a non-editable text area.
        JTextArea willIGetInTextArea = new JTextArea();
        willIGetInTextArea.setEditable(false);
        JScrollPane willIGetInScrollPane = new JScrollPane(willIGetInTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\TransferInfoTextFiles\\Transfer_Admission_Decision.txt", willIGetInTextArea);

        // Section for "Admitted!" with a non-editable text area.
        JTextArea admittedNextStepsTextArea = new JTextArea();
        admittedNextStepsTextArea.setEditable(false);
        JScrollPane admittedNextStepsScrollPane = new JScrollPane(admittedNextStepsTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\TransferInfoTextFiles\\Transfer_Admitted.txt", admittedNextStepsTextArea);

        // Adding all sections to a tabbed pane.
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("How to apply", howToApplyScrollPane);
        tabbedPane.addTab("Documents Required for Admission Decision", documentsRequiredScrollPane);
        tabbedPane.addTab("Check Admission Application Status", applicationStatusScrollPane);
        tabbedPane.addTab("Will I get in?", willIGetInScrollPane);
        tabbedPane.addTab("Admitted!", admittedNextStepsScrollPane);

        add(tabbedPane, BorderLayout.CENTER);
    }

    // Helper method to load text from a file into a text area.
    private void loadTextFromFile(String filename, JTextArea textArea) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename, StandardCharsets.UTF_8))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                // Check if the line contains any specific text
                if (line.contains("How to Apply?") || line.contains("Documents Required for Admission Decision") || line.contains("Check Admission Application Status") || line.contains("Will I get in?") || line.contains("Admitted!")) {
                    // Set font size and style for lines containing specific text
                    textArea.append(line + "\n");
                    textArea.setFont(new Font("Arial", Font.BOLD, 16)); // Set font size to 16 and style to bold
                } else {
                    textArea.append(line + "\n");
                }
            }
            textArea.setCaretPosition(0); // Scrolls to the top initially
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

