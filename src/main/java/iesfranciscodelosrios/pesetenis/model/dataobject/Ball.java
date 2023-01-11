package iesfranciscodelosrios.pesetenis.model.dataobject;

public class Ball {

    /**
     * Attributes
     */
    private float radio;
    private float velocityX;
    private float velocityY;

    /**
     * Constructor with full params
     * @param radio
     * @param velocityX
     * @param velocityY
     */
    public Ball(float radio, float velocityX, float velocityY) {
        this.radio = radio;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    /**
     * Default constructor
     */
    public Ball(){ this(1.0f,1.0f,1.0f); }

    /**
     * Getters and Setters
     */
    public float getRadio() { return radio; }

    public void setRadio(float radio) { this.radio = radio; }

    public float getVelocityX() { return velocityX; }

    public void setVelocityX(float velocityX) { this.velocityX = velocityX; }

    public float getVelocityY() { return velocityY; }

    public void setVelocityY(float velocityY) { this.velocityY = velocityY; }
}
