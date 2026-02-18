import java.sql.Array;

int reverse = 0;
int sum=0;

void main() {
//    print(100);
//    System.out.println(fact(5));
//    System.out.println(sum(5));
//    System.out.println(digitsum(111));

    //rev(123);
    int[] arr = new int[]{45, 54, 7, 4, 8, 2, 1, 4, 6, 3, 6, 4};
//    System.out.println(reverse);
//    System.out.println(reduceToZero(14));
//    System.out.println(isSorted(new int[]{1,2,5,3},0));
//    System.out.println(search(new int[]{1,2,5,3,3,3,3,3},0,3,new ArrayList()));
//    System.out.println(searchSecond(new int[]{1,2,5,3,3,3,3,3},0,3));
//    System.out.println(binarySearch(new int[]{1,2,5,3,3,3,3,5},5,0,7));
//    System.out.println(roatatedBinarySearch(new int[]{4, 5, 6, 7, 0, 1, 2},1,0,6));
//    bubbleSort(arr,0);
//    bubbleSortV2(arr,arr.length-1,0);
//
//    System.out.println(Arrays.toString(arr));
//    int [] sorted=mergeSort(arr);
//    inPlaceMergeSort(arr,0,arr.length);
//    System.out.println(Arrays.toString(arr));

//    skip("","aaabbbc");
//    subSeq("","abc");
//    subSet(new ArrayList(),arr,0);
//    permutations("","abc");
//    numberOfRolls("",6);
//    System.out.println(sum);

}

void print(int n) {
    if (n == 0) {
        return;
    }
    print(n - 1);
    System.out.println(n);
}

int fact(int n) {
    if (n == 1 || n == 0) {
        return 1;
    }
    return n * fact(n - 1);

}

int sum(int n) {
    if (n == 0) {
        return 0;
    }
    return n + sum(n - 1);

}

int digitsum(int n) {
    if (n == 0) {
        return 0;
    }
    return (n % 10) + digitsum(n / 10);

}

void rev(int n) {
    if (n == 0) {
        return;
    }
    int rem = n % 10;
    reverse = reverse * 10 + rem;
    rev(n / 10);

}

int reduceToZero(int n) {
    if (n == 0) return 0;

    if (n % 2 == 0) {
        return 1 + reduceToZero(n / 2);
    } else {
        return 1 + reduceToZero(n - 1);
    }

}

boolean isSorted(int[] arr, int index) {
    if (index == arr.length - 1) return true;

    return arr[index] < arr[index + 1] && isSorted(arr, index + 1);
}

ArrayList search(int[] arr, int index, int element, ArrayList list) {
    if (index == arr.length) return list;

    if (arr[index] == element) list.add(index);

    return search(arr, index + 1, element, list);

}

ArrayList searchSecond(int[] arr, int index, int element) {

    ArrayList list = new ArrayList();
    if (index == arr.length) return list;

    if (arr[index] == element) list.add(index);

    ArrayList ans = searchSecond(arr, index + 1, element);
    list.addAll(ans);
    return list;

}

int binarySearch(int[] arr, int element, int start, int end) {
    int mid = start + (end - start) / 2;

    if (start > end) return -1;

    if (arr[mid] < element) return binarySearch(arr, element, mid + 1, end);
    if (arr[mid] > element) return binarySearch(arr, element, start, mid - 1);
    return mid;
}


int roatatedBinarySearch(int[] arr, int element, int start, int end) {


    int mid = start + (end - start) / 2;
    if (start > end) return -1;

    if (arr[mid] == element) return mid;

    if (arr[start] <= arr[mid]) {

        if (element > arr[start] && element < arr[mid]) {
            return roatatedBinarySearch(arr, element, start, mid);
        } else {
            return roatatedBinarySearch(arr, element, mid, end);
        }
    }

    if (element > arr[mid] && element < arr[end]) {
        return roatatedBinarySearch(arr, element, mid, end);
    } else {
        return roatatedBinarySearch(arr, element, start, mid);
    }
}

void bubbleSort(int[] arr, int idx) {
    if (idx == arr.length - 1) {
        return;
    }
    for (int i = 0; i < arr.length - idx - 1; i++) {


        if (arr[i] > arr[i + 1]) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
    bubbleSort(arr, idx + 1);
}

void bubbleSortV2(int[] arr, int row, int col) {
    if (row == 0) return;

    if (col < row) {
        if (arr[col] > arr[col + 1]) {
            int temp = arr[col];
            arr[col] = arr[col + 1];
            arr[col + 1] = temp;
        }
        bubbleSortV2(arr, row, col + 1);
    } else {
        bubbleSortV2(arr, row - 1, 0);
    }

}


int[] mergeSort(int[] arr) {
    if (arr.length == 1) {
        return arr;
    }
    int mid = arr.length / 2;

    int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
    int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

    return merge(left, right);
}

int[] merge(int[] left, int[] right) {
    int i = 0;
    int j = 0;
    int k = 0;
    int[] mix = new int[left.length + right.length];

    while (i < left.length && j < right.length) {
        if (left[i] < right[j]) {
            mix[k] = left[i];
            i++;
        } else {
            mix[k] = right[j];
            j++;
        }
        k++;
    }

    while (i < left.length) {
        mix[k++] = left[i++];
    }
    while (j < right.length) {
        mix[k++] = right[j++];
    }
    return mix;
}

void inPlaceMergeSort(int[] arr, int start, int end) {
    if (end - start == 1) return;

    int mid = start + (end - start) / 2;

    inPlaceMergeSort(arr, start, mid);
    inPlaceMergeSort(arr, mid, end);
    inPlaceMerge(arr, start, mid, end);
}

void inPlaceMerge(int[] arr, int start, int mid, int end) {
    int mix[] = new int[end - start];
    int i = start;
    int j = mid;
    int k = 0;


    while (i < mid && j < end) {
        if (arr[i] < arr[j]) {
            mix[k] = arr[i];
            i++;
        } else {
            mix[k] = arr[j];
            j++;
        }
        k++;
    }

    while (i < mid) {
        mix[k] = arr[i];
        i++;
        k++;
    }
    while (j < end) {
        mix[k] = arr[j];
        j++;
        k++;
    }

    for (int l = 0; l < mix.length; l++) {
        arr[start + l] = mix[l];
    }

}


void skip(String p, String up) {
    if (up.isEmpty()) {
        System.out.println(p);
        return;
    }
    if (up.charAt(0) == 'a') {
        skip(p, up.substring(1));
    } else {
        skip(p + up.charAt(0), up.substring(1));
    }
}

void subSeq(String p, String up) {
    if (up.isEmpty()) {
        System.out.println(p);
        return;
    }
    subSeq(p + up.charAt(0), up.substring(1));
    subSeq(p, up.substring(1));
}

void subSet(ArrayList p, int[] arr, int idx) {
    if (arr.length == idx) {
        System.out.println(p.toString());
        return;
    }
    p.add(arr[idx]);
    subSet(p, arr, idx + 1);

    p.remove(p.size() - 1);
    subSet(p, arr, idx + 1);

}

void permutations(String p,String up){
    if(up.isEmpty()){
        System.out.println(p);
    return;
    }

    for (int i = 0; i <=p.length() ; i++) {

        String f = p.substring(0,i);
        String s = p.substring(i,p.length());
        permutations(f+up.charAt(0)+s,up.substring(1));
    }

}

void numberOfRolls(String p,int target){

    if(target==0){
        //System.out.println(p);
        sum++;
        return;
    }

    for (int i = 1; i < 7&&i<=target; i++) {
        numberOfRolls(p+i,target-i);
    }

}

