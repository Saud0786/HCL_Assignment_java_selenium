public class StringOperationsDemo {
    public static void main(String[] args) {

        String str1 = "  Hello Java Programming  ";
        String str2 = "Hello Java Programming";
        String str3 = "Hello";

        // length()
        System.out.println("Length: " + str1.length());

        // isEmpty()
        System.out.println("Is Empty: " + str3.isEmpty());

        // charAt()
        System.out.println("Character at index 1: " + str3.charAt(1));

        // toString()
        StringBuffer sb = new StringBuffer("Java");
        System.out.println("toString(): " + sb.toString());

        // equals()
        System.out.println("Equals: " + str2.equals(str1.trim()));

        // compareTo()
        System.out.println("CompareTo: " + str3.compareTo("Hello"));

        // contains()
        System.out.println("Contains 'Java': " + str1.contains("Java"));

        // indexOf()
        System.out.println("IndexOf 'Java': " + str1.indexOf("Java"));

        // lastIndexOf()
        System.out.println("LastIndexOf 'a': " + str1.lastIndexOf("a"));

        // startsWith()
        System.out.println("StartsWith 'Hello': " + str2.startsWith("Hello"));

        // endsWith()
        System.out.println("EndsWith 'Programming': " + str2.endsWith("Programming"));

        // matches()
        System.out.println("Matches regex: " + str3.matches("[A-Za-z]+"));

        // substring()
        System.out.println("Substring: " + str2.substring(6, 10));

        // toLowerCase()
        System.out.println("Lowercase: " + str3.toLowerCase());

        // trim()
        System.out.println("Trim: " + str1.trim());

        // replace()
        System.out.println("Replace: " + str2.replace("Java", "Core Java"));

        // split()
        String[] words = str2.split(" ");
        System.out.println("Split:");
        for (String w : words) {
            System.out.println(w);
        }

        // join()
        String joined = String.join("-", "Java", "is", "Powerful");
        System.out.println("Join: " + joined);

        // valueOf()
        int num = 100;
        String value = String.valueOf(num);
        System.out.println("ValueOf: " + value);
    }
}
