void main(){
   // System.out.println("hello");
//    List<List<Integer>> ans = new ArrayList<>();
//int[] arr = new int[]{2,3,6,7};
//    combsum(arr,0,7,new ArrayList<>(),ans);

//String ans = Arrays.toString(buildArr(new int[]{0,2,1,5,3,4}));
//  System.out.println(ans);

//    String ans = Arrays.toString(cancatinate(new int[]{0,2,1,5,3,4}));
//  System.out.println(ans);

//    String ans = Arrays.toString(runningSum(new int[]{0,2,1,5,3,4}));
//  System.out.println(ans);


    //int ans = topWealth(new int[][]{{1,2,3},{4,5,6}});
//    int [] arr = new int[]{8,1,2,2,3};
    int[] nums = {0,1,2,3,4}, index = {0,1,2,2,1};

//  System.out.println(Arrays.toString(shuffleArray(arr,3)));

//  System.out.println(kidsWithCandies(arr,3));
//  System.out.println(numIdenticalPairs(arr));
//  System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
//  System.out.println(Arrays.toString(createTargetArray(nums,index)));
//  System.out.println(checkIfPangram("leet"));

    List<List<String>> items = List.of(
            List.of("phone", "blue", "pixel"),
            List.of("computer", "silver", "lenovo"),
            List.of("phone", "gold", "iphone")
    );
    String ruleKey = "color", ruleValue = "silver";

//    System.out.println(countMatches(items,ruleKey,ruleValue));
//    System.out.println(largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
    int[][] ans = flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}});
    for (int i = 0; i < ans.length; i++) {
        System.out.println(Arrays.toString(ans[i]));
    }



}



void combsum(int[] arr, int idx, int target, List<Integer> temp, List<List<Integer>> ans){
if(target==0){
    ans.add(new ArrayList(temp));
    return;
}
if(idx==arr.length-1) return;

if(target-arr[idx]>=0){
    temp.add(arr[idx]);
    combsum(arr,idx+1,target-arr[idx],temp,ans);
    temp.remove(temp.size()-1);

}
    combsum(arr,idx+1,target,temp,ans);

}

//build array from permutations

//i/p:[0,2,1,5,3,4]
//o/p:[0,1,2,4,5,3]

int[] buildArr(int[] arr){
    int[] ans = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
        ans[i]= arr[arr[i]];
    }
    return ans;
}

//concatination of an array
//i/p : [1,2,3]
//o/p : [1,2,3,1,2,3]

int[] cancatinate(int[] arr){
    int len = arr.length;
    int[] ans = new int[len*2];
    for (int i = 0; i < len; i++) {
        ans[i]=arr[i];
        ans[i+len]=arr[i];
    }
    return ans;
}

//running sum
//i/p:1,2,3,4
//o/p:1,3,6,10

int[] runningSum(int[] arr){
    int[] ans = new int[arr.length];
int sum=0;
    for (int i = 0; i < arr.length; i++) {
        sum+=arr[i];
        ans[i]=sum;
    }
    return ans;


}

//Reachest customer waelth
//i/p : [[1,2,3],[3,2,1]]
//o/p: 6 1+2+3=6 3+2+1=6

int topWealth(int[][] accounts){
    int max=0;

    for (int i = 0; i < accounts.length; i++) {
        int cur=0;
        for (int j = 0; j < accounts[i].length; j++) {
            cur+=accounts[i][j];
        }
        if(cur>max){
            max=cur;
        }
    }

    return max;
}


//https://leetcode.com/problems/shuffle-the-array/description/
//[2,5,1,3,4,7]
//[2,3,5,4,1,7]

int[] shuffleArray(int[] arr,int n){
    int i=0;
    int p1=0;
    int p2=n;
    int [] ans = new int[n*2];

    while(i<n*2){
        ans[i++]=arr[p1++];
        ans[i++]=arr[p2++];


    }

    return ans;
}

//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/
//candies = [2,3,5,1,3], extraCandies = 3
//[true,true,true,false,true]

List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int max=0;
    int length=candies.length;
    List ans = new ArrayList<Boolean>();
    for (int i = 0; i < length; i++) {
        if(candies[i]>max){
            max=candies[i];
        }
    }

    for (int i = 0; i <length ; i++) {
        if(candies[i]+extraCandies>=max){
            ans.add(true);
        }else{
            ans.add(false);
        }
    }

    return ans;

}

//https://leetcode.com/problems/number-of-good-pairs/description/
//[1,2,3,1,1,3]
//4

int numIdenticalPairs(int[] nums) {
    int count=0;

    for (int i = 0; i < nums.length-1; i++) {
        for(int j=i+1;j<nums.length;j++){
            if(nums[i]==nums[j]){
                count++;
            }
        }

    }
    return count;

}


//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
//[8,1,2,2,3]
//[4,0,1,1,3]

int[] smallerNumbersThanCurrent(int[] nums) {

int length=nums.length;
    int[] ans= new int[length];

    for (int i = 0; i < length; i++) {
        int count=0;
        for (int j = 0; j < length; j++) {
            if(i==j) continue;
            if(nums[i]>nums[j]) count++;
        }
        ans[i]=count;
    }
    return ans;
}

//https://leetcode.com/problems/create-target-array-in-the-given-order/description/
//nums = [0,1,2,3,4], index = [0,1,2,2,1]
//[0,4,1,3,2]

int[] createTargetArray(int[] nums, int[] index) {

    int cur=-1;
    int[] ans= new int[nums.length];

    for (int i = 0; i <nums.length ; i++) {
        if(cur<index[i]){
            ans[index[i]]=nums[i];

            cur++;
        }else{
            int idx=cur;
            for(int j=idx;j>=index[i];j--){

                ans[j+1]=ans[j];
            }
            ans[index[i]]=nums[i];
            cur++;
        }

    }

    return ans;

}


//https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/
//sentence = "thequickbrownfoxjumpsoverthelazydog"
//true

boolean checkIfPangram(String sentence) {
if(sentence.length()<26) return false;

char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
int count =0;
    for (int i = 0; i < alpha.length; i++) {
        for (int j = 0; j <sentence.length() ; j++) {
            if(alpha[i]==sentence.charAt(j)){
                count++;
                break;
            }

        }
    }

    return count==26;
}

//https://leetcode.com/problems/count-items-matching-a-rule/description/
//items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
//1

int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
int count=0;
int key=-1;
if(ruleKey.equals("type")) key=0;
if(ruleKey.equals("color")) key=1;
if(ruleKey.equals("name")) key=2;

    for (int i = 0; i < items.size(); i++) {
        if(items.get(i).get(key).equals(ruleValue)){
            count++;
        }

    }


return count;
}

//https://leetcode.com/problems/find-the-highest-altitude/
// [-5,1,5,0,-7]
//1


int largestAltitude(int[] gain) {
    int highest= 0;
    int cur=0;

    for (int i = 0; i < gain.length; i++) {
        cur+=gain[i];
        if(cur>highest) highest=cur;
    }
return highest;
}

//https://leetcode.com/problems/flipping-an-image/description/
//image = [[1,1,0],[1,0,1],[0,0,0]]
//[[1,0,0],[0,1,0],[1,1,1]]

int[][] flipAndInvertImage(int[][] image) {
int[][] ans = new int[image.length][image.length];

    for (int i = 0; i < image.length; i++) {
        for (int j = image.length-1; j > -1; j--) {

            if(image[i][j]==1){
                ans[i][image.length-j-1]=0;
            }else{
                ans[i][image.length-j-1]=1;
         }

        }

    }
    return ans;
}









