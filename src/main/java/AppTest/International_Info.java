package AppTest;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

// This class provides the UI panel to display information specific to International applicants.
public class International_Info extends JPanel {

    // Constructor sets up the panel with different text areas for information.
    public International_Info() {
        setLayout(new BorderLayout());

        // Section for "How to Apply" with a non-editable text area.
        JTextArea howToApplyTextArea = new JTextArea();
        howToApplyTextArea.setEditable(false);
        JScrollPane howToApplyScrollPane = new JScrollPane(howToApplyTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\InternationalInfoTextFiles\\International_Apply.txt", howToApplyTextArea);

        // Section for "English Language Requirements" with a non-editable text area.
        JTextArea languageRequirementsTextArea = new JTextArea();
        languageRequirementsTextArea.setEditable(false);
        JScrollPane languageRequirementsScrollPane = new JScrollPane(languageRequirementsTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\InternationalInfoTextFiles\\International_Language_Requirements.txt", languageRequirementsTextArea);

        // Section for "Academic Credentials Required" with a non-editable text area.
        JTextArea academicCredentialsReqTextArea = new JTextArea();
        academicCredentialsReqTextArea.setEditable(false);
        JScrollPane academicCredentialsReqScrollPane = new JScrollPane(academicCredentialsReqTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\InternationalInfoTextFiles\\International_Academic_Credentials_Requirements.txt", academicCredentialsReqTextArea);

        // Section for "Applying for Scholarships & Financial Aid" with a non-editable text area.
        JTextArea applyFinancialAidTextArea = new JTextArea();
        applyFinancialAidTextArea.setEditable(false);
        JScrollPane applyFinancialAidScrollPane = new JScrollPane(applyFinancialAidTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\InternationalInfoTextFiles\\International_Apply_Financial_Aid.txt", applyFinancialAidTextArea);

        // Section for "Admitted!" with a non-editable text area.
        JTextArea admittedNextStepsTextArea = new JTextArea();
        admittedNextStepsTextArea.setEditable(false);
        JScrollPane admittedNextStepsScrollPane = new JScrollPane(admittedNextStepsTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\InternationalInfoTextFiles\\International_Admitted.txt", admittedNextStepsTextArea);

        // Adding all sections to a tabbed pane.
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("How to apply", howToApplyScrollPane);
        tabbedPane.addTab("What are UNT's English Language Requirements?", languageRequirementsScrollPane);
        tabbedPane.addTab("What Academic Credentials are Required?", academicCredentialsReqScrollPane);
        tabbedPane.addTab("How do I apply for Scholarships & Financial Aid?", applyFinancialAidScrollPane);
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
                if (line.contains("How to Apply?") || line.contains("What are UNT's English Language Requirements?") || line.contains("What Academic Credentials are Required?") || line.contains("How do I apply for Scholarships & Financial Aid?") || line.contains("Will I get in?") || line.contains("Admitted!")) {
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

