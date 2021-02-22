import java.util.ArrayList;

public class ProblemSet11 {

    public static void main(String[] args) {
        ProblemSet11 x = new ProblemSet11();
        ArrayList<Integer> a = new ArrayList<>();
//        a.add(7);
        a.add(1);
//        a.add(1);
        a.add(2);
//        a.add(6);
//        ArrayList<Integer> b = new ArrayList<>();
//        a.add(1);
        a.add(1);
        a.add(4);
        System.out.println(x.maxMirror(a));
    }

    public ArrayList<String> fizzBuzz(int start, int end) {
        if (start >= end) {
            return null;
        }

        ArrayList<String> a = new ArrayList<>();

        for (; end > start; start++) {
            if (start % 15 == 0) {
                a.add("FizzBuzz");
            } else if (start % 3 == 0) {
                a.add("Fizz");
            } else if (start % 5 == 0) {
                a.add("Buzz");
            } else {
                a.add(String.valueOf(start));
            }
        }

        return a;
    }

    public int maxSpan(ArrayList<Integer> numbers) {
        if (numbers == null) {
            return -1;
        }

        int max = 0;

        for (int i = 0; i < numbers.size(); i++) {
            max = Math.max(max, (numbers.lastIndexOf(numbers.get(i) - i)) + 1);
        }

        return max;
    }

    public ArrayList<Integer> fix34(ArrayList<Integer> numbers) {
        if (numbers == null || numbers.get(numbers.size() - 1) == 3 || numbers.indexOf(3) > numbers.indexOf(4)) {
            return null;
        }

        int threes = 0;
        int fours = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 3) {
                if (numbers.get(i + 1) == 3) {
                    return null;
                }
                threes++;
            }
            if (numbers.get(i) == 4) {
                fours++;
            }
        }
        if (threes != fours) {
            return null;
        }
        int j = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 3) {
                int x = numbers.get(i + 1);
                while (j < numbers.size() - 1 && numbers.get(j) != 4) {
                    j++;
                }
                numbers.set(i + 1, 4);
                numbers.set(j, x);
            }
        }
        return numbers;
    }

    public ArrayList<Integer> fix45(ArrayList<Integer> numbers) {
        if (numbers == null || numbers.get(numbers.size() - 1) == 4) {
            return null;
        }

        int threes = 0;
        int fours = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 4) {
                if (numbers.get(i + 1) == 4) {
                    return null;
                }
                threes++;
            }
            if (numbers.get(i) == 5) {
                fours++;
            }
        }
        if (threes != fours) {
            return null;
        }
        int j = 0;
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) == 4) {
//                System.out.print(j + ",  ");
                int x = numbers.get(i + 1);
                while (j < numbers.size() - 1 && numbers.get(j) != 5) {
                    j++;
                }
//                System.out.println(j);
                numbers.set(i + 1, 5);
                numbers.set(j, x);
                j = i + 2;
            }
        }
        return numbers;
    }

    public boolean canBalance(ArrayList<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            return false;
        }
        for (int i = 0; i < numbers.size() - 1; i++) {
            int left = 0;
            int right = 0;
            for (int j = i; j >= 0; j--) {
                left += numbers.get(j);
            }
            for (int j = i + 1; j < numbers.size(); j++) {
                right += numbers.get(j);
            }
            if (left == right) {
                return true;
            }
        }
        return false;
    }

    public boolean linearIn(ArrayList<Integer> outer, ArrayList<Integer> inner) {

        System.out.println(outer);
        System.out.println(inner);
        if (outer == null || outer.size() == 0 || inner == null || inner.size() == 0) {
            return false;
        }
        for (int i = 1; i < inner.size(); i++) {
            if (inner.get(i) < inner.get(i - 1)) {
                return false;
            }
        }
        for (int i = 1; i < outer.size(); i++) {
            if (outer.get(i) < outer.get(i - 1)) {
                return false;
            }
        }


        int j = 0;

        for (int k : outer) {
            if (k == inner.get(j)) {
                j++;
            }
            if (j == inner.size()) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Integer> squareUp(int n) {
        if (n < 0) {
            return null;
        }

        int[] a = new int[(int) Math.pow(n, 2)];

        int l = 1;
        for (int i = n - 1; a.length > 0 && i < a.length; i += n) {
            int k = 1;
            for (int j = i; j > i - n; j--) {
                if (k <= l) {a[j] = k;}
                k++;
            }
            l++;
        }

        ArrayList<Integer> b = new ArrayList<>();

        for (int i : a) {
            b.add(i);
        }

        return (b);
    }

    public ArrayList<Integer> seriesUp(int n) {
        if (n < 0) {
            return null;
        }

        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                a.add(j);
            }
        }
        return a;
    }

    public int maxMirror(ArrayList<Integer> numbers) {
        if (numbers == null) {
            return -1;
        }

        int j;
        int x;
        int count;
        int i = 0;
        int max = 0;
        while (i < numbers.size() - 1) {
            count = 0;
            x = i;
            j = numbers.size() - 1;
            while (j >= x) {
                if (numbers.get(x).equals(numbers.get(j)) && count > 0) {
                    break;
                } else {
                    count++;
                    if (x == j) {count++;}
                    x++;
                }

//                if (max < count) {
//                    max = count;
//                }
                max = Math.max(max, count);
                j--;
            }
            i++;
        }
        return max;
    }

    public int countClumps(ArrayList<Integer> numbers) {
        if (numbers == null) {
            return -1;
        }

        int clumpCount = 0;

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                clumpCount++;
                for (int j = i + 1; j < numbers.size() - 1 && numbers.get(j).equals(numbers.get(j + 1)); j++) {
                    i++;
                }
            }
        }
        return clumpCount;
    }
}
