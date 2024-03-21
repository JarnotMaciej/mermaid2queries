package m2q.app.model;

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
     */
    public Model(String input) {
        text = input;
    }

    /**
     * Cleans up the input text a bit.
     *
     * @return cleaned up text
     */
    public String cleanUp() {
        if (text != null) {
//        removing mermaid js comments
            text = text.replaceAll("%%.*\n", "");
//        removing connection lines
            text = text.replaceAll("(?s).*?\\|.*?\n", "");
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
        String currentTableName = "";
        for (String line : lines) {
            line = line.trim();
            if (line.matches(".*\\s\\{")) {
                currentTableName = line.substring(0, line.indexOf(" {"));
                tables.add(new Table(currentTableName));
            } else if (line.matches(".*\\}")) {
                currentTableName = "";
            } else {
                String[] words = line.split(" ");
                if (!tables.isEmpty() && words.length > 1) {
                    tables.get(tables.size() - 1).addColumn(words[1], words[0]);
                }
            }
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
                sb.append(column.getName()).append(" ").append(column.getType()).append(",\n");
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

    public String getQueries() {
        StringBuilder sb = new StringBuilder();
        for (String query : sqlQueries) {
            sb.append(query);
        }
        return sb.toString();
    }
}
