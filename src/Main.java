package ru.miem.shell;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(600, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        String user = System.getProperty("user.name");
        String host = "localhost";
        try {
            host = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {

        }
        window.setTitle("Эмулятор - " + user + "@" + host);

        JTextArea output = new JTextArea();
        output.setEditable(false);

        JTextField input = new JTextField();

        window.add(new JScrollPane(output), BorderLayout.CENTER);
        window.add(input, BorderLayout.SOUTH);

        input.addActionListener(e -> {

            String line = input.getText().trim();
            input.setText("");
            input.requestFocusInWindow();

            if (line.isEmpty()) {
                return;
            }

            String home = System.getenv("HOME");
            if (home == null) {
                home = System.getenv("USERPROFILE");
            }
            if (home != null) {
                line = line.replace("$HOME", home);
            }

            String login = System.getenv("USER");
            if (login == null) {
                login = System.getenv("USERNAME");
            }
            if (login != null) {
                line = line.replace("$USER", login);
            }

            output.append("VFS> " + line + "\n");

            String[] parts = line.split(" ");
            String cmd = parts[0];

            if (cmd.equals("ls") || cmd.equals("cd")) {
                output.append(line + "\n");
            } else if (cmd.equals("exit")) {
                System.exit(0);
            } else {
                output.append("Unknown command: " + cmd + "\n");
            }
        });

        window.setVisible(true);
        input.requestFocusInWindow();
    }
}
