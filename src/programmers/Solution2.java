// [2. 삼각 달팽이 - Level 2](https://programmers.co.kr/learn/courses/30/lessons/68645)
package programmers;

public class Solution2 {
    int i = 0;
    int j = 0;
    int k = 1;
    private int[][] down(int[][] arr, int n){
        while(true){
            arr[i][j] = k;
            i++;
            k++;
            if(i >= n || arr[i][j] != 0) break;
        }
        i--;
        j++;
        return arr;
    }
    private int[][] right(int[][] arr, int n){
        while(true){
            arr[i][j] = k;
            j++;
            k++;
            if(j >= n || arr[i][j] != 0) break;
        }
        j--;
        return arr;
    }
    private int[][] up(int[][]arr, int n){
        while(true){
            i--;
            j--;
            arr[i][j] = k;
            k++;
            if(arr[i-1][j-1] != 0) break;
        }
        i++;

        return arr;
    }

    public int[] solution(int n) {
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            if(i % 3 == 0)
                arr = down(arr,n);
            if(i % 3 == 1)
                arr = right(arr,n);
            if(i % 3 == 2)
                arr = up(arr,n);
        }
        int[] answer = new int[k-1];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[index++] = arr[i][j];
            }
        }
        return answer;
    }
}
