import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<Print> prints = new ArrayList<Print>();
    public static void main(String[] args) throws IOException {

        BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\scout\\Downloads\\catalog.csv"));
        FileWriter csvWriter = new FileWriter("C:\\Users\\scout\\Downloads\\updated_catalog.csv");

        prints.add(new Print("\"4\"\" x 6\"\" Print with 5\"\" x 7\"\" Matte\"", 39.99));
        prints.add(new Print("\"5\"\" x 7\"\" Print with 8\"\" x 10\"\" Matte\"", 44.99));
        prints.add(new Print("\"8\"\" x 10\"\" Print with 11\"\" x 14\"\" Matte\"", 59.99));
        prints.add(new Print("\"11\"\" x 14\"\" Print with 16\"\" x 20\"\" Matte\"", 69.99));
        prints.add(new Print("\"5\"\" x 7\"\" Metal\"", 44.99));
        prints.add(new Print("\"8\"\" x 10\"\" Metal\"", 49.99));
        prints.add(new Print("\"11\"\" x 14\"\" Metal\"", 64.99));
        prints.add(new Print("\"16\"\" x 20\"\" Metal\"", 104.99));
        prints.add(new Print("\"6\"\" x 6\"\" Metal\"", 44.99));
        prints.add(new Print("\"10\"\" x 10\"\" Metal\"", 59.99));
        prints.add(new Print("\"16\"\" x 16\"\" Metal\"", 89.99));
        prints.add(new Print("\"20\"\" x 20\"\" Metal\"", 129.99));
        prints.add(new Print("\"10\"\" x 20\"\" Metal\"", 79.99));
        prints.add(new Print("\"16\"\" x 32\"\" Metal\"", 169.99));
        prints.add(new Print("\"20\"\" x 40\"\" Metal\"", 259.99));
        prints.add(new Print("\"5\"\" x 7\"\" Canvas\"", 54.99));
        prints.add(new Print("\"8\"\" x 10\"\" Canvas\"", 69.99));
        prints.add(new Print("\"11\"\" x 14\"\" Canvas\"", 94.99));
        prints.add(new Print("\"16\"\" x 23\"\" Canvas\"", 129.99));
        prints.add(new Print("\"6\"\" x 6\"\" Canvas\"", 54.99));
        prints.add(new Print("\"10\"\" x 10\"\" Canvas\"", 79.99));
        prints.add(new Print("\"14\"\" x 14\"\" Canvas\"", 99.99));
        prints.add(new Print("\"18\"\" x 18\"\" Canvas\"", 119.99));
        prints.add(new Print("\"6\"\" x 12\"\" Canvas\"", 64.99));
        prints.add(new Print("\"10\"\" x 20\"\" Canvas\"", 94.99));
        prints.add(new Print("\"15\"\" x 30\"\" Canvas\"", 139.99));
        prints.add(new Print("\"20\"\" x 40\"\" Canvas\"", 199.99));

        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");

            if (!data[5].equals("Variation Name"))
            {
                data[6] = Double.toString(findPrice(data[5]));
            }

            List<String> rowData = Arrays.asList(data);
            csvWriter.append(String.join(",", rowData));
            csvWriter.append("\n");
        }

        csvReader.close();
        csvWriter.flush();
        csvWriter.close();
    }

    static double findPrice(String printName)
    {
        for (Print print : prints)
        {
            if (printName.equals(print.getName()))
            {
                return print.getPrice();
            }
        }
        return 0.0;
    }
}
