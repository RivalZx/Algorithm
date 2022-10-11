/**
 * @program: Algorithm
 * @description:
 * @author: he-zx
 * @create: 2022-04-12 13:26
 **/
public class Main {
	public static void main(String[] args) throws ClassNotFoundException {
		Main main = new Main();
		ClassLoader classLoader = main.getClass().getClassLoader();
		System.out.println(main.getClass().getClassLoader());
		classLoader.loadClass("Main");
		
	}
}
