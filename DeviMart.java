import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class DeviMart extends JFrame {
    private static final String FILE_NAME = "devi_mart_users.dat";
        private Map<String, User> users = new HashMap<>();
    private final Color RED = new Color(200, 0, 0);
    private final Color DARK_RED = new Color(120, 0, 0);
    private final Color WHITE = Color.WHITE;
    public DeviMart() {
        loadUsers();
        showLoginPage();
    }
    static class User implements Serializable {
        String name;
        String email;
        String phone;
        String password;
        User(String name, String email, String phone, String password) {
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.password = password;
        }
    }
    private void showLoginPage() {
        getContentPane().removeAll();
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(RED);
          mainPanel.setLayout(new GridBagLayout());
        JPanel box = new JPanel();
        box.setBackground(WHITE);
        box.setPreferredSize(new Dimension(420, 430));
        box.setLayout(null);
            JLabel title = new JLabel("DEVI MART", SwingConstants.CENTER);
        title.setBounds(40, 25, 340, 50);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(RED);
        JLabel subtitle = new JLabel("LOGIN", SwingConstants.CENTER);
        subtitle.setBounds(50, 80, 320, 30);
        subtitle.setFont(new Font("Arial", Font.BOLD, 20));
        subtitle.setForeground(DARK_RED);
        JLabel emailLabel = new JLabel("Email / Phone");
            emailLabel.setBounds(50, 125, 300, 25);
        JTextField emailField = new JTextField();
        emailField.setBounds(50, 150, 320, 40);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 200, 300, 25);
           JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(50, 225, 320, 40);
        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(50, 285, 150, 45);
        loginButton.setBackground(RED);
        loginButton.setForeground(WHITE);
            loginButton.setFont(new Font("Arial", Font.BOLD, 15));
        JButton registerButton = new JButton("NEW REGISTRATION");
        registerButton.setBounds(210, 285, 160, 45);
        registerButton.setBackground(DARK_RED);
        registerButton.setForeground(WHITE);
        registerButton.setFont(new Font("Arial", Font.BOLD, 12));
        JLabel message = new JLabel("", SwingConstants.CENTER);
        message.setBounds(40, 345, 340, 40);
        message.setForeground(RED);
        loginButton.addActionListener(e -> {
            String input = emailField.getText().trim();
            String password = new String(passwordField.getPassword());
            User foundUser = null;
            for (User user : users.values()) {
                if ((user.email.equalsIgnoreCase(input)
                        || user.phone.equals(input))
                        && user.password.equals(password)) {
                    foundUser = user;
                    break;
                }
            }
            if (foundUser != null) {

                JOptionPane.showMessageDialog(
                        this,
                        "✅ LOGIN SUCCESSFUL!\n\n"
                        + "Welcome " + foundUser.name,
                        "DEVI MART",
                        JOptionPane.INFORMATION_MESSAGE
                );
                showHomePage(foundUser);

            } else {
                message.setText("❌ Invalid Email/Phone or Password!");
            }
        });
        registerButton.addActionListener(e -> {
            showRegistrationPage();
        });
        box.add(title);
        box.add(subtitle);
        box.add(emailLabel);
        box.add(emailField);
        box.add(passwordLabel);
        box.add(passwordField);
        box.add(loginButton);
        box.add(registerButton);
        box.add(message);
        mainPanel.add(box);
        add(mainPanel);
        setTitle("DEVI MART - Login");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        revalidate();
        repaint();
    }
    private void showRegistrationPage() {
        getContentPane().removeAll();
            JPanel mainPanel = new JPanel();
        mainPanel.setBackground(RED);
        mainPanel.setLayout(new GridBagLayout());
             JPanel box = new JPanel();
        box.setBackground(WHITE);
        box.setPreferredSize(new Dimension(450, 520));
        box.setLayout(null);
        JLabel title = new JLabel("DEVI MART", SwingConstants.CENTER);
        title.setBounds(40, 20, 370, 45);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(RED);
        JLabel subtitle = new JLabel(
                "NEW REGISTRATION",
                SwingConstants.CENTER
        );
        subtitle.setBounds(40, 65, 370, 30);
        subtitle.setFont(new Font("Arial", Font.BOLD, 18));
        subtitle.setForeground(DARK_RED);
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 105, 300, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(50, 130, 350, 35);
        JLabel emailLabel = new JLabel("Email ID");
        emailLabel.setBounds(50, 170, 300, 25);
        JTextField emailField = new JTextField();
        emailField.setBounds(50, 195, 350, 35);
        JLabel phoneLabel = new JLabel("Phone Number");
        phoneLabel.setBounds(50, 235, 300, 25);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(50, 260, 350, 35);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 300, 300, 25);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(50, 325, 350, 35);
        JButton registerButton = new JButton("REGISTER");
        registerButton.setBounds(50, 380, 165, 45);
        registerButton.setBackground(RED);
        registerButton.setForeground(WHITE);
        registerButton.setFont(new Font("Arial", Font.BOLD, 15));
        JButton backButton = new JButton("BACK TO LOGIN");
        backButton.setBounds(235, 380, 165, 45);
        backButton.setBackground(DARK_RED);
        backButton.setForeground(WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 13));
        JLabel message = new JLabel("", SwingConstants.CENTER);
        message.setBounds(30, 435, 390, 35);
        registerButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();
            String password = new String(passwordField.getPassword());
            if (name.isEmpty()
                    || email.isEmpty()
                    || phone.isEmpty()
                    || password.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "⚠️ Please fill all details!",
                        "DEVI MART",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            if (users.containsKey(email.toLowerCase())) {
                JOptionPane.showMessageDialog(
                        this,
                        "❌ Email already registered!",
                        "DEVI MART",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            User newUser =
                    new User(name, email, phone, password);

            users.put(email.toLowerCase(), newUser);
            saveUsers();
            JOptionPane.showMessageDialog(
                    this,
                    "✅ REGISTRATION SUCCESSFUL!\n\n"
                    + "Welcome to DEVI MART, " + name,
                    "DEVI MART",
                    JOptionPane.INFORMATION_MESSAGE
            );
            showLoginPage();
        });
        backButton.addActionListener(e -> {
            showLoginPage();
        });
        box.add(title);
        box.add(subtitle);
        box.add(nameLabel);
        box.add(nameField);
        box.add(emailLabel);
        box.add(emailField);
        box.add(phoneLabel);
        box.add(phoneField);
        box.add(passwordLabel);
        box.add(passwordField);
        box.add(registerButton);
        box.add(backButton);
        box.add(message);
        mainPanel.add(box);
        add(mainPanel);
        setTitle("DEVI MART - Registration");
        revalidate();
        repaint();
    }
    private void showHomePage(User user) {
        getContentPane().removeAll();
        JPanel panel = new JPanel();
        panel.setBackground(RED);
        panel.setLayout(new BorderLayout());
        JLabel title = new JLabel(
                "WELCOME TO DEVI MART",
                SwingConstants.CENTER
        );
        title.setForeground(WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        JLabel details = new JLabel(
                "<html><center>"
                + "Hello, " + user.name
                + "<br><br>"
                + "Email: " + user.email
                + "<br>"
                + "Phone: " + user.phone
                + "</center></html>",
                SwingConstants.CENTER
        );
        details.setForeground(WHITE);
        details.setFont(new Font("Arial", Font.PLAIN, 18));
        JButton logoutButton = new JButton("LOGOUT");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.setBackground(WHITE);
        logoutButton.setForeground(RED);
        logoutButton.addActionListener(e -> {
            showLoginPage();
        });
        panel.add(title, BorderLayout.NORTH);
        panel.add(details, BorderLayout.CENTER);
        panel.add(logoutButton, BorderLayout.SOUTH);
        add(panel);
        setTitle("DEVI MART");
        revalidate();
        repaint();
    }
    private void saveUsers() {
        try (ObjectOutputStream output =
                     new ObjectOutputStream(
                             new FileOutputStream(FILE_NAME))) {
            output.writeObject(users);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "❌ Error saving user data!"
            );
        }
    }
    @SuppressWarnings("unchecked")
    private void loadUsers() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }
        try (ObjectInputStream input =
                     new ObjectInputStream(
                             new FileInputStream(FILE_NAME))) {
            users = (Map<String, User>) input.readObject();
        } catch (Exception e) {
            users = new HashMap<>();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DeviMart();
        });
    }
}