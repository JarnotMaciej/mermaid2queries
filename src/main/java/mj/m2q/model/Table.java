package mj.m2q.model;

import java.util.ArrayList;

/**
 * Table class.
 *
 * @author JarnotMaciej
 * @version 1.0
 */
public class Table {
/**
     * Table name.
     */
    String name;
    /**
     * Table columns.
     */
    ArrayList<Field> columns = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param name    table name
     */
    public Table(String name) {
        this.name = name;
    }

    /**
     * Adds column to the table.
     *
     * @param name column name
     * @param type column type
     */
    public void addColumn(String name, String type) {
        columns.add(new Field(name, type));
    }

    /**
     * Method allows to print table to the console.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Table: ").append(name).append("\n");
        for (Field column : columns) {
            sb.append(column).append("\n");
        }
        return sb.toString();
    }
}
