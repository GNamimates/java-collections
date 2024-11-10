import java.text.DecimalFormat;

public class DecimalFormats {
    public static void main(String[] args) {
        DecimalFormat df;

        // 123456789.00
        df = new DecimalFormat("#.00");
        // 123,456,789.00
        df = new DecimalFormat("###,###,###.00");
        // $123,456,789.00
        df = new DecimalFormat("$###,###,###.00");

        double a = 123456789;
        System.out.println(df.format(a));

    }
}
