/**
 * Created by Niklas on 2015-09-21.
 */
public class CounterModel implements CounterInterface {

    private int value = 0; //start value
    private int modulus; //"wraps around" to 0 at:

    public CounterModel(int modulus) {
        if (modulus < 1) {
            throw new IllegalArgumentException("The counter's maximum value has to be > 1!");
        }
        this.modulus = modulus;
    }

    @Override
    public void increment() {
        this.value = (this.value + 1) % this.modulus;
    }

    @Override
    public void decrement() {
        this.value--;
        if (this.value == this.modulus){
            this.value = 0;
        }
    }

    @Override
    public void reset() {
        this.value = 0;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    public int getModulus() {
        return this.modulus;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public boolean equals(Object r) {
        if (r == null) {
            return false;
        }
        if (!(r instanceof CounterModel)) {
            return false;
        }

        CounterModel r2 = (CounterModel)r;
        return this.value == r2.value;
    }
}
