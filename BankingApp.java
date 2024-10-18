import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class BankingApp {
    private HashMap<Integer, Account> accounts = new HashMap<>();
    private JFrame frame;
    private JTextField accountField, nameField, ageField, emailField, phoneField;
    private JPasswordField pinField, newPinField;
    private Account currentAccount;
    private int accountCounter = 1748000; // Starting account number

    public static void main(String[] args) {
        new BankingApp().displayHomeScreen();
    }

    public BankingApp() {
        // Preload a sample account
        accounts.put(1001, new Account(1001, "1234", 1000.0, "John Doe", 25, "", ""));
    }

    private void displayHomeScreen() {
        frame = new JFrame("Banking Application - Home");
        frame.setSize(1280, 720); // Changed to a larger resolution
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 248, 255));
        frame.add(panel);
        placeHomeScreenComponents(panel);

        frame.setVisible(true);
    }

    private void placeHomeScreenComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to Banking App");
        welcomeLabel.setBounds(400, 50, 500, 60); // Adjusted dimensions
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Adjusted font size
        welcomeLabel.setForeground(new Color(25, 25, 112));
        panel.add(welcomeLabel);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(540, 150, 200, 50); // Adjusted dimensions
        loginButton.setBackground(new Color(100, 149, 237));
        loginButton.setForeground(Color.WHITE);
        panel.add(loginButton);

        JButton registerButton = new JButton("Create New Account");
        registerButton.setBounds(540, 230, 200, 50); // Adjusted dimensions
        registerButton.setBackground(new Color(100, 149, 237));
        registerButton.setForeground(Color.WHITE);
        panel.add(registerButton);

        loginButton.addActionListener(e -> displayLogin());

        registerButton.addActionListener(e -> displayAccountCreation());
    }

    private void displayLogin() {
        frame.dispose();
        frame = new JFrame("Banking Application - Login");
        frame.setSize(1280, 720); // Adjusted dimensions
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(229,255,204));
        frame.add(panel);
        placeLoginComponents(panel);

        frame.setVisible(true);
    }

    private void placeLoginComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel accountLabel = new JLabel("Account Number:");
        accountLabel.setBounds(300, 150, 200, 40); // Adjusted dimensions
        accountLabel.setFont(new Font("Arial", Font.PLAIN, 24)); // Adjusted font size
        panel.add(accountLabel);

        accountField = new JTextField(20);
        accountField.setBounds(540, 150, 300, 40); // Adjusted dimensions
        panel.add(accountField);

        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setBounds(300, 250, 200, 40); // Adjusted dimensions
        pinLabel.setFont(new Font("Arial", Font.PLAIN, 24)); // Adjusted font size
        panel.add(pinLabel);

        pinField = new JPasswordField(20);
        pinField.setBounds(540, 250, 300, 40); // Adjusted dimensions
        panel.add(pinField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(540, 350, 200, 50); // Adjusted dimensions
        loginButton.setBackground(new Color(60, 179, 113));
        loginButton.setForeground(Color.WHITE);
        panel.add(loginButton);

        loginButton.addActionListener(e -> login());
    }

    private void displayAccountCreation() {
        frame.dispose();
        frame = new JFrame("Banking Application - Create New Account");
        frame.setSize(1280, 720); // Adjusted dimensions
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(250, 250, 210));
        frame.add(panel);
        placeAccountCreationComponents(panel);

        frame.setVisible(true);
    }

    private void placeAccountCreationComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(300, 50, 200, 40); // Adjusted dimensions
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 24)); // Adjusted font size
        panel.add(nameLabel);

        nameField = new JTextField(20);
        nameField.setBounds(540, 50, 300, 40); // Adjusted dimensions
        panel.add(nameField);

        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setBounds(300, 100, 200, 40); // Adjusted dimensions
        pinLabel.setFont(new Font("Arial", Font.PLAIN, 24)); // Adjusted font size
        panel.add(pinLabel);

        newPinField = new JPasswordField(20);
        newPinField.setBounds(540, 100, 300, 40); // Adjusted dimensions
        panel.add(newPinField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(300, 150, 200, 40); // Adjusted dimensions
        ageLabel.setFont(new Font("Arial", Font.PLAIN, 24)); // Adjusted font size
        panel.add(ageLabel);

        ageField = new JTextField(20);
        ageField.setBounds(540, 150, 300, 40); // Adjusted dimensions
        panel.add(ageField);

        JLabel balanceLabel = new JLabel("Initial Deposit:");
        balanceLabel.setBounds(300, 200, 200, 40); // Adjusted dimensions
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 24)); // Adjusted font size
        panel.add(balanceLabel);

        JTextField balanceField = new JTextField(20);
        balanceField.setBounds(540, 200, 300, 40); // Adjusted dimensions
        panel.add(balanceField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(300, 250, 200, 40); // Adjusted dimensions
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 24)); // Adjusted font size
        panel.add(emailLabel);

        emailField = new JTextField(20);
        emailField.setBounds(540, 250, 300, 40); // Adjusted dimensions
        panel.add(emailField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(300, 300, 200, 40); // Adjusted dimensions
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 24)); // Adjusted font size
        panel.add(phoneLabel);

        phoneField = new JTextField(20);
        phoneField.setBounds(540, 300, 300, 40); // Adjusted dimensions
        panel.add(phoneField);

        JButton createButton = new JButton("Create Account");
        createButton.setBounds(540, 380, 200, 50); // Adjusted dimensions
        createButton.setBackground(new Color(65, 105, 225));
        createButton.setForeground(Color.WHITE);
        panel.add(createButton);

        createButton.addActionListener(e -> {
            double initialBalance = Double.parseDouble(balanceField.getText());
            if (initialBalance < 500) {
                JOptionPane.showMessageDialog(frame, "Minimum deposit amount is INR500");
                return;
            }
            int accountNumber = accountCounter++;
            String pin = new String(newPinField.getPassword());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String email = emailField.getText();
            String phone = phoneField.getText();

            accounts.put(accountNumber, new Account(accountNumber, pin, initialBalance, name, age, email, phone));
            JOptionPane.showMessageDialog(frame, "Account created successfully. Your account number is: " + accountNumber);
            frame.dispose();
            displayHomeScreen(); // Return to home screen after creation
        });
    }

    private void login() {
        int accountNumber = Integer.parseInt(accountField.getText());
        String pin = new String(pinField.getPassword());

        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            if (account.verifyPin(pin)) {
                currentAccount = account;
                frame.dispose();
                displayDashboard();
            } else {
                JOptionPane.showMessageDialog(frame, "Incorrect PIN");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Account not found");
        }
    }

    private void displayDashboard() {
        frame = new JFrame("Banking Application - Dashboard");
        frame.setSize(1280, 720); // Adjusted dimensions
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(224, 255, 255));
        frame.add(panel);
        placeDashboardComponents(panel);

        frame.setVisible(true);
    }

    private void placeDashboardComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome, " + currentAccount.getName());
        welcomeLabel.setBounds(400, 50, 500, 40); // Adjusted dimensions
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 32)); // Adjusted font size
        panel.add(welcomeLabel);

        JLabel balanceLabel = new JLabel("Current Balance: INR " + currentAccount.getBalance());
        balanceLabel.setBounds(450, 150, 400, 40); // Adjusted dimensions
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 24)); // Adjusted font size
        panel.add(balanceLabel);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(540, 250, 200, 50); // Adjusted dimensions
        depositButton.setBackground(new Color(100, 149, 237));
        depositButton.setForeground(Color.WHITE);
        panel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(540, 310, 200, 50); // Adjusted dimensions
        withdrawButton.setBackground(new Color(100, 149, 237));
        withdrawButton.setForeground(Color.WHITE);
        panel.add(withdrawButton);

        JButton transferButton = new JButton("Transfer");
        transferButton.setBounds(540, 390, 200, 50); // Adjusted dimensions
        transferButton.setBackground(new Color(100, 149, 237));
        transferButton.setForeground(Color.WHITE);
        panel.add(transferButton);

        JButton transactionHistoryButton = new JButton("Transaction History");
        transactionHistoryButton.setBounds(540, 450, 200, 50);
        transactionHistoryButton.setBackground(new Color(100, 149, 237));
        transactionHistoryButton.setForeground(Color.WHITE);
        panel.add(transactionHistoryButton);

        JButton changePinButton = new JButton("Change PIN");
        changePinButton.setBounds(540, 530, 200, 50); // Adjusted dimensions
        changePinButton.setBackground(new Color(255, 69, 0));
        changePinButton.setForeground(Color.WHITE);
        panel.add(changePinButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(540, 590, 200, 50); // Adjusted dimensions
        logoutButton.setBackground(new Color(255, 69, 0));
        logoutButton.setForeground(Color.WHITE);
        panel.add(logoutButton);

        depositButton.addActionListener(e -> displayDeposit());
        withdrawButton.addActionListener(e -> displayWithdraw());
        transferButton.addActionListener(e -> displayTransfer());
        transactionHistoryButton.addActionListener(e -> displayTransactionHistory());
        changePinButton.addActionListener(e -> displayChangePin());
        logoutButton.addActionListener(e -> {
            currentAccount = null;
            frame.dispose();
            displayHomeScreen();
        });
    }

    private void displayDeposit() {
        String input = JOptionPane.showInputDialog(frame, "Enter amount to deposit:");
        if (input != null) {
            try {
                double amount = Double.parseDouble(input);
                if (amount > 0) {
                    currentAccount.deposit(amount);
                    JOptionPane.showMessageDialog(frame, "Deposit successful. New balance: INR " + currentAccount.getBalance());
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a positive amount.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid amount entered.");
            }
        }
    }

    private void displayWithdraw() {
        String input = JOptionPane.showInputDialog(frame, "Enter amount to withdraw:");
        if (input != null) {
            try {
                double amount = Double.parseDouble(input);
                if (amount > 0 && currentAccount.getBalance() >= amount) {
                    currentAccount.withdraw(amount);
                    JOptionPane.showMessageDialog(frame, "Withdrawal successful. New balance: INR " + currentAccount.getBalance());
                } else if (amount <= 0) {
                    JOptionPane.showMessageDialog(frame, "Please enter a positive amount.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Insufficient balance.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid amount entered.");
            }
        }
    }

    private void displayTransfer() {
        String accountNumberInput = JOptionPane.showInputDialog(frame, "Enter account number to transfer to:");
        if (accountNumberInput != null) {
            try {
                int targetAccountNumber = Integer.parseInt(accountNumberInput);
                if (accounts.containsKey(targetAccountNumber)) {
                    String amountInput = JOptionPane.showInputDialog(frame, "Enter amount to transfer:");
                    if (amountInput != null) {
                        double amount = Double.parseDouble(amountInput);
                        if (amount > 0 && currentAccount.getBalance() >= amount) {
                            currentAccount.withdraw(amount);
                            accounts.get(targetAccountNumber).deposit(amount);
                            JOptionPane.showMessageDialog(frame, "Transfer successful. New balance: INR " + currentAccount.getBalance());
                        } else if (amount <= 0) {
                            JOptionPane.showMessageDialog(frame, "Please enter a positive amount.");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Insufficient balance.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Target account not found.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid account number or amount entered.");
            }
        }
    }

    private void displayTransactionHistory(){
        String history = currentAccount.getTransactionHistory();
            JOptionPane.showMessageDialog(frame, history.isEmpty() ? "No transactions yet." : history);
                        }

    

    private void displayChangePin() {
        String input = JOptionPane.showInputDialog(frame, "Enter new PIN:");
        if (input != null && input.length() >= 4) {
            currentAccount.setPin(input);
            JOptionPane.showMessageDialog(frame, "PIN changed successfully.");
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid PIN. Please enter at least 4 digits.");
        }
    }
}

class Account {
    private int accountNumber;
    private String pin;
    private double balance;
    private String name;
    private int age;
    private String email;
    private String phone;
    private StringBuilder transactionHistory;

    public Account(int accountNumber, String pin, double balance, String name, int age, String email, String phone) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.transactionHistory = new StringBuilder();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        transactionHistory.append("Deposited: INR ").append(amount).append("\n");
        
    }

    public void withdraw(double amount) {
        this.balance -= amount;
        transactionHistory.append("Withdrew: INR ").append(amount).append("\n");
        
    }

    public boolean verifyPin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public void setPin(String newPin) {
        this.pin = newPin;
    }
    public String getTransactionHistory() {
        return transactionHistory.toString();
    }
}

