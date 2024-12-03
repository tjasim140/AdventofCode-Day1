
import com.sun.jdi.IntegerValue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class AdventSolver {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/InputFile");
        // you now have a list of Strings from the file "InputFile"
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i< fileData.size(); i++){
            String x = fileData.get(i);
            list1.add(Integer.parseInt(x.substring(0,5)));
            list2.add(Integer.parseInt(x.substring(8,13)));
        }

        System.out.println(list1);
        System.out.println(list2);

        Collections.sort(list1);
        Collections.sort(list2);

        //------Part One-----------------//
        int sum = 0;
        for (int i = 0; i< list2.size();i++){
            sum += Math.abs(list1.get(i)-list2.get(i));
        }
        System.out.println(sum);


        //--------Part Two--------------//
        int count;
        int similarityScore = 0;

        for (int i = 0; i<list1.size(); i++){
            count = 0;
            int num = list1.get(i);
            for (int j = 0; j < list2.size();j++){
                int num2 = list2.get(j);
                if ((num == num2)){
                    count++;
                }
            }
            int score = num*count;
            similarityScore += score;
        }
        System.out.println(similarityScore);

    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}