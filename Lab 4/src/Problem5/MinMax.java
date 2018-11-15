package Problem5;

public class MinMax {
    static class Pair{
        private int min, max;

        public Pair(int min, int max){
            this.min = min;
            this.max = max;
        }

        @Override
        public String toString() {
            return "min = " + min + "\nmax = " + max;
        }
    }

    static Pair minmax(int values[]){
        int min = values[0], max = values[0];

        for(int val : values){
            if(val > max) max = val;
            if(val < min) min = val;
        }

        return new Pair(min, max);
    }
}
