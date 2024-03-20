package m2q.app.model;

/**
 * Fields class - represents fields in a table.
 *
 * @author JarnotMaciej
 * @version 1.0
 */
public class Field {
    /**
     * Field name.
     */
    String name;
    /**
     * Field type.
     */
    String type;
    /**
     * Field is primary key.
     */
    Boolean isPrimaryKey;
    /**
     * Field is not null.
     */
    Boolean notNull;

    /**
     * Constructor.
     *
     * @param name field name
     * @param type field type
     */
    public Field(String name, String type) {
        this.name = name;
        this.type = type;
        this.isPrimaryKey = type.toLowerCase().contains("serial");
        this.notNull = true;
    }

    /**
     * Method allows to print field to the console.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type).append(": ").append(name);
        if (isPrimaryKey) {
            sb.append(" (PK)");
        }
        return sb.toString();
    }
}
