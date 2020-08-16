

/*

 */
public class Main {
    public static void main(String[] args) {
        String str = "HG[3|B[2|CA]]F";
        String str1="[2|CA]";
        str=str.replace(str1,"CACA");
        System.out.println(str);
    }
}
