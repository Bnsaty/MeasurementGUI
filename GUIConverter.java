
/**
 * UMGC CMIS 242
 * @author Brian Hinkle
 *         Date: (3/27/2023)
 *         This code is designed to create a GUI representation of the Converter class and
 *         all subclasses within it. It will design and arrange the application, handle user 
 *         input and display proper messages to the user.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Create subclass from JFrame to display GUI.
public class GUIConverter extends JFrame {
    // Buttons used within the GUI; leads user to specific conversions or exit.
    private JButton tempButton, distButton, exitButton;
    private JPanel mainPanel; // Panel to house the buttons.

    public GUIConverter() {
        setTitle("Welcome to Converter"); // GUI title.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit app. when user closes window.
        setResizable(isResizable()); // Lets user resize window.

        mainPanel = new JPanel(new GridLayout(3, 1)); // Create instance of the GUI panel.
        // Create instances of buttons and assign titles.
        distButton = new JButton("Distance Converter");
        tempButton = new JButton("Temperature Converter");
        exitButton = new JButton("Exit");

        // Add listener to button to wait for user input.
        distButton.addActionListener(new ActionListener() {
            // 'actionPerformed' is to prompt user for input in pop-up window.
            // Handle user input to perform conversion and display result or error message.
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create instance of 'DistanceConverter'.
                DistanceConverter distConvert = new DistanceConverter();

                try {
                    // Create variable for 'input' using dialog box to prompt user for input.
                    // Take argument as a string and convert input into a double.
                    double input = Double.parseDouble(JOptionPane.showInputDialog("Enter distance in miles:"));
                    // Use 'setInput' method to assign obj. 'input' attribute.
                    distConvert.setInput(input);
                    // Create pop-up window and display formatted conversion to user.
                    JOptionPane.showMessageDialog(null,
                            "Distance in kilometers: " + String.format("%.2f", distConvert.convert()));
                    // Handle exception of bad user input. Display bad user input error message.
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }
        });

        // Add listener to button to wait for user input.
        tempButton.addActionListener(new ActionListener() {
            // 'actionPerformed' is to prompt user for input in pop-up window.
            // Handle user input to perform conversion and display result or error message.
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create instance of 'TemperatureConverter'.
                TemperatureConverter converter = new TemperatureConverter();

                try {
                    // Create variable for 'input' using dialog box to prompt user for input.
                    // Take argument as a string and convert input into a double.
                    double input = Double.parseDouble(JOptionPane.showInputDialog("Enter temperature in Fahrenheit:"));
                    // Use 'setInput' method to assign obj. 'input' attribute.
                    converter.setInput(input);
                    // Create pop-up window and display formatted conversion to user.
                    JOptionPane.showMessageDialog(null,
                            "Temperature in Celsius: " + String.format("%.2f", converter.convert()));
                    // Handle exception of bad user input. Display bad user input error message.
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }
        });

        // Add listener to button to wait for user input.
        exitButton.addActionListener(new ActionListener() {
            // 'actionedPerformed' upon input is to exit the program.
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add and arrange buttons on main panel.
        mainPanel.add(distButton);
        mainPanel.add(tempButton);
        mainPanel.add(exitButton);
        // Arrange buttons in the center of the app.
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Ensure frame is designed and arranged correctly
        pack();
        // Resize frame for ease of use.
        setSize(800, 600);
        // Center frame on screen.
        setLocationRelativeTo(null);
        // Make frame visible to user.
        setVisible(true);
    }

    // Start 'Main' method.
    public static void main(String[] args) {
        // Execute GUIConverter class.
        new GUIConverter();
    }
}