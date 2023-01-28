package com.bk1team;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWJoystickCallback;

public class GamepadTest {

    public static void main(String[] args) {
        // Create a new JFrame to hold our program
        JFrame frame = new JFrame("Gamepad Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new JPanel to hold our information labels
        JPanel panel = new JPanel();

        // Initialize GLFW and set a callback to detect connected gamepads
        GLFW.glfwInit();
        GLFWJoystickCallback callback = new GLFWJoystickCallback() {
            @Override
            public void invoke(int joy, int event) {
                if (event == GLFW.GLFW_CONNECTED) {
                    // A gamepad was connected, so update the information displayed on our panel
                    for (int i = 0; i < 2; i++) {
                        String name = GLFW.glfwGetJoystickName(i);
                        panel.add(new JLabel("Gamepad " + i + ": " + name));
                    }
                    frame.pack();
                }
            }
        };
        GLFW.glfwSetJoystickCallback(callback);

        // Set the size and visibility of our frame
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setVisible(true);

        // Run the main loop to detect gamepad connections
        while (!frame.isVisible()) {
            GLFW.glfwPollEvents();
        }
    }
}
