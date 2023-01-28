package com.bk1team;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWJoystickCallback;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GamepadExample extends Application {

    private GLFWJoystickCallback joystickCallback;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Waiting for gamepad input...");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Initialize GLFW
        GLFW.glfwInit();

        // Create a callback for gamepad input
        joystickCallback = new GLFWJoystickCallback() {
            @Override
            public void invoke(int jid, int event) {
                if (event == GLFW.GLFW_CONNECTED) {
                    label.setText("Gamepad connected with ID: " + jid);
                } else if (event == GLFW.GLFW_DISCONNECTED) {
                    label.setText("Waiting for gamepad input...");
                }
            }
        };

        // Register the callback
        GLFW.glfwSetJoystickCallback(joystickCallback);
    }

    @Override
    public void stop() {
        // Clean up GLFW resources
        joystickCallback.free();
        GLFW.glfwTerminate();
    }
}

