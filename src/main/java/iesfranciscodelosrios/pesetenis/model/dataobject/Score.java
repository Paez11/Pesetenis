package iesfranciscodelosrios.pesetenis.model.dataobject;

public class Score {

    /**
     * Attributes
     */
    private int score;

    /**
     * Constructor with full params
     * @param score
     */
    public Score(int score) { this.score = score; }

    /**
     * Default constructor
     */
    public Score(){ this(0); }

    /**
     * Getters and Setters
     */
    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }
}
