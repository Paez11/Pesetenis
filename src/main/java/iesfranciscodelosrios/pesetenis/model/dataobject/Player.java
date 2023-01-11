package iesfranciscodelosrios.pesetenis.model.dataobject;

public class Player {

    /**
     * Attributes
     */
    private float width;
    private float heigth;
    private Score score;

    /**
     * Constructor with full params
     * @param width
     * @param heigth
     */
    public Player(float width, float heigth) {
        this.width = width;
        this.heigth = heigth;
    }

    /**
     * Default constructor
     */
    public Player(){}

    /**
     * Getters and Setters
     */
    public float getWidth() { return width; }

    public void setWidth(float width) { this.width = width; }

    public float getHeigth() { return heigth; }

    public void setHeigth(float heigth) { this.heigth = heigth; }

    public Score getScore() { return score; }

    public void setScore(Score score) { this.score = score; }
}
