package mj.m2q.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Model class.
 *
 * @author JarnotMaciej
 * @version 1.0
 */
public class Model {
    /**
     * Input file path.
     */
    String inputFilePath;
    /**
     * Output file path.
     */
    String outputFilePath;
    /**
     * Text from input file.
     */
    String text;
    /**
     * Tables array.
     */
    ArrayList<Table> tables = new ArrayList<>();
    /**
     * Table of SQL queries.
     */
    ArrayList<String> sqlQueries = new ArrayList<>();


    /**
     * Constructor.
     *
     * @param inputFilePath  input file path
     * @param outputFilePath output file path
     */
    public Model(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    /**
     * Extracts text from input file. Removes mermaid js comments and connection lines.
     *
     * @return text from input file
     */
    public String getTextInput() {
        if (inputFilePath != null) {
            try {
                text = new String(Files.readAllBytes(Paths.get(inputFilePath)));
            } catch (IOException e) {
                e.printStackTrace();
            }
//        removing mermaid js comments
            text = text.replaceAll("%%.*\n", "");
//        removing connection lines
            text = text.replaceAll(".*\\|.*\n", "");
//        removing erDiagram line
            text = text.replaceAll("erDiagram.*\n", "");
//        removing empty lines
            text = text.replaceAll("\n+", "\n");
            return text;
        }
        return null;
    }

    /**
     * Creating table objects from input text.
     *
     */
    public void createTables() {
        String[] lines = text.split("\n");
        int tablesCount = 0;
        String currentTableName = "";
        for (String line : lines) {
            line = line.trim();
            if (line.matches(".*\\s\\{")) {
                currentTableName = line.substring(0, line.indexOf(" {"));
                tables.add(new Table(currentTableName));
                tablesCount++;
            }
            else if (line.matches(".*\\}")) {
                currentTableName = "";
            } else {
                String[] words = line.split(" ");
                if (words.length > 1) {
                    tables.get(tablesCount - 1).addColumn(words[1], words[0]);
                }
            }
        }
    }

    /**
     * Prints tables to the console.
     *
     */
    public void printTables() {
        for (Table table : tables) {
//            TODO: delegate this to view
            System.out.println(table);
        }
    }

    /**
     * Creates SQL queries from tables.
     *
     */
    public void toSQL() {
        // TODO: improve this method -> primary keys, not null
        for (Table table : tables) {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ").append(table.name).append(" (\n");
            for (Field column : table.columns) {
                sb.append(column.name).append(" ").append(column.type).append(",\n");
            }
            sb.deleteCharAt(sb.length() - 2);
            sb.append(");\n");
            sqlQueries.add(sb.toString());
        }
    }

    /**
     * Prints SQL queries to the console.
     *
     */
    public void printSQL() {
        for (String query : sqlQueries) {
            System.out.println(query);
        }
    }

    /**
     * Saves SQL queries to the output file.
     *
     */
    public void saveSQL() {
        try {
            Files.write(Paths.get(outputFilePath), sqlQueries);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
