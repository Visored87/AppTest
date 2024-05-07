package AppTest;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

// This class provides the UI panel to display information specific to freshmen applicants.
public class FreshmenInfo extends JPanel {

    // Constructor for FreshmenInfo, sets up the panel with various text areas.
    public FreshmenInfo() {
        setLayout(new BorderLayout());

        // Creates a text area for how to apply information, makes it non-editable.
        JTextArea howToApplyTextArea = new JTextArea();
        howToApplyTextArea.setEditable(false);
        JScrollPane howToApplyScrollPane = new JScrollPane(howToApplyTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\FreshmenInfoTextFiles\\Freshmen_Apply.txt", howToApplyTextArea);

        // Creates a text area for documents required information, makes it non-editable.
        JTextArea documentsRequiredTextArea = new JTextArea();
        documentsRequiredTextArea.setEditable(false);
        JScrollPane documentsRequiredScrollPane = new JScrollPane(documentsRequiredTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\FreshmenInfoTextFiles\\Freshmen_Docs.txt", documentsRequiredTextArea);

        // Creates a text area for application status information, makes it non-editable.
        JTextArea applicationStatusTextArea = new JTextArea();
        applicationStatusTextArea.setEditable(false);
        JScrollPane applicationStatusScrollPane = new JScrollPane(applicationStatusTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\FreshmenInfoTextFiles\\Freshmen_App_Status.txt", applicationStatusTextArea);

        // Creates a text area for admission decision information, makes it non-editable.
        JTextArea willIGetInTextArea = new JTextArea();
        willIGetInTextArea.setEditable(false);
        JScrollPane willIGetInScrollPane = new JScrollPane(willIGetInTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\FreshmenInfoTextFiles\\Freshmen_Admission_Decision.txt", willIGetInTextArea);

        // Creates a text area for admitted freshmen information, makes it non-editable.
        JTextArea admittedNextStepsTextArea = new JTextArea();
        admittedNextStepsTextArea.setEditable(false);
        JScrollPane admittedNextStepsScrollPane = new JScrollPane(admittedNextStepsTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\FreshmenInfoTextFiles\\Freshmen_Admitted.txt", admittedNextStepsTextArea);

        // Adds tabs for each category of information to a tabbed pane and adds it to the panel.
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("How to apply", howToApplyScrollPane);
        tabbedPane.addTab("Documents Required for Admission Decision", documentsRequiredScrollPane);
        tabbedPane.addTab("Check Admission Application Status", applicationStatusScrollPane);
        tabbedPane.addTab("Will I get in?", willIGetInScrollPane);
        tabbedPane.addTab("Admitted!", admittedNextStepsScrollPane);

        // Adds the tabbed pane to the center of this panel.
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


