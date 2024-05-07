package AppTest;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

// This class provides a UI panel to display information specific to graduate applicants.
public class GraduateInfo extends JPanel {

    // Constructor sets up the panel with different text areas for information.
    public GraduateInfo() {
        setLayout(new BorderLayout());

        // Section for "Before You Apply" with a non-editable text area.
        JTextArea beforeYouApplyTextArea = new JTextArea();
        beforeYouApplyTextArea.setEditable(false);
        JScrollPane beforeYouApplyScrollPane = new JScrollPane(beforeYouApplyTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\GraduateInfoTextFiles\\Graduate_Before_Applying.txt", beforeYouApplyTextArea);

        // Section for "Submit Your Application" with a non-editable text area.
        JTextArea submitYourApplicationTextArea = new JTextArea();
        submitYourApplicationTextArea.setEditable(false);
        JScrollPane submitYourApplicationScrollPane = new JScrollPane(submitYourApplicationTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\GraduateInfoTextFiles\\Graduate_Apply.txt", submitYourApplicationTextArea);

        // Section for "Things to Keep in Mind" with a non-editable text area.
        JTextArea thingsToKeepInMindTextArea = new JTextArea();
        thingsToKeepInMindTextArea.setEditable(false);
        JScrollPane thingsToKeepInMindScrollPane = new JScrollPane(thingsToKeepInMindTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\GraduateInfoTextFiles\\Graduate_Things_To_Keep_in_Mind.txt", thingsToKeepInMindTextArea);

        // Section for "Next Steps After Admission" with a non-editable text area.
        JTextArea admittedNextStepsTextArea = new JTextArea();
        admittedNextStepsTextArea.setEditable(false);
        JScrollPane admittedNextStepsScrollPane = new JScrollPane(admittedNextStepsTextArea);
        loadTextFromFile("C:\\Users\\VisoredFPS\\Desktop\\Admission Application Files-IS 4543\\AppTest\\src\\main\\java\\AppTest\\GraduateInfoTextFiles\\Graduate_Admitted.txt", admittedNextStepsTextArea);

        // Adding all sections to a JTabbedPane tabbedPane.
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Before You Apply", beforeYouApplyScrollPane);
        tabbedPane.addTab("Submit Your Application", submitYourApplicationScrollPane);
        tabbedPane.addTab("Things To Keep In Mind", thingsToKeepInMindScrollPane);
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
                if (line.contains("Before You Apply") || line.contains("Submit Your Application") || line.contains("Things To Keep In Mind") || line.contains("Admitted!")) {
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