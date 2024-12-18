package com.nano.invi;

/*
Given array:  [1,2,3,1,2,3,4,5]
shift 1    :  [2,3,1,2,3,4,5,1]

a=[1,3,5,2]
s=[5,2,1,3]

 */
public class _24AI {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,1,2,3,4,5};
        int[] shifted = new int[]{1,2,3,4,5,1,2,3};

        System.out.println(numberOfRotations(a,shifted));
    }

    private static int numberOfRotations(int[] a, int[] shifted){
        //int result = 0;
        int i=0;
        int count=0;
        int l = a.length;
        for(int j=0;j<a.length;j++){
            int result=j;
            while(shifted[j]==a[i]){
                count=0;
                i++;
                j++;
                if(j==l)
                    return (l-result)%l;
            }
            if(count==l)
                return (l-result)%l;
            else
                i=0;
        }
        return -1;
    }
}
