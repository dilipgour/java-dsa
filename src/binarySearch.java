void main(){

//    System.out.println(sqrt(100));

}


int sqrt(int num){
    int start =0;
    int end = num/2;


    while(start<=end){
        int mid = start+(end-start)/2;
        if(mid*mid==num){
            return mid;
        }
        if(mid*mid<num){
            start=mid+1;
        }else{
            end=mid-1;
        }
    }
    return -1;
}