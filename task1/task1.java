package task1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task1 {
	
	public static String getS(int[] mas, int m, int j) {
		int n = mas.length;
		String s = "";
        if (m > (n - j)) {
        	for (int i = j; i < n; i++) {
            	s += String.valueOf(mas[i]);
            }
        	m = m - n + j;
        	int t = m / n;
        	int k = m % n;
        	String stringMas = "";
        	for (int i = 0; i < n; i++) {
        		stringMas += String.valueOf(mas[i]);
        	}
        	for (int i = 0; i < t; i++) {
        		s += stringMas;
        	}
        	for (int i = 0; i < k; i++) {
            	s += String.valueOf(mas[i]);
            }
        } else {
            for (int i = j; i < m + j; i++) {
            	s += String.valueOf(mas[i]);
            }	
        }
		return s;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
 
        String str = reader.readLine();
        String[] subStr;
        String delimeter = " "; 
        subStr = str.split(delimeter);
        try {
            int n = Integer.parseInt(subStr[0]);
            int m = Integer.parseInt(subStr[1]);
            int[] mas = new int[n];
            for (int i = 0; i < n; i++) {
            	mas[i] = i + 1;
            }
            int count = 0;
            String end = "";
            String result = "";
            String s = "";
            while (!end.equals("1")) {
            	s = getS(mas, m, count);
                result += String.valueOf(s.charAt(0));
                end = String.valueOf(s.charAt(s.length() - 1));
                count = Integer.parseInt(String.valueOf(s.charAt(s.length() - 2)));
            }
            System.out.print(result);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
	}
}
