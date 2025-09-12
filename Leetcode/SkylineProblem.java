import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.Collections;
public class SkylineProblem {
    //Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]] Left, Right, Height
    //Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]

    public static void main(String[] args) {
        int[][] input = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        //{{0,2147483647,2147483647}};
        //{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        Arrays.sort(input, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> skyline = getSkyline(input);
        for (List list : skyline) {
            System.out.print(list + ",");
        }
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> pointList = new ArrayList<>();
        List<List<Integer>> leftEndPointList = new ArrayList<>();
        for (int[] x : buildings) {
            pointList.add(Arrays.asList(x[0],x[2]));
            pointList.add(Arrays.asList(x[1],-x[2]));
        }
        pointList.sort((a,b) -> {
            if (a.get(0).equals(b.get(0))) {
                return Integer.compare(b.get(1), a.get(1));
            }
            return Integer.compare(a.get(0), b.get(0));
        });
        
        TreeMap<Integer, Integer> heightMap = new TreeMap<>();
        heightMap.put(0, 1);
        
        for (List<Integer> p: pointList) {
            int height = p.get(1);
            int maxY = heightMap.lastKey();
            if (height > 0) { // Starting Point Handle
                heightMap.put(height, heightMap.getOrDefault(height, 0) +1);
                if (heightMap.lastKey() > maxY) {
                    leftEndPointList.add(p);
                }
            } else { // Ending Point Handle
                int end = -height;
                if (heightMap.get(end) == 1) {
                    heightMap.remove(end);
                } else {
                    heightMap.put(end, heightMap.get(end) - 1);
                }
                if (maxY != heightMap.lastKey()) {
                    leftEndPointList.add(Arrays.asList(p.get(0), heightMap.lastKey()));
                }
            }
        }
        return leftEndPointList;
    }
    /* First Approach, Taking too much time and space as the algorithm has to run through every x. (Can't handle when x is 0 to MAX_INTEGER)
    public static List<List<Integer>> getSkylineFirstSolution(int[][] buildings) {
        List<List<Integer>> leftEndPointList = new ArrayList<>();
        List<List<Integer>> highestPointList = new ArrayList<>();  // This will store each highest point from x=0 to x of last building's right point. `Storing format: {x-coordinate, y-coordinate}`
        
        for (int i=0; i<buildings[buildings.length-1][1]; i++) {
            List<Integer> buildingHeightInXPoint = new ArrayList<>();
            for (int j=0; j<buildings.length; j++) {
                if (buildings[j][0]<=i && buildings[j][1]>i) {
                    buildingHeightInXPoint.add(buildings[j][2]);
                }
            }
            List<Integer> highestPoint = new ArrayList<>();
            if (buildingHeightInXPoint.isEmpty()) {
                highestPoint.add(i);
                highestPoint.add(0);
            }
            else {
                highestPoint.add(i);
                highestPoint.add(Collections.max(buildingHeightInXPoint));
            }
            highestPointList.add(highestPoint);
        }
        List<Integer> firstLeftEndPoint = new ArrayList<>();
        firstLeftEndPoint.add(buildings[0][0]);
        firstLeftEndPoint.add(highestPointList.get(buildings[0][0]).get(1));
        leftEndPointList.add(firstLeftEndPoint);
        for (int j=firstLeftEndPoint.get(0)+1; j<highestPointList.size(); j++) {
            if (!highestPointList.get(j).get(1).equals(highestPointList.get(j-1).get(1))) {
                leftEndPointList.add(highestPointList.get(j));
            }
        }
        List<Integer> lastLeftEndPoint = new ArrayList<>();
        lastLeftEndPoint.add(buildings[buildings.length-1][1]);
        lastLeftEndPoint.add(0);
        leftEndPointList.add(lastLeftEndPoint);
        return leftEndPointList;
    }
    */
}
