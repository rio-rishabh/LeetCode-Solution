import java.util.List;
import java.util.ArrayList;
public class ProductOfLastKNumbers_BruteForce_Solution {
    public List<Integer> nums;

    public ProductOfLastKNumbers_BruteForce_Solution(){
        this.nums = new ArrayList<>();
    }

    public void add(int val){
        nums.add(val);
    }

    public int getProduct(int k){
        int product =1 ;
        int n = nums.size();

        for(int i = n-k ; i < n; i++){
            product *= nums.get(i);
        }
        return product;
    }

    public static void main(String args[]){
        ProductOfLastKNumbers_BruteForce_Solution productOfLastKNumbers = new ProductOfLastKNumbers_BruteForce_Solution();
        productOfLastKNumbers.add(1);
        productOfLastKNumbers.add(2);
        productOfLastKNumbers.add(0);
        productOfLastKNumbers.add(3);
        productOfLastKNumbers.add(4);
        System.out.println("Product of last 2 numbers is: " + productOfLastKNumbers.getProduct(2));
        System.out.println("Product of last 3 numbers is: " + productOfLastKNumbers.getProduct(3));
        System.out.println("Product of last 4 numbers is: " + productOfLastKNumbers.getProduct(4));
    }
}
