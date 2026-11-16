package Blilnd75.Array_Hashing;

public class EncodeDecodeString {
    public static void main(String agrs[]){
        String encoded = encode("Hello, World!");
        System.out.println(encoded);
        String decoded = decode(encoded);
        System.out.println(decoded);
    }

    public static String encode(String s){
        StringBuilder encoded = new StringBuilder();
        for(char c: s.toCharArray()){
            encoded.append(c) .append('#');
        }
        return encoded.toString();
    }

    public static String decode(String s){
        StringBuilder decoded = new StringBuilder();
        for(String part: s.split("(?=#)")){
            decoded.append(part);
        }
        return decoded.toString();
    }
}
