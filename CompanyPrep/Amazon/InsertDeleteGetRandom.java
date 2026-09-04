package CompanyPrep.Amazon;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
public class InsertDeleteGetRandom {
    public static void main(String args[]){
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }

    public static class RandomizedSet {
        private final List<Integer>  nums;
        private final Map<Integer, Integer> idx;
        private final Random random;

        public RandomizedSet(){
            nums = new ArrayList<>();
            idx = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val){
            if(idx.containsKey(val)){
                return false;
            }
            idx.put(val, nums.size());
            nums.add(val);
            return true;
        }

        public boolean remove(int val){
            if(!idx.containsKey(val)){
                return false;
            }
            int last = nums.get(nums.size() - 1);
            int idxToReplace = idx.get(val);
            nums.set(idxToReplace, last);
            idx.put(last, idxToReplace);
            idx.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        }
        public int getRandom(){
            return nums.get(random.nextInt(nums.size()));
        }
    }


}
