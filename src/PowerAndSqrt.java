import java.text.DecimalFormat;

public class PowerAndSqrt {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.00");
        double a = 4.0;
        System.out.println("The Power value is "+df.format(Math.pow(a,2)));
        System.out.println("The Sqrt value is "+df.format(Math.sqrt(a)));
    }
}
