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
//    int[] nums = {0,1,2,3,4}, index = {0,1,2,2,1};

//  System.out.println(Arrays.toString(shuffleArray(arr,3)));

//  System.out.println(kidsWithCandies(arr,3));
//  System.out.println(numIdenticalPairs(arr));
//  System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
//  System.out.println(Arrays.toString(createTargetArray(nums,index)));
//  System.out.println(checkIfPangram("leet"));

//    List<List<String>> items = List.of(
//            List.of("phone", "blue", "pixel"),
//            List.of("computer", "silver", "lenovo"),
//            List.of("phone", "gold", "iphone")
//    );
//    String ruleKey = "color", ruleValue = "silver";

//    System.out.println(countMatches(items,ruleKey,ruleValue));
//    System.out.println(largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
//    int[][] ans = flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}});
//    for (int i = 0; i < ans.length; i++) {
//        System.out.println(Arrays.toString(ans[i]));
//    }
//    System.out.println(oddCells( 2,  3, new int[][]{{0,1},{1,1}}));

//    int[][] mat = {{1,1,1,1},
//                   {1,1,1,1},
//            {1,1,1,1},
//            {1,1,1,1}};
//
//    System.out.println(diagonalSum(mat));

//    System.out.println(findNumbers(new int[] {555,901,482,1771}));

//    int[][] ans = transpose(new int[][]{{1,2,3},{4,5,6}});
//
//    for (int i = 0; i < ans.length; i++) {
//        System.out.println(Arrays.toString(ans[i]));
//    }
//

//    System.out.println(addToArrayForm(new int[]{2,7,4}, 181));

//    System.out.println(maximumPopulation(new int[][]{{1993,1999},{2000,2010}}));


//    System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}  ,9)));

//    System.out.println(Arrays.toString(sumZero(5)));

//    System.out.println(luckyNumbers(new int[][] {{3,7},{9,11},{15,16}}));

//    System.out.println(maxSubArray(new int[]{
//            -2,1,-3,4,-1,2,1,-5,4}));

//    int[][] ans = matrixReshape(new int[][] {{1,2,3,4},{5,6,7,8}}, 4, 2);
//
//    for (int i = 0; i < ans.length; i++) {
//        System.out.println(Arrays.toString(ans[i]));
//    }


//    System.out.println(Arrays.toString(plusOne(new int[]{1,2,3})));

//    System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));

//    System.out.println(minCostToMoveChips(new int[]{2,2,2,3,3}));

//    System.out.println(findRotation(new int[][]{{0,1},{1,0}}, new int[][]{{1,0},{0,1}}));

    System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));



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


//https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/description/
//m = 2, n = 3, indices = [[0,1],[1,1]]
//6

int oddCells(int m, int n, int[][] indices) {
    int count =  0;
    int[][] mat = new int[m][n];

    for (int i = 0; i <indices.length ; i++) {
        for (int j = 0; j < n; j++) {
            mat[indices[i][0]][j]++;
        }

        for (int j = 0; j < m; j++) {
            mat[j][indices[i][1]]++;
        }
    }
    for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < mat[i].length; j++) {
            if(mat[i][j]%2!=0) count++;
        }

    }

    return count;
}


//https://leetcode.com/problems/matrix-diagonal-sum/description/
//mat = [[1,2,3],
//       [4,5,6],
//       [7,8,9]]
//25

int diagonalSum(int[][] mat) {
int sum=0;

    for (int i = 0; i < mat.length; i++) {
        sum+= mat[i][i];
        sum+=mat[i][mat.length-i-1];

    }

    if(mat.length%2!=0){
        sum-= mat[mat.length/2][mat.length/2];
    }
    return sum;
}

//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
//nums = [12,345,2,6,7896]
//2

int findNumbers(int[] nums) {
    int count=0;
    for (int i = 0; i < nums.length; i++) {
        if(countdigit(nums[i])%2==0) count++;

    }
    return count;

}

int countdigit(int n){
    return (int)Math.floor(Math.log10(n) + 1);
}


//https://leetcode.com/problems/transpose-matrix/description/
//matrix = [[1,2,3],[4,5,6],[7,8,9]]
// [[1,4,7],[2,5,8],[3,6,9]]

int[][] transpose(int[][] matrix) {
int[][] ans = new int[matrix[0].length][matrix.length];

    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            ans[j][i]= matrix[i][j];
        }
    }
    return ans;
}

//https://leetcode.com/problems/add-to-array-form-of-integer/description/
//num = [1,2,0,0], k = 34
// [1,2,3,4]

List<Integer> addToArrayForm(int[] num, int k) {
    List<Integer> ans = new ArrayList<>();
    int i = num.length - 1;
    int carry = 0;

    while (i >= 0 || k > 0 || carry > 0) {
        int sum = carry;

        if (i >= 0) {
            sum += num[i];
            i--;
        }

        if (k > 0) {
            sum += k % 10;
            k /= 10;
        }

        ans.add(sum % 10);
        carry = sum / 10;
    }

    Collections.reverse(ans);
    return ans;
}


//https://leetcode.com/problems/maximum-population-year/description/
//logs = [[1993,1999],[2000,2010]]
//1993

int maximumPopulation(int[][] logs) {
int[] arr = new int[101];

    for (int i = 0; i < logs.length; i++) {
        for (int j = logs[i][0]; j <logs[i][1] ; j++) {
            arr[j-1950]++;

        }
    }
    int maxval=0;
    int maxyear=1950;

    for (int i = 0; i < arr.length; i++) {
        if(arr[i]>maxval){
            maxval=arr[i];
            maxyear=i+1950;
        }
    }

    return maxyear;
}

//https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/
//could not done

//https://leetcode.com/problems/two-sum/
//nums = [2,7,11,15]  target = 9
//[0,1]

    int[] twoSum(int[] nums, int target) {
     int[] ans= new int[2];

        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]+nums[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }

            }
        }
        return nums;
    }
//https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/
//n = 5
// [-7,-1,1,3,4]
int[] sumZero(int n) {
int[] ans= new int[n];
int sum=0;

    for (int i = 0; i < n-1; i++) {
        ans[i]= i+1;
        sum+= i+1;
    }
    sum*=-1;
    ans[n-1]=sum;
    return ans;
}


//https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/
//matrix = [[3,7,8],[9,11,13],[15,16,17]]
// [15]

List<Integer> luckyNumbers(int[][] matrix) {
List<Integer> ans = new ArrayList<>();

    for (int i = 0; i < matrix.length; i++) {
        int rowmin=Integer.MAX_VALUE;
        int colindex=0;
        for (int j = 0; j < matrix[i].length; j++) {
            if(matrix[i][j]<rowmin) {
                rowmin=matrix[i][j];
                colindex=j;
            }

        }
//        System.out.println(rowmin);
//        System.out.println(colindex);

        boolean isLucky = true;
        for (int j = 0; j < matrix.length; j++) {
         if(matrix[j][colindex]>rowmin) isLucky=false;

        }
     if(isLucky) ans.add(rowmin);

    }
    return ans;
}

//https://leetcode.com/problems/maximum-subarray/description/
//nums = [-2,1,-3,4,-1,2,1,-5,4]
// 6

int maxSubArray(int[] nums) {
    int max=0;

    for (int i = 0; i <nums.length ; i++) {
        int cursum=0;
        for (int j = i; j <nums.length-1 ; j++) {
            cursum+=nums[j];
            max=Math.max(cursum,max);

        }
    }
return max;
}

//https://leetcode.com/problems/reshape-the-matrix/description/
//mat = [[1,2],[3,4]], r = 1, c = 4
//[[1,2,3,4]]

int[][] matrixReshape(int[][] mat, int r, int c) {
    if(r*c!=mat.length*mat[0].length){
        return mat;
    }

 int[][] ans = new int[r][c];
 int row=0;
 int col=0;

    for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < mat[i].length; j++) {

            if(col==c){
                col=0;
                row++;

            }
            ans[row][col++]=mat[i][j];
        }

    }
    return ans;

}

//https://leetcode.com/problems/plus-one/
//digits = [1,2,3]
//[1,2,4]

int[] plusOne(int[] digits) {
    int length = digits.length;


    for (int i = length-1; i > -1; i--) {

        if(digits[i]+1>9){
            digits[i]=0;
        }else{
          digits[i]++;
          return digits;
        }

    }
        int[] ans = new int[digits.length+1];
        ans[0]= 1;
        for (int i =0 ; i < length ; i++) {
            ans[i+1]=digits[i];
        }



     return ans;
}


//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
//[1,1,2]
//2
int removeDuplicates(int[] nums) {
    if(nums.length==0) {
        return 0;
    }

    int placeToreplace=1;

    for (int i = 1; i < nums.length; i++) {
        if(nums[i]!=nums[placeToreplace-1]){
            nums[placeToreplace]=nums[i];
            placeToreplace++;
        }
    }

return placeToreplace;
}

//https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
//position = [1,2,3]
//1

int minCostToMoveChips(int[] position) {
int totalodd=0;
int totaleven=0;

    for (int i = 0; i < position.length; i++) {
        if(position[i]%2==0){
            totaleven++;
        }else{
            totalodd++;
        }

    }

    return Math.min(totaleven,totalodd);

}

//https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/
//mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
//true
boolean findRotation(int[][] mat, int[][] target) {
    int n= mat.length;
    for (int i = 0; i < 5; i++) {
        if(isEqual(mat,target)) return true;
        mat=rotate90(mat);

    }
    return false;

}

boolean isEqual(int[][] mat1, int[][] mat2){
    int n= mat1.length;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if(mat1[i][j]!=mat2[i][j]){
                return false;
            }
        }
    }
    return true;
}

int[][] rotate90(int[][] mat){
    int n= mat.length;
    int[][] ans = new int[n][n];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            ans[j][n-i-1] = mat[i][j];
        }
    }
    return ans;
}

//List<Integer> spiralOrder(int[][] matrix) {
//    List<Integer> ans = new ArrayList<>();
//    int i=0;
//    int j=0;
//    int rightmost=matrix[0].length;
//    int leftmost = -1;
//    int bottommost = matrix.length;
//
//    while(j<rightmost){
//        ans.add(matrix[i][j]);
//        j++;
//    }
//    j--;
//    i++;
//    while(i<bottommost){
//        ans.add(matrix[i][j]);
//        i++;
//    }
//    i--;
//    j--;
//    while(j>leftmost){
//        ans.add(matrix[i][j]);
//        j--;
//    }
//    int topmost=0;
//    j++;
//    i--;
//    while(i>topmost){
//        ans.add(matrix[i][j]);
//        i--;
//    }
//    j++;
//    i++;
//    while(j<rightmost-1){
//        ans.add(matrix[i][j]);
//        j++;
//    }
//
//    return ans;
//}

List<Integer> spiralOrder(int[][] matrix) {
    int top=0;
    int bottom = matrix.length-1;
    int left=0;
    int right=matrix[0].length-1;
    List<Integer> ans = new ArrayList<>();

    for (int i = left; i <=right ; i++) {
        ans.add(matrix[top][i]);
    }
    top++;
    for (int i = top; i <= bottom; i++) {
        ans.add(matrix[i][right]);
    }
    right--;
    for (int i = right; i >left ; i--) {
        ans.add(matrix[bottom][i]);
    }
    bottom--;

    return ans;
}
