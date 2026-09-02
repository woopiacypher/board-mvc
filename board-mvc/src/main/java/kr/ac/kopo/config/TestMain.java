package kr.ac.kopo.config;

public class TestMain {

	public static void main(String[] args) {
		
		System.out.println("============ start ================");
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < 1000000; i++) {
			s.append(i);
		}
		
		System.out.println("============ end ================");
		
		
//		System.out.println("============ start ================");
//		String s = "";
//		for(int i = 0; i < 100000; i++) {
//			s += i;
//		}
//		System.out.println("============ end ================");
		
	}
}
