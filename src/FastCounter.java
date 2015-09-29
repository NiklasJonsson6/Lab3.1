/**
 * Created by Niklas on 2015-09-28.
 */
public class FastCounter extends CounterModel {

    /**
     * Number of steps to count fast
     */
    private int x;

    /**
     * No parameters, default values are mod = 15, x = 5
     */
    public FastCounter () {
        this(15, 5);
    }

    /**
     * Default modulus (15)
     * @param x Number of steps taken in up-, downMany
     */
    public FastCounter (int x) {
        this(15, x);
    }

    /**
     * Constructor for a FastCounter
     * @param modulus   The counter's maximum value, where it will start over from 0
     * @param x Number of steps taken in up-, downMany
     */
    public FastCounter (int modulus, int x) {
        super(modulus);
        this.x = x;
    }

    /**
     * Increase value with x
     */
    public void upMany() {
        for (int k = 0; k < this.x; k++) {
            this.increment();
        }
    }

    /**
     * Decrease value with x
     */
    public void downMany() {
        for (int k = 0; k < this.x; k++) {
            this.decrement();
        }
    }

    public int getStep() {
        return this.x;
    }

    @Override
    public String toString() {
        return super.toString() + " Number of steps " + this.x; //ej testat, bätttre formulerad utskrift?
    }

    @Override
    public boolean equals(Object r) {
        if (this == r) {
            return true;
        }
        if (r == null || this.getClass() != r.getClass()) {
            return false;
        }

        return this.getValue() == ((FastCounter)r).getValue();
    }
}
