//Niklas Jonsson
//Simon Moos
//Grupp 13

public class TestCounter {
    public static void main(String[] args){

        CounterModel c1 = new CounterModel(10); //create test counters
        CounterModel c2 = new CounterModel(10);

        if (!testMethods(c1, c2)){
            System.out.println("No errors! \n");
        }

        CounterModel[] ca = new CounterModel[14];
        testArray(ca, 12);
    }

    /**
     * Tests the CounterModel methods
     * @param c1 First CounterModel to test
     * @param c2 Seconds CounterModel to test
     * @return True if error(s) is found
     */
    static boolean testMethods(CounterModel c1, CounterModel c2) {

        boolean error = false;
        if (!(c1.getValue() == 0 || c2.getValue() == 0)){
            System.out.println("Wrong starting value, should be 0!");
            error = true;
        }

        int prev_c1 = c1.getValue(); //in case of wrong starting value
        int prev_c2 = c2.getValue();

        for (int k = 0; k < 10; k++) {
            c1.increment();
        }
        c2.increment();
        if (!(prev_c2 == c2.getValue() - 1) || c1.getValue() != prev_c1){
            System.out.println("Error in increment!");
            error = true;
        }

        c2.reset();
        c2.decrement();
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
        System.out.println("c1: " + c1 + "\n" + "c2: " + c2);

        return error;
    }

    /**
     * Tests an array of CounterModels
     * @param ca The CounterModel array
     * @param mod The modulus value of the counters
     */
    static void testArray(CounterModel[] ca, int mod) {

        for(int i = 0; i < ca.length; i++) {
            ca[i] = new CounterModel(mod);
        }
        System.out.println("Should have same value as counter number % " + mod);
        int i = 0;
        for (int k = 0; k < ca.length; k++) {
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
        //Vad ska metoden göra...?
    }
}
