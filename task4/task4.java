package task4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class task4 {

	public static void main(String[] args) throws IOException {
		// C:\Users\User\Desktop\file.txt
		BufferedReader readerConsole = new BufferedReader(
                new InputStreamReader(System.in));
		String path = readerConsole.readLine();
		try {
			File file = new File(path);
			FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            ArrayList<String> params = new ArrayList<String>();
            while (line != null) {
                params.add(line);
                line = reader.readLine();       
            }
            int size = params.size();
            int sum = 0;
            int[] nums = new int[size];
            for (int i = 0; i < size; i++) {
            	nums[i] = Integer.parseInt(params.get(i));
            	sum += nums[i];
            }
            int average = sum / size;
            int averageHigh = average + 1;
            int sumAv = 0;
            int sumAvH = 0;
            for (int i = 0; i < size; i++) {
            	sumAv += Math.abs(nums[i] - average);
            	sumAvH += Math.abs(nums[i] - averageHigh);
            }
            System.out.print(Math.min(sumAv, sumAvH));
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
