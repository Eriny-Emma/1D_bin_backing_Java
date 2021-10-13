import java.io.*;

public class CSVWriter {
    public static String file_name ="testNEWall_take2.csv";
    public static void header()
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(new File(file_name), true))) {

            StringBuilder sb = new StringBuilder();
            sb.append("id"); //0
            sb.append(',');
            sb.append("type"); //1
            sb.append(',');
            sb.append("no. of threads"); // 2
            sb.append(',');
            sb.append("number of bins"); //3
            sb.append(',');
            sb.append("total spaces"); // 4
            sb.append(',');
            sb.append("average waste"); // 5
            sb.append(',');
            sb.append("time"); ///6
            sb.append(',');
            sb.append("bin Capacity"); ///7
            sb.append(',');
            sb.append("number of objects"); ///8
            sb.append('\n');


            writer.write(sb.toString());

            System.out.println("writing headers");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteData(String[] Data)
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(new File(file_name), true))) {

            StringBuilder sb = new StringBuilder();
            for (String s : Data) {
                sb.append(s);
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);

            sb.append('\n');


            writer.write(sb.toString());

            System.out.println("writing data");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
