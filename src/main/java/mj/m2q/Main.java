package mj.m2q;

import mj.m2q.controller.Controller;

/**
 * Main class.
 *
 * @author JarnotMaciej
 * @version 1.0
 */
public class Main {
    /**
     * Default constructor for the Main class.
     */
    public Main() {
        // This constructor intentionally left empty
    }

    /**
     * Main method.
     *
     * @param args arguments passed to the program
     */
    public static void main(String[] args) {
        try {
            Controller controller = new Controller(args);
            controller.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}