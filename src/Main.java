
import java.io.*;


public class Main {

    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("Неверный формат ввода аргументов (java -jar reverse.jar [input file] [output file])");
            return;
        }

        try(
            RandomAccessFile in = new RandomAccessFile(args[0], "r");
            FileOutputStream out = new FileOutputStream(args[1])) {
            for (long p = in.length() - 1; p >= 0; p--) {
                in.seek(p);
                int b = in.read();
                out.write(b);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Неверное имя файла");
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
    }
}

