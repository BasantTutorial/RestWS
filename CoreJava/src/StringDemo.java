public class StringDemo {
	public static void main(String[] args) {
		String s = "java";
		String s1 = new String("java");
		String s2 = new String("java");
		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());

	}
}