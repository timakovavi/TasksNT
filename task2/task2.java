package task2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class task2 {
	
	public static class Circle {
		private float x;
		private float y;
		private float radius;
	
		public Circle (float x, float y, float radius) {
			this.x = x;
			this.y = y;
			this.radius = radius;
		}
		
		public float getX() {
			return x;
		}
		public float getY() {
			return y;
		}
		public float getRadius() {
			return radius;
		}
	}
	
	public static Circle getCircle(String path) {
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
            String[] subStr;
            String delimeter = " "; 
            subStr = params.get(0).split(delimeter);
            float x = Float.parseFloat(subStr[0]);
            float y = Float.parseFloat(subStr[1]);
            float radius = Float.parseFloat(params.get(1));
            Circle circle = new Circle (x, y, radius);
            return circle;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public static void getPosition(Circle circle, float x1, float y1) {
		float x2 = circle.getX();
		float y2 = circle.getY();
		float r = circle.getRadius();
		double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		if (distance > r) {
			System.out.println("2");
		} else if (distance == r) {
			System.out.println("0");
		} else {
			System.out.println("1");
		}
	}
	
	public static void getCoordinates(String path, Circle circle) {
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
            for (int i = 0; i < params.size(); i++) {
            	String[] subStr;
                String delimeter = " "; 
                subStr = params.get(i).split(delimeter);
                getPosition(circle, Float.parseFloat(subStr[0]), Float.parseFloat(subStr[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
        String path1 = reader.readLine();
        Circle circle;
        circle = getCircle(path1);
        
        String path2 = reader.readLine();
        getCoordinates(path2, circle);
	}

}
