import java.util.List;
import java.util.ArrayList;
public class ProductOfLastKNumbers_OptimalSolution {
    public static void main(String args[]){
        ProductOfLastKNumbers_OptimalSolution productOfLastKNumbers = new ProductOfLastKNumbers_OptimalSolution();
        productOfLastKNumbers.add(1);
        productOfLastKNumbers.add(2);
        productOfLastKNumbers.add(0);
        productOfLastKNumbers.add(3);
        productOfLastKNumbers.add(4);
        System.out.println("Product of last 2 numbers is: " + productOfLastKNumbers.getProduct(2));
        System.out.println("Product of last 3 numbers is: " + productOfLastKNumbers.getProduct(3));
        System.out.println("Product of last 4 numbers is: " + productOfLastKNumbers.getProduct(4));
    }

    List<Integer> prefix = new ArrayList<>();
    int lastZeroIndex = -1;

    public void add(int val){
        if(val ==0){
            lastZeroIndex = prefix.size();
            prefix.add(1);
        }
        else if(prefix.isEmpty()){
            prefix.add(val);
        }
        else{
            prefix.add(prefix.get(prefix.size() -1) * val);
        }
    }

    public int getProduct(int k){
        int n = prefix.size();

        if(lastZeroIndex >= n-k){
            return 0;
        }
        int end = prefix.get(n-1);
        int start = (n - k - 1 < 0) ? 1 : prefix.get(n - k - 1);
        return end / start;
    }
}
