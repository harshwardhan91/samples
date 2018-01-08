package com.local;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Test {
    boolean compareInterval(Interval i1, Interval i2) {
        return(i1.start < i2.start);
    };

    int mergeIntervals(Interval arr[], int n) {
        // Test if the given set has at least one interval
        if (n <= 0)
            return 0;

        // Create an empty stack of intervals
        Stack<Interval> s = new Stack<>();

        // sort the intervals in increasing order of start time
        // sort(arr, arr+n, compareInterval);
        Arrays.sort(arr, (o1, o2) -> {
            return o1.start - o2.start;
        });
        // push the first interval to stack
        s.push(arr[0]);

        // Start from the next interval and merge if necessary
        for (int i = 1; i < n; i++) {
            // get interval from stack top
            Interval top = s.peek();

            // if current interval is not overlapping with stack top,
            // push it to the stack
            if (top.end < arr[i].start)
                s.push(arr[i]);

                // Otherwise update the ending time of top if ending of current
                // interval is more
            else if (top.end < arr[i].end) {
                top.end = arr[i].end;
                s.pop();
                s.push(top);
            }
        }

        // Print contents of stack

        int count = 0;
        while (!s.empty()) {
            Interval t = s.peek();
            count += (t.end - t.start + 1);
            s.pop();
        }
        System.out.println(count);
        return count;
    }

    public int mainq() {
        Scanner in = new Scanner(System.in);
        int numberOfUbers = in.nextInt();
        Interval[] arr = new Interval[numberOfUbers];
        for(int i=0;i<numberOfUbers;i++){
            Interval interval = new Interval(in.nextInt(), in.nextInt());
            arr[i] = interval;
        }
        return mergeIntervals(arr, numberOfUbers);
    }

    class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args){
        Test test = new Test();
        System.out.println(test.mainq());
    }
}