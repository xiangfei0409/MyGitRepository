/**
 * @Author: xiangfei
 * @CreateTime: 2023/09/13 013 15:45:41
 */
public class demo {
    public static void main(String[] args) {
        int [] nums = {2,7,11,9};
        int target = 9;
        int []tags = getTarget(nums, target);
        for (int i = 0; i < tags.length; i++) {
            System.out.println(tags[i]);
        }
    }

    public static int[] getTarget(int [] nums , int target){
        int[] tags = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    tags[0] = i;
                    tags[1] = j;
                }
            }
        }
        return tags;
    }
    //   /students/getStuInfo/{id}
}
