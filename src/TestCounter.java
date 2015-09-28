import org.w3c.dom.css.Counter;

/**
 * Created by Niklas on 2015-09-21.
 */
public class TestCounter {
    public static void main(String[] args){
        boolean error = false;

        CounterModel c1 = new CounterModel(10); //create test counters
        CounterModel c2 = new CounterModel(10);

        if (!(c1.getValue() == 0 || c2.getValue() == 0)){
            System.out.println("Wrong starting value, should be 0!");
            error = true;
        }

        int prev_c1 = c1.getValue(); //in case of wrong starting value
        int prev_c2 = c2.getValue();

        c1.increment();
        c2.decrement();
        if (!(prev_c1 == c1.getValue() - 1)){
            System.out.println("Error in increment!");
            error = true;
        }
        if (!(prev_c2 == c2.getValue() + 1)){
            System.out.println("Error in decrement!");
            error = true;
        }

        c1.reset();
        if (!(c1.getValue() == 0)) {
            System.out.println("Error in reset!");
            error = true;
        }

        c2.reset();
        if (!(c1.equals(c2))) {
            System.out.println("Error in equals!");
            error = true;
        }

        //For manual toString check
        System.out.println(c1 + "\n" + c2);

        if (!error){
            System.out.println("No errors! \n");
        }

        CounterModel[] ca = new CounterModel[10];

        for(int i = 0; i < ca.length; i++) {
            ca[i] = new CounterModel(10);
        }
        int i = 0;
        for (int k = 0; k < 10; k++) {
            while (i < k) {
                ca[k].increment();
                i++;
            }
            System.out.println("Counter nr " + i + ": " + ca[i]);
            i = 0;
        }
    }

    void changeValue(CounterModel r) {
        //TODO
    }
}
