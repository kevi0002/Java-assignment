# Java-assignment
  package emergencyservicesdirectory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmergencyServicesDirectory extends JFrame {
    private JTable table;
    private JTextField searchField;

    public EmergencyServicesDirectory() {
        // Set up the frame
        setTitle("Emergency Services Directory");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Search Bar
        JPanel searchPanel = new JPanel(new BorderLayout());
        JLabel searchLabel = new JLabel("Search: ");
        searchField = new JTextField();
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchServices(searchField.getText());
            }
        });
        searchPanel.add(searchLabel, BorderLayout.WEST);
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);
        add(searchPanel, BorderLayout.NORTH);

        // Table for displaying services
        String[] columnNames = {"Name", "Category", "Region", "Contact"};
        table = new JTable(new DefaultTableModel(columnNames, 0));
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Populate the table with data
        loadServices();
    }

    private void loadServices() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear previous data

        // Data for emergency services (covering all regions of Tanzania)
        Object[][] services = {
            {"Dar es Salaam Police", "Police", "Dar es Salaam", "112"},
            {"Mwanza Fire Department", "Fire", "Mwanza", "114"},
            {"Kilimanjaro Hospital", "Hospital", "Kilimanjaro", "0800123456"},
            {"Mbeya Regional Police", "Police", "Mbeya", "112"},
            {"Dodoma Fire Station", "Fire", "Dodoma", "114"},
            {"Morogoro General Hospital", "Hospital", "Morogoro", "0800654321"},
            {"Arusha Police Station", "Police", "Arusha", "112"},
            {"Tanga Fire Brigade", "Fire", "Tanga", "114"},
            {"Zanzibar Mnazi Mmoja Hospital", "Hospital", "Zanzibar", "0800765432"},
            {"Tabora Central Police", "Police", "Tabora", "112"},
            {"Iringa Fire Services", "Fire", "Iringa", "114"},
            {"Lindi District Hospital", "Hospital", "Lindi", "0800987654"},
            {"Mtwara Police Station", "Police", "Mtwara", "112"},
            {"Shinyanga Fire Station", "Fire", "Shinyanga", "114"},
            {"Singida Regional Hospital", "Hospital", "Singida", "0800112233"}
        };

        // Populate the table
        for (Object[] service : services) {
            model.addRow(service);
        }
    }

    private void searchServices(String query) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear previous results

        // Data for emergency services (same as in loadServices method)
        Object[][] services = {
            {"Dar es Salaam Police", "Police", "Dar es Salaam", "112"},
            {"Mwanza Fire Department", "Fire", "Mwanza", "114"},
            {"Kilimanjaro Hospital", "Hospital", "Kilimanjaro", "0800123456"},
            {"Mbeya Regional Police", "Police", "Mbeya", "112"},
            {"Dodoma Fire Station", "Fire", "Dodoma", "114"},
            {"Morogoro General Hospital", "Hospital", "Morogoro", "0800654321"},
            {"Arusha Police Station", "Police", "Arusha", "112"},
            {"Tanga Fire Brigade", "Fire", "Tanga", "114"},
            {"Zanzibar Mnazi Mmoja Hospital", "Hospital", "Zanzibar", "0800765432"},
            {"Tabora Central Police", "Police", "Tabora", "112"},
            {"Iringa Fire Services", "Fire", "Iringa", "114"},
            {"Lindi District Hospital", "Hospital", "Lindi", "0800987654"},
            {"Mtwara Police Station", "Police", "Mtwara", "112"},
            {"Shinyanga Fire Station", "Fire", "Shinyanga", "114"},
            {"Singida Regional Hospital", "Hospital", "Singida", "0800112233"}
        };

        // Filter services based on the search query
        for (Object[] service : services) {
            if (service[0].toString().toLowerCase().contains(query.toLowerCase())
                    || service[1].toString().toLowerCase().contains(query.toLowerCase())
                    || service[2].toString().toLowerCase().contains(query.toLowerCase())) {
                model.addRow(service);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmergencyServicesDirectory app = new EmergencyServicesDirectory();
            app.setVisible(true);
        });
    }
}
