package ubuntusure.ui;

import ubuntusure.dao.CustomerDao;
import ubuntusure.dao.ReportDao;
import ubuntusure.model.*;
import ubuntusure.service.CustomerService;
import ubuntusure.util.CsvExporter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.nio.file.Path;
import java.util.List;

public class DashboardFrame extends JFrame {
    private final String username;
    private final UserRole role;
    private final CustomerDao customerDao = new CustomerDao();
    private final CustomerService customerService = new CustomerService();
    private final JTable customers = new JTable();
    private final JLabel status = new JLabel("Ready");

    public DashboardFrame(String username, UserRole role) {
        this.username = username; this.role = role;
        setTitle("UbuntuSure Insurance Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE); setSize(1000, 650); setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel header = new JPanel(new BorderLayout());
        header.setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));
        JLabel title = new JLabel("UbuntuSure Insurance Management System");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 20f));
        header.add(title, BorderLayout.WEST);
        header.add(new JLabel("Signed in: " + username + " | " + role), BorderLayout.EAST);
        add(header, BorderLayout.NORTH);
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Overview", overview());
        if (role != UserRole.CLAIMS_OFFICER) tabs.addTab("Customers", customerPanel());
        if (role == UserRole.CLAIMS_OFFICER || role == UserRole.ADMINISTRATOR)
            tabs.addTab("Claims", placeholder("Claim queue and assessment workflow will be implemented in the next build phase."));
        if (role == UserRole.INSURANCE_OFFICER || role == UserRole.ADMINISTRATOR)
            tabs.addTab("Policies", placeholder("Policy creation, product-specific details and status management will be implemented in the next build phase."));
        if (role == UserRole.ADMINISTRATOR)
            tabs.addTab("Users", placeholder("Administrator user management will be implemented in a later build phase."));
        tabs.addTab("Reports", reportsPanel());
        add(tabs, BorderLayout.CENTER);
        status.setBorder(BorderFactory.createEmptyBorder(5, 12, 5, 12));
        add(status, BorderLayout.SOUTH);
    }

    private JPanel overview() {
        JPanel panel = new JPanel(new BorderLayout(12, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));
        JLabel intro = new JLabel("Manage customers, policies, claims and management information.");
        intro.setFont(intro.getFont().deriveFont(16f)); panel.add(intro, BorderLayout.NORTH);
        JTextArea notes = new JTextArea("Project baseline\n\n- Role-aware sign-in\n- Customer registration and listing\n- CSV export foundations for customers, policies and claims\n- Product policy model with polymorphic premium calculations\n- MySQL schema and demonstration records included\n\nRemaining screens will be built incrementally against the assessment rubric.");
        notes.setEditable(false); notes.setOpaque(false); panel.add(notes, BorderLayout.CENTER);
        return panel;
    }

    private JPanel placeholder(String message) {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea area = new JTextArea(message); area.setEditable(false); area.setLineWrap(true); area.setWrapStyleWord(true);
        area.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24)); panel.add(area, BorderLayout.NORTH); return panel;
    }

    private JPanel customerPanel() {
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton refresh = new JButton("Refresh customers"), add = new JButton("Register customer");
        actions.add(refresh); actions.add(add); panel.add(actions, BorderLayout.NORTH);
        customers.setModel(new DefaultTableModel(new Object[]{"ID", "First name", "Surname", "National ID", "Phone", "Email"}, 0));
        panel.add(new JScrollPane(customers), BorderLayout.CENTER);
        refresh.addActionListener(e -> loadCustomers()); add.addActionListener(e -> registerCustomer());
        loadCustomers(); return panel;
    }

    private void loadCustomers() {
        try {
            var rows = customerDao.findAll(); DefaultTableModel model = (DefaultTableModel) customers.getModel(); model.setRowCount(0);
            for (Customer c : rows) model.addRow(new Object[]{c.id(), c.firstName(), c.surname(), c.nationalId(), c.phone(), c.email()});
            status.setText("Loaded " + rows.size() + " customers.");
        } catch (Exception ex) { showError(ex); }
    }

    private void registerCustomer() {
        JTextField first = new JTextField(), surname = new JTextField(), nid = new JTextField(), dob = new JTextField();
        JTextField gender = new JTextField(), phone = new JTextField(), email = new JTextField(), address = new JTextField();
        Object[] fields = {"First name *", first, "Surname *", surname, "National ID/passport *", nid,
            "Date of birth (YYYY-MM-DD)", dob, "Gender", gender, "Phone *", phone, "Email", email, "Physical address", address};
        int result = JOptionPane.showConfirmDialog(this, fields, "Register customer", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result != JOptionPane.OK_OPTION) return;
        try {
            int id = customerService.register(first.getText(), surname.getText(), nid.getText(), dob.getText(), gender.getText(), phone.getText(), email.getText(), address.getText());
            JOptionPane.showMessageDialog(this, "Customer registered successfully. Customer ID: " + id);
            loadCustomers();
        } catch (Exception ex) { showError(ex); }
    }

    private JPanel reportsPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        addReportButton(panel, "Customer directory (CSV)", "customers.csv", 0);
        addReportButton(panel, "Policy register (CSV)", "policies.csv", 1);
        addReportButton(panel, "Claims register (CSV)", "claims.csv", 2);
        return panel;
    }

    private void addReportButton(JPanel panel, String label, String filename, int type) {
        JButton button = new JButton("Export " + label); panel.add(button);
        button.addActionListener(e -> {
            try {
                ReportDao dao = new ReportDao();
                List<String[]> rows = switch (type) { case 0 -> dao.customerRows(); case 1 -> dao.policyRows(); default -> dao.claimRows(); };
                Path path = Path.of(System.getProperty("user.home"), "Desktop", filename);
                if (!java.nio.file.Files.isDirectory(path.getParent())) path = Path.of(System.getProperty("user.home"), filename);
                CsvExporter.write(path, rows);
                JOptionPane.showMessageDialog(this, "Report exported to:\n" + path);
                status.setText("Exported " + filename);
            } catch (Exception ex) { showError(ex); }
        });
    }

    private void showError(Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage() == null ? ex.toString() : ex.getMessage(), "Operation failed", JOptionPane.ERROR_MESSAGE);
        status.setText("Operation failed.");
    }
}
