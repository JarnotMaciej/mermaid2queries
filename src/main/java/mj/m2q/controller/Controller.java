package mj.m2q.controller;

import mj.m2q.model.Model;
import mj.m2q.view.View;

/**
 * Controller class.
 *
 * @author JarnotMaciej
 * @version 1.0
 */
public class Controller {
    /**
     * Input file path.
     */
    private String inputFilePath;
    /**
     * Output file path.
     */
    private String outputFilePath;
    /**
     * View object.
     */
    View view = new View();
    /**
     * Model object.
     */
    Model model;

    /**
     * Constructor.
     *
     * @param args arguments passed to the program
     */
    public Controller(String[] args) {
        String path = System.getProperty("user.dir");
        view.printMessage("Working Directory = " + path);
        inputFilePath = path + "/input.txt";
        outputFilePath = path + "/output.txt";
        switch (args.length) {
            case 0:
                break;
            case 1:
                inputFilePath = args[0];
                break;
            case 2:
                if (args[0].equals("-i")) {
                    inputFilePath = args[1];
                } else if (args[0].equals("-o")) {
                    outputFilePath = args[1];
                } else {
                    throw new IllegalArgumentException("Invalid arguments");
                }
                break;
            case 4:
                if (args[0].equals("-i") && args[2].equals("-o")) {
                    inputFilePath = args[1];
                    outputFilePath = args[3];
                } else if (args[0].equals("-o") && args[2].equals("-i")) {
                    inputFilePath = args[3];
                    outputFilePath = args[1];
                } else {
                    throw new IllegalArgumentException("Invalid arguments");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid number of arguments");
        }
        model = new Model(inputFilePath, outputFilePath);
    }

    /**
     * Runs the program.
     */
    public void run() {
        model.getTextInput();
        model.createTables();
//        model.printTables();
        model.toSQL();
        model.printSQL();
        model.saveSQL();
    }

}
