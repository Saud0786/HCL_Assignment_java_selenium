package Assignment_1;
class StringAllOperations {

    public static void main(String[] args) {

        String s = "  Java Programming Language  ";
        String s2 = "Java";

        System.out.println("String Operations");
        System.out.println(s.length());
        System.out.println(s.isEmpty());
        System.out.println(s.charAt(2));
        System.out.println(s.toString());
        System.out.println(s.equals(s2));
        System.out.println(s.compareTo(s2));
        System.out.println(s.contains("Java"));
        System.out.println(s.indexOf("a"));
        System.out.println(s.lastIndexOf("a"));
        System.out.println(s.startsWith("  Ja"));
        System.out.println(s.endsWith("  "));
        System.out.println(s.matches(".*Programming.*"));
        System.out.println(s.substring(2, 6));
        System.out.println(s.toLowerCase());
        System.out.println(s.trim());
        System.out.println(s.replace("Java", "Python"));

        String[] arr = s.trim().split(" ");
        for (String str : arr)
            System.out.print(str + " ");

        System.out.println();
        System.out.println(String.join("-", arr));
        System.out.println(String.valueOf(100));

        System.out.println("\nStringBuffer Operations");
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        sb.insert(5, " Java");
        sb.replace(0, 5, "Hi");
        sb.delete(2, 6);
        System.out.println(sb);

        System.out.println("\nStringBuilder Operations");
        StringBuilder sb1 = new StringBuilder("Welcome");
        sb1.append(" to Java");
        sb1.reverse();
        System.out.println(sb1);
    }
}
