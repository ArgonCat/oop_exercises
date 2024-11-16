package vec2dfloat;

public class Vector2DFloat {
    private float x;
    private float y;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float magnitude() {
        return (float) Math.sqrt(x*x+y*y);
    }

    public void normalise() {
        float mag = magnitude();
        x = x/mag;
        y = y/mag;
    }

    public float dot(Vector2DFloat other) {
        return this.x*other.x+this.y*other.y;
    }

    public void add(Vector2DFloat other) {
        this.x = this.x + other.x;
        this.y = this.y + other.y;
    }
}
