// [1. 교점에 별 만들기 - Level 2](https://programmers.co.kr/learn/courses/30/lessons/87377)

package programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    private static final class Point {
        public final long x,y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point intersection(long a, long b, long e, long c, long d, long f) {

        double x = (double) (b*f - e*d) / (a*d - b*c);
        double y = (double) (e*c - a*f) / (a*d - b*c);

        if(x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long) x, (long) y);
    }


    private Point getMinimumPoint(List<Point> points){
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for(Point p : points){
            if(p.x < x)
                x = p.x;
            if(p.y < y)
                y = p.y;

        }
        return new Point(x,y);
    }

    private Point getMaximumPoint(List<Point> points){
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for(Point p : points){
            if(p.x > x)
                x = p.x;
            if(p.y > y)
                y = p.y;

        }
        return new Point(x,y);
    }


    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < line.length; i++){
            for(int j = i+1; j < line.length; j++) {
                Point intersection = intersection(line[i][0],line[i][1],line[i][2]
                        ,line[j][0],line[j][1],line[j][2]);
                if(intersection != null){
                    points.add(intersection);
                }
            }
        }

        Point min = getMinimumPoint(points);
        Point max = getMaximumPoint(points);

        int xDist = (int) ((int) max.x - min.x) + 1;
        int yDist = (int) ((int) max.y - min.y) + 1;

        char[][] arr = new char[yDist][xDist];
        for (int i = 0; i < yDist; i++) {
            for (int j = 0; j < xDist; j++) {
                arr[i][j] = '.';
            }
        }

        for(Point p : points){
            arr[(int) (max.y - p.y)][(int) (p.x - min.x)] = '*';
        }

        String[] answer = new String[yDist];
        for (int i = 0; i < yDist; i++) {
            answer[i] = new String(arr[i]);
        }

        return answer;
    }
}
