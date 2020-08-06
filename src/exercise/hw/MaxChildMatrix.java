package exercise.hw;

import java.util.*;

/*
    求最大子矩阵的面积
 */
public class MaxChildMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //输入
        String numStr = scanner.nextLine();
        int n = Integer.valueOf(numStr);
        int key = 0;
        String[] matrixStrArr = new String[n];
        for (int i = 0; i < n; i++) {
            matrixStrArr[i] = scanner.nextLine();
        }
        int m = matrixStrArr[0].length();
        int[][] matix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matix[i][j] = matrixStrArr[i].charAt(j) - '0';
            }
        }

        int[][] newMatrix = rebuild(matix);
        List<Integer> arae = new ArrayList<>();
        for (int i = 0; i < newMatrix.length; i++) {
            int temp = countArea(newMatrix[i]);
            arae.add(temp);
        }
        System.out.println(Collections.max(arae));

    }

    private static int[][] rebuild(int[][] array) {
        int[][] newArray = new int[array.length][array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                int heigtht = 0;
                for (int k = i; k < array.length; k++) {
                    if (array[k][j] == 1) {
                        heigtht += 1;
                    } else {
                        break;
                    }
                }
                newArray[i][j] = heigtht;
            }
        }
        return newArray;
    }

    public static int countArea(int[] array) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(0, 0));
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= array.length; i++) {
            if (i == array.length) {
                while (stack.peek().getStartIndex() != 0) {
                    int area = (i + 1 - stack.peek().getStartIndex()) * stack.peek().getHeight();
                    list.add(area);
                    stack.pop();
                }
                return Collections.max(list);
            }
            if (array[i] >= stack.peek().getHeight()) {
                stack.push(new Node(array[i], i + 1));

            } else {
                int index = 0;

                while (array[i] < stack.peek().getHeight()) {
                    int area = (i + 1 - stack.peek().getStartIndex()) * stack.peek().getHeight();
                    list.add(area);
                    index = stack.peek().getStartIndex();
                    stack.pop();
                }
                stack.push(new Node(array[i], index));
            }
        }
        return 0;
    }
}

class Node {
    int height;
    int startIndex;

    Node(int height, int startIndex) {
        this.startIndex = startIndex;
        this.height = height;

    }

    public int getHeight() {
        return height;
    }

    public int getStartIndex() {
        return startIndex;
    }
}

