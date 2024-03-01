import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercises2 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for(int i = 0; i < nums.length - 1; i++)
        {
            for(int j = i + 1; j < nums.length; j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
    public int romanToInt(String s) {
        int n = s.length();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
        {
            switch (s.charAt(i))
            {
                case 'I':
                    nums[i] = 1; break;
                case 'V':
                    nums[i] = 5; break;
                case 'X':
                    nums[i] = 10; break;
                case 'L':
                    nums[i] = 50; break;
                case 'C':
                    nums[i] = 100; break;
                case 'D':
                    nums[i] = 500; break;
                case 'M':
                    nums[i] = 1000; break;
            }
        }
        int sum = 0;
        for(int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1])
                sum -= nums[i];
            else
                sum += nums[i];
        }
        return sum + nums[n - 1];
    }

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */

    public List<List<Integer>> permute(int[] nums) {
        int s = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(s == 1) {
            List<Integer> LastNum = new ArrayList<>();
            LastNum.add(nums[0]);
            ans.add(LastNum);
            return ans;
        }
        int[] LastNum = new int[s - 1];
        for(int i = 0; i < s - 1; i++)
            LastNum[i] = nums[i];
        ans = permute(LastNum);
        int sz = ans.size();
        for(int i = 0; i < sz; i++)
        {
            ans.get(i).add(nums[s - 1]);
            for(int j = s - 2; j >= 0; j--)
            {
                ans.add(ans.get(i));
                int tmp = ans.get(i).get(j);
                ans.get(i).set(j, ans.get(i).get(j + 1));
                ans.get(i).set(j + 1, tmp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}