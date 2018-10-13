public class Main {

    public static void main(String[] args) {
        java.util.Scanner s = new java.util.Scanner(System.in);
        Data data = new Data();

        while(true)
        {
            String cmd = s.next();
            switch(cmd)
            {
                case "end": return;
                case "add":
                    double d = s.nextDouble();
                    data.addValue(d);
                    break;
                case "avg":
                    System.out.println(data.getAvg());
                    break;
                case "max":
                    if(data.empty()) System.err.println("The data set is empty!");
                    else System.out.println(data.getMax());
                    break;
                default:
                    System.err.println("Wrong command!");
            }
        }
    }
}
