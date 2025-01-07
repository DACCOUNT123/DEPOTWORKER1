import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerMVC extends JFrame {
    private QueueofCustomers queueOfCustomers;
    private ParcelMap parcelMap;
    private Worker worker;
    private Log log;

    private JTextArea statusArea;

    public ManagerMVC() {
        queueOfCustomers = new QueueofCustomers();
        parcelMap = new ParcelMap();
        worker = new Worker(queueOfCustomers, parcelMap);
        log = Log.getInstance();

        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("Parcel Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu Panel
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(7, 1));

        JButton addCustomerButton = new JButton("Add Customer");
        JButton addParcelButton = new JButton("Add Parcel");
        JButton showCustomersButton = new JButton("Show Customers");
        JButton showParcelsButton = new JButton("Show Parcels");
        JButton processCustomerButton = new JButton("Process Next Customer");
        JButton showStatusButton = new JButton("Show Status");
        JButton exitButton = new JButton("Exit");

        menuPanel.add(addCustomerButton);
        menuPanel.add(addParcelButton);
        menuPanel.add(showCustomersButton);
        menuPanel.add(showParcelsButton);
        menuPanel.add(processCustomerButton);
        menuPanel.add(showStatusButton);
        menuPanel.add(exitButton);

        // Status Panel
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BorderLayout());

        JLabel statusLabel = new JLabel("Status:");
        statusArea = new JTextArea();
        statusArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(statusArea);

        statusPanel.add(statusLabel, BorderLayout.NORTH);
        statusPanel.add(scrollPane, BorderLayout.CENTER);

        add(menuPanel, BorderLayout.WEST);
        add(statusPanel, BorderLayout.CENTER);

        // Event Listeners
        addCustomerButton.addActionListener(e -> addCustomer());
        addParcelButton.addActionListener(e -> addParcel());
        showCustomersButton.addActionListener(e -> showCustomers());
        showParcelsButton.addActionListener(e -> showParcels());
        processCustomerButton.addActionListener(e -> processNextCustomer());
        showStatusButton.addActionListener(e -> showStatus());
        exitButton.addActionListener(e -> exitSystem());
    }

    private void addCustomer() {
        String customerId = JOptionPane.showInputDialog(this, "Enter Customer ID:");
        String name = JOptionPane.showInputDialog(this, "Enter Customer Name:");
        String address = JOptionPane.showInputDialog(this, "Enter Customer Address:");

        if (customerId != null && name != null && address != null) {
            Customer customer = new Customer(customerId, name, address);
            queueOfCustomers.addCustomer(customer);
            log.logEvent("Added customer: " + customer.getCustomerDetails());
            statusArea.append("Customer added successfully.\n");
        }
    }

    private void addParcel() {
        String parcelId = JOptionPane.showInputDialog(this, "Enter Parcel ID:");
        String weightInput = JOptionPane.showInputDialog(this, "Enter Parcel Weight:");
        String destination = JOptionPane.showInputDialog(this, "Enter Parcel Destination:");
        String customerId = JOptionPane.showInputDialog(this, "Enter Customer ID:");

        if (parcelId != null && weightInput != null && destination != null && customerId != null) {
            try {
                double weight = Double.parseDouble(weightInput);
                Parcel parcel = new Parcel(parcelId, weight, destination, customerId);
                parcelMap.addParcel(parcel);
                log.logEvent("Added parcel: " + parcel.getParcelDetails());
                statusArea.append("Parcel added successfully.\n");
            } catch (NumberFormatException ex) {
                statusArea.append("Invalid weight entered.\n");
            }
        }
    }

    private void showCustomers() {
        statusArea.append("\nList of Customers:\n");
        for (Customer customer : queueOfCustomers.getAllCustomers()) {
            statusArea.append(customer.getCustomerDetails() + "\n");
        }
    }

    private void showParcels() {
        statusArea.append("\nList of Parcels:\n");
        for (Parcel parcel : parcelMap.getAllParcels()) {
            statusArea.append(parcel.getParcelDetails() + "\n");
        }
    }

    private void processNextCustomer() {
        statusArea.append("\nProcessing next customer...\n");
        statusArea.append(worker.processCustomer());
    }

    private void showStatus() {
        statusArea.append("\nSystem Log:\n");
        statusArea.append(log.displayLog());
    }

    private void exitSystem() {
        log.logEvent("System exited.");
        log.writeLogToFile("system_log.txt");
        JOptionPane.showMessageDialog(this, "Exiting. Log saved to system_log.txt.");
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ManagerMVC manager = new ManagerMVC();
            manager.setVisible(true);
        });
    }
}
