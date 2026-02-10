import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
        public static List<Integer> spiralOrder(int[][] matrix) {

            List<Integer> result = new ArrayList<Integer>();
            int m = matrix.length;
            int n = matrix[0].length;
            int iteration = 0;
            while(true){
                for(int i = iteration; i < n-iteration;i++){
                    result.add(matrix[iteration][i]);
                }
                for(int i = 1+iteration; i < m-iteration;i++){
                    result.add(matrix[i][n-1-iteration]);
                }
                if(n==1 || m==1 || result.size() >= m*n){
                    return result;
                }
                for(int i = n-2-iteration; i >= iteration;i--){
                    result.add(matrix[m-1-iteration][i]);
                }
                if( result.size() >= m*n){
                    return result;
                }
                for(int i = m-2-iteration; i >= 1+iteration;i--){
                    result.add(matrix[i][iteration]);
                }
                if(m==2 || result.size() >= m*n){
                    return result;
                }
                iteration++;
            }
        }
    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[cols*rows][2];
        int x = cStart;
        int y = rStart;
//        int valueX = 0;
//        int valueY = 0;
//        int step = 0;
//        int rotation = 0;
//        int tmp = 0;
//        for(int i=0;i<rows*cols;i++){
//            if(rotation ==0){
//                step++;
//                while(tmp<step){
//                    if(x < cols){
//                        result[i+tmp][0] = y;
//                        result[i+tmp][1] = x;
//                        x++;
//                        valueX++;
//                    } else{
//                        rotation += step;
//                        x--;
//                    }
//                    tmp++;
//                }
//                rotation = 1;
//                i += tmp-1;
//                tmp = 0;
//            }else if (rotation ==1){
//                y+= step;
//                while(tmp<step){
//                    if(y < rows){
//                        result[i+tmp][0] = y;
//                        result[i+tmp][1] = x;
//                        if(y<rows-1){
//                            y++;
//                            valueY++;
//                            rotation = 2;
//                        } else
//                        {
//                            x++;
//                            rotation=0;
//                            tmp++;
//                            break;
//                        }
//                    }
//                    tmp++;
//                }
//                i += tmp-1;
//                tmp = 0;
//            }
//            else if( rotation ==2){
//                step++;
//                tmp = step;
//                while (tmp > 0){
//                    if(x<0){
//                        x+= rotation;
//                    }
//                    result[i+step-tmp][0] = y;
//                    result[i+step-tmp][1] = x;
//                    x--;
//                    valueX--;
//                    tmp--;
//                }
//                i += step-1;
//                    valueX=0;
//                    rotation = 3;
//            }
//            else if(rotation ==3){
//                tmp = step;
//                while (tmp > 0) {
//                    if (y < 0) {
//                        y += rotation;
//                    }
//                    result[i+step-tmp][0] = y;
//                    result[i+step-tmp][1] = x;
//                    y--;
//                    valueY--;
//                    tmp--;
//                }
//                i += step-1;
//                    valueY=0;
//                    rotation = 0;
//            }else{
//                rotation=0;
//                i--;
//            }
//        }
        int route = 0;
        int direction = 0;
        int index = 1;
        int tmp;
        result[0][0] = y;
        result[0][1] = x;
        while ( index < cols*rows){
            if(direction==0){
                route++;
                tmp=0;
                while(tmp<route && index < cols*rows){
                    x++;
                    if(x>=0 && y>=0 && x<cols && y<rows){
                        result[index][0] = y;
                        result[index][1] = x;
                        index++;
                    }
                    tmp++;
                }
                direction++;
            }else if(direction==1){
                tmp=0;
                while(tmp<route && index < cols*rows){
                    y++;
                    if(x>=0 && y>=0 && y<rows && x<cols){
                        result[index][0] = y;
                        result[index][1] = x;
                        index++;
                    }
                    tmp++;
                }
                direction++;
            } else if (direction==2){
                route++;
                tmp=0;
                while(tmp<route && index < cols*rows){
                    x--;
                    if(x >=0 && y >= 0 && y<rows && x<cols){
                        result[index][0] = y;
                        result[index][1] = x;
                        index++;
                    }
                    tmp++;
                }
                direction++;
            } else{
                tmp=0;
                while(tmp<route && index < cols*rows) {
                    y--;
                    if (x >=0 && y >=0 && y<rows && x<cols) {
                        result[index][0] = y;
                        result[index][1] = x;
                        index++;
                    }
                    tmp++;
                }
                direction=0;
            }
        }
//        x++;
//        result[index][0] = y;
//        result[index][1] = x;
        return result;
    }
    public static void main(String[] args) {
        int[][] a ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20},{21,22,23,24}};
        int[][] b = {{1,2,3},{4,5,6},{7,8,9}};
//        System.out.println(spiralOrder(a));
        System.out.println(Arrays.deepToString(spiralMatrixIII(1, 4,0,0)));
        System.out.println(Arrays.deepToString(spiralMatrixIII(5,6,1, 4)));
    }
}