void main() {

//    System.out.println(sqrt(100));
//    System.out.println(isPerfectSquare(17));
//    System.out.println(arrangecoinBS(8));
//    System.out.println(nextGreatestLetter(new char[]{'a','b','j'},'z'));
//    System.out.println(findKthPositiveBs(new int[]{2,3,4,7,11},5));
//    System.out.println(searchInsert(new int[]{1,3,5,6},2));
//    System.out.println(peakIndexInMountainArray(new int[]{0, 2, 3, 1, 0}));
//    System.out.println(countNegatives(new int[][]{{4, 3, 2, -1},
//            {3, 2, 1, -1},
//            {1, 1, -1, -2},
//            {-1, -1, -2, -3}}));
//}

//    System.out.println(Arrays.toString(intersectionBs(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
//    System.out.println(Arrays.toString(intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
//    System.out.println(Arrays.toString(intersactionOf2Array2(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
//    System.out.println(Arrays.toString(fairCandySwapBS(new int[]{2}, new int[]{1,3})));
//    System.out.println(checkIfExist(new int[]{3,1,7,11}));
    System.out.println(specialArrayBS(new int[]{0,0}));
}

int sqrt(int num) {
    int start = 0;
    int end = num / 2;


    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (mid * mid == num) {
            return mid;
        }
        if (mid * mid < num) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return -1;
}


// int guessNumber(int n) {
//int s=0;
//int e = n;
//
//while(s<=e){
//    int mid = s+(e-s)/2;
//    if(guess(mid)==-1){
//        s=mid+1
//
//    }else if  (guess(mid)==1){
//      e=mid-1;
//    }else{
//        return mid;
//    }
//
//}
//}
//
//
//public int firstBadVersion(int n) {
//int s =1;
//int e =n;
//
//while(s<=e){
//    int mid = s+(e-s)/2;
//
//    if(!isBadVersion(mid)){
//        s=mid+1;
//    }else{
//        e=mid-1;
//    }
//
//}
//    return s;
//}

int[] twoSum(int[] numbers, int target) {
    int s = 0;
    int e = numbers.length - 1;

    while (s < e) {
        if (numbers[s] + numbers[e] == target) return new int[]{s, e};

        if (numbers[s] + numbers[e] < target) {
            s++;
        } else {
            e--;
        }
    }
    return new int[]{-1, -1};
}


boolean isPerfectSquare(int num) {
    int s = 0;
    int e = num / 2;

    while (s <= e) {
        int mid = s + (e - s) / 2;

        if (mid * mid == num) return true;
        if (mid * mid < num) {
            s = mid + 1;
        } else {
            e = mid - 1;
        }
    }
    return false;
}

int arrangeCoins(int n) {
    int row = 1;
    while (n >= row) {
        n -= row;
        row++;
    }
    return row - 1;
}

///  pattern
/// find last true in monotonic function
int arrangecoinBS(int n) {
    int s = 1;
    int e = n;
    int ans = 0;
    while (s <= e) {
        int mid = s + (e - s) / 2;
        long sum = (long) mid * (mid + 1) / 2;

        if (sum <= n) {
            ans = mid;
            s = mid + 1;
        } else {
            e = mid - 1;
        }
    }
    return ans;
}


char nextGreatestLetter(char[] letters, char target) {
    char a = 'a';
    char b = 'b';
    int s = 0;
    int e = letters.length - 1;


    while (s <= e) {
        int mid = s + (e - s) / 2;
        if (letters[mid] <= target) {
            s = mid + 1;
        } else {
            e = mid - 1;
        }
    }

    return letters[s % letters.length];
}

int findKthPositive(int[] arr, int k) {

    int n = k;
    int ans = 0;
    int checking = 1;
    int idx = 0;

    while (idx < arr.length && n >= 0) {
        if (arr[idx] != checking) {
            n--;
            ans = checking;
            checking++;
        } else {
            checking++;
            idx++;
        }
    }
    System.out.println(n);
    if (n <= 0) return --ans;
    ans = arr[arr.length - 1];

    while (n > 0) {
        ans++;
        n--;
    }
    return ans;
}

/// f(i) = arr[i] - (i + 1)
int findKthPositiveBs(int[] arr, int k) {
    int s = 0;
    int e = arr.length - 1;

    while (s <= e) {
        int mid = s + (e - s) / 2;
        if (arr[mid] - (mid + 1) >= k) {

            e = mid - 1;
        } else {
            s = mid + 1;
        }
    }
    return s + k;
}

int searchInsert(int[] nums, int target) {
    int s = 0;
    int e = nums.length - 1;

    while (s <= e) {
        int mid = s + (e - s) / 2;

        if (nums[mid] == target) return mid;

        if (nums[mid] < target) {
            s = mid + 1;
        } else {
            e = mid - 1;
        }
    }
    return s;
}

int peakIndexInMountainArray(int[] arr) {
    int s = 0;
    int e = arr.length - 1;

    while (s < e) {
        int mid = s + (e - s) / 2;

        if (arr[mid + 1] > arr[mid]) {
            s = mid + 1;
        } else {
            e = mid - 1;
        }
    }
    return s;
}

//https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
//i/p: grid = [[4,3,2,-1],
//             [3,2,1,-1],
//             [1,1,-1,-2],
//             [-1,-1,-2,-3]]
//o/p:8

int countNegatives(int[][] grid) {
    int count = 0;
    int cols = grid[0].length;

    for (int i = 0; i < grid.length; i++) {
        int s = 0;
        int e = cols - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (grid[i][mid] < 0) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        count += cols - s;
    }
    return count;
}

int countNegativeStairCase(int[][] grid) {
    int row = 0;
    int col = grid[0].length - 1;
    int count = 0;
    int rowEnd = grid.length;
    int colEnd = 0;

    while (row < rowEnd && col >= colEnd) {
        if (grid[row][col] < 0) {
            count += rowEnd - row;
            col--;
        } else {
            row++;
        }

    }
    return count;
}

//https://leetcode.com/problems/intersection-of-two-arrays/
//i/p:nums1 = [1,2,2,1], nums2 = [2,2]
//o/p:[2]

int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> ans = new HashSet<Integer>();

    for (int i = 0; i < nums1.length; i++) {

        for (int j = 0; j < nums2.length; j++) {
            if (nums1[i] == nums2[j]) {
                ans.add(nums1[i]);
            }
        }
    }
    int[] arr = new int[ans.size()];
    int index = 0;

    for (Integer value : ans) {
        arr[index++] = value.intValue();
    }
    return arr;
}

int[] intersectionBs(int[] nums1, int[] nums2){
    Arrays.sort(nums2);
    Set<Integer> ans = new HashSet<Integer>();

    for (int i = 0; i < nums1.length; i++) {
        int idx = binarySearch(nums2,nums1[i]);
        if(idx!=-1){
            ans.add(nums1[i]);
        }
    }

    int[] arr = new int[ans.size()];
    int index = 0;

    for (int value : ans) {
        arr[index++] = value;
    }
    return arr;
}

int binarySearch(int[] arr, int target){
    int s=0;
    int e=arr.length-1;
    
    while(s<=e){
        int mid = s+(e-s)/2;
        if(arr[mid]==target) return mid;
        if(arr[mid]<target){
            s=mid+1;
        }else{
            e=mid-1;
        }
    }
    return -1;
}

//https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]
int[] intersect(int[] nums1, int[] nums2) {
List ans = new ArrayList<Integer>();
Map m1 = new HashMap<Integer,Integer>();
Map m2 = new HashMap<Integer,Integer>();

Arrays.sort(nums1);
Arrays.sort(nums2);

    for (int i = 0; i < nums1.length; i++) {
        int firstIndex = getFirstAndLastPosition(nums1,nums1[i],true);
        if(firstIndex!=-1){
            int lastIndex =getFirstAndLastPosition(nums1,nums1[i],false);
            int count = (lastIndex-firstIndex)+1;
            m1.put(nums1[i],count);
        }
    }

    for (int i = 0; i < nums2.length; i++) {
        int firstIndex = getFirstAndLastPosition(nums2,nums2[i],true);
        if(firstIndex!=-1){
            int lastIndex =getFirstAndLastPosition(nums2,nums2[i],false);
            int count = (lastIndex-firstIndex)+1;
            m2.put(nums2[i],count);
        }
    }

    for (int i = 0; i < nums1.length; i++) {
        Integer firstCount = (Integer) m1.get(nums1[i]);
        if(firstCount!=null){
            Integer secondCount = (Integer) m2.get(nums1[i]);
            if(secondCount!=null){
                int times = firstCount<secondCount?firstCount:secondCount;
                for (int j = 0; j < times; j++) {
                   ans.add(nums1[i]);
                }
            }
        }
    }
 int[] arr = new int[ans.size()];

    for (int i = 0; i < ans.size(); i++) {
        arr[i] = (int) ans.get(i);
    }
    return arr;
}

int getFirstAndLastPosition(int[] arr, int target,boolean isFindingFirst){
    int s=0;
    int e=arr.length-1;
    int pos=-1;

    while (s<=e){
        int mid = s+(e-s)/2;
        if(arr[mid]==target) {
            pos = mid;
            if (isFindingFirst) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }else if(arr[mid]<target){
            s=mid+1;
        }else {
            e=mid-1;
        }
    }
    return pos;
}

int[] intersactionOf2Array2(int[] nums1, int[] nums2){
    Map m = new HashMap<Integer,Integer>();
    List ans = new ArrayList<Integer>();
    for (int i = 0; i < nums1.length; i++) {
        Integer prev =(Integer) m.get(nums1[i]);
        if(prev==null){
            m.put(nums1[i],1);
        }else {
            prev++;
            m.put(nums1[i],prev);
        }

    }

    for (int i = 0; i < nums2.length; i++) {
        Integer val = (Integer) m.get(nums2[i]);
        if(val!=null&&val!=0){
            ans.add(nums2[i]);
            val--;
            m.put(nums2[i],val);
        }
    }

    int[] arr = new int[ans.size()];

    for (int i = 0; i < ans.size(); i++) {
        arr[i] = (int) ans.get(i);
    }
    return arr;
}

//https://leetcode.com/problems/fair-candy-swap/description/
//Input: aliceSizes = [1,1], bobSizes = [2,2]
//Output: [1,2]
int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
int sum1=0;
int sum2=0;
int[] ans = new int[2];

    for (int i = 0; i < aliceSizes.length; i++) {
        sum1+= aliceSizes[i];
    }

    for (int i = 0; i < bobSizes.length; i++) {
        sum2+= bobSizes[i];
    }

    for (int i = 0; i < aliceSizes.length; i++) {
        for (int j = 0; j < bobSizes.length; j++) {
            if((sum1-aliceSizes[i])+bobSizes[j]==(sum2-bobSizes[j])+aliceSizes[i]){
                ans[0]=aliceSizes[i];
                ans[1]=bobSizes[j];
                break;
            }
        }
    }
    return ans;

}

int[] fairCandySwapBS(int[] aliceSizes, int[] bobSizes) {
int sum1=0;
int sum2=0;
int[] ans = new int[2];

    for (int i = 0; i < aliceSizes.length; i++) {
        sum1+= aliceSizes[i];
    }

    for (int i = 0; i < bobSizes.length; i++) {
        sum2+= bobSizes[i];
    }
    Arrays.sort(bobSizes);

    for (int i = 0; i < aliceSizes.length; i++) {
        int target = aliceSizes[i]-(sum1-sum2)/2;
        int ansIdx  = binarySearch(bobSizes,target);
        if(ansIdx!=-1){
            ans[0]=aliceSizes[i];
            ans[1]=bobSizes[ansIdx];
            break;
        }
    }
    return ans;

}

boolean checkIfExist(int[] arr) {
Arrays.sort(arr);

    for (int i = 0; i < arr.length; i++) {
        int idx = binarySearch(arr,arr[i]*2);
        if(idx!=-1&&idx!=i){
            return true;
        }
    }
    return false;
}

//https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
//Input: nums = [3,5]
//Output: 2

int specialArray(int[] nums) {

    for (int i = 0; i <= nums.length; i++) {
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] >= i) count++;
        }
        if(count == i) return i;
    }
    return -1;
}

int specialArrayBS(int[] nums) {
    Arrays.sort(nums);
   int s=0;
   int e= nums.length;

   while(s<=e){
       int mid = s+(e-s)/2;
       int count = findFirst(nums,mid);
       if(count==mid) return mid;
       if(count>mid){
           s=mid+1;
       }else{
           e=mid-1;
       }
   }
    return -1;
}

int findFirst(int[] arr, int target){
    int s=0;
    int e=arr.length-1;
    int firstIndex=-1;
    while(s<=e){
        int mid = s+(e-s)/2;
        if(arr[mid]>=target){
            firstIndex=mid;
            e=mid-1;
        }else{
            s=mid+1;
        }
    }
    return arr.length-firstIndex;
}

//https://leetcode.com/problems/binary-search/description/
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
int search(int[] nums, int target) {
    int s = 0;
    int e = nums.length - 1;

    while (s <= e) {
        int mid = s + (e - s) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) s = mid + 1;
        else e = mid - 1;
    }
    return -1;
}