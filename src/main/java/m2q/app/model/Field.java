package m2q.app.model;

import lombok.Data;

/**
 * Fields class - represents fields in a table.
 *
 * @author JarnotMaciej
 * @version 1.0
 */
@Data
public class Field {
    /**
     * Field name.
     */
    private String name;
    /**
     * Field type.
     */
    private String type;
    /**
     * Field is primary key.
     */
    private Boolean isPrimaryKey;
    /**
     * Field is not null.
     */
    private Boolean notNull;

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
}
