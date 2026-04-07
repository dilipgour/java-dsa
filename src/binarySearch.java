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

    System.out.println(Arrays.toString(intersectionBs(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
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