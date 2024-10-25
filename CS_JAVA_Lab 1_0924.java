import java.util.*; 
public class Main { 
    public static void main(String[] args) { Scanner input = new Scanner(System.in); try { int a = input.nextInt(); int[] b = new int[a]; for (int i = 0; i < a; i++) { b[i] = input.nextInt(); } String result = doSomething(a, b); System.out.println(result); } catch (NoSuchElementException e) { System.out.println("Input not provided as expected. Please check the input and try again."); } finally { input.close(); } } 
    public static String doSomething(int a, int[] b) { int p = 0, n = 0, z = 0; for (int num : b) { if (num > 0) { p++; } else if (num < 0) { n++; } else { z++; } } double pr = p / (double) a; double nr = n / (double) a; double zr = z / (double) a; return String.format("%.3f %.3f %.3f", pr, nr, zr); } }
 