import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainUI {
    private static Village village = new Village();

    private static final Map<String, Integer> unitPopulationCosts = new HashMap<>() {{
        put("lándzsás", 1);
        put("kardforgató", 1);
        put("bárdos", 1);
        put("íjász", 1);
        put("kém", 2);
        put("könnyűlovas", 4);
        put("lovas íjász", 5);
        put("nehézlovas", 6);
        put("faltörő kos", 5);
        put("katapult", 8);
        put("lovag", 10);
        put("főnemes", 100);
        put("milícia", 0);
    }};

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Klánháború Tanyahely Kalkulátor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // --- Épület panel ---
        JPanel buildingPanel = new JPanel(new FlowLayout());

        String[] buildingNames = Building.getSupportedBuildingNames();
        JComboBox<String> buildingDropdown = new JComboBox<>(buildingNames);
        JTextField levelField = new JTextField(5);
        JButton addBuildingButton = new JButton("Épület hozzáadása");

        buildingPanel.add(new JLabel("Épület:"));
        buildingPanel.add(buildingDropdown);
        buildingPanel.add(new JLabel("Szint:"));
        buildingPanel.add(levelField);
        buildingPanel.add(addBuildingButton);

        // --- Egység panel ---
        JPanel unitPanel = new JPanel(new FlowLayout());

        JComboBox<String> unitDropdown = new JComboBox<>(Village.getSupportedUnitNames());
        JTextField unitCountField = new JTextField(5);
        JButton addUnitButton = new JButton("Egység hozzáadása");

        unitPanel.add(new JLabel("Egység:"));
        unitPanel.add(unitDropdown);
        unitPanel.add(new JLabel("Darab:"));
        unitPanel.add(unitCountField);
        unitPanel.add(addUnitButton);

        // --- Kimeneti szövegpanel ---
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // --- Eseménykezelők ---
        addBuildingButton.addActionListener(e -> {
            try {
                String name = (String) buildingDropdown.getSelectedItem();
                int level = Integer.parseInt(levelField.getText());
                village.setBuildingLevel(name, level);
                updateOutput(outputArea, buildingNames);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Érvénytelen szint szám!", "Hiba", JOptionPane.ERROR_MESSAGE);
            }
        });

        addUnitButton.addActionListener(e -> {
            try {
                String name = (String) unitDropdown.getSelectedItem();
                int count = Integer.parseInt(unitCountField.getText());
                int pop = unitPopulationCosts.getOrDefault(name.toLowerCase(), 0);
                village.addUnit(name, count, pop);
                updateOutput(outputArea, buildingNames);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Érvénytelen szám az egységnél!", "Hiba", JOptionPane.ERROR_MESSAGE);
            }
        });

        // --- Összerakás ---
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.add(buildingPanel);
        topPanel.add(unitPanel);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void updateOutput(JTextArea area, String[] buildingOrder) {
        area.setText("");
        village.printOverviewTo(area, buildingOrder);
    }
}
