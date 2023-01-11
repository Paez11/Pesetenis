package iesfranciscodelosrios.pesetenis.model.dataobject;

public class Field {

    /**
     * Attributes
     */
    private long width;
    private long heigth;

    /**
     * Constructor with full params
     * @param width
     * @param heigth
     */
    public Field(long width, long heigth) {
        this.width = width;
        this.heigth = heigth;
    }

    /**
     * Default constructor
     */
    public Field(){ this(800,600); }

    /**
     * Getters and Setters
     */
    public long getWidth() { return width; }

    public void setWidth(long width) { this.width = width; }

    public long getHeigth() { return heigth; }

    public void setHeigth(long heigth) { this.heigth = heigth; }
}
