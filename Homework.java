package jads.lesson3.HW;

import jads.lesson3.CW.Stack;

public class Homework {

    private static String fancyReverse(String s) {
        Stack stack = new Stack(s.length());
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char) stack.pop());
        }

        return sb.toString();
    }

    private static int bracesCheck(String expression) {
        final int TYPES = 3;
        char braces[][] = {{'(', ')'}, {'{', '}'}, {'[', ']'}};
        Stack st = new Stack(10);
        int len = expression.length();
        for (int i = 0; i < len; i++) {
            char ch = expression.charAt(i);
            for (int j = 0; j < TYPES; ++j) {
                if (ch == braces[j][0])
                    st.push(j);
            }
            for (int j = 0; j < TYPES; ++j) {
                if (ch == braces[j][1]) {
                    if (st.isEmpty())
                        return i;
                    if (j == st.peek())
                        st.pop();
                    else
                        return i;
                }
            }
        }
        if (!st.isEmpty())
            return len;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(fancyReverse("HelloWorld"));
        Deque d = new Deque(10);
        d.enqueueTail(1);
        d.enqueueTail(2);
        d.enqueueTail(3);
        System.out.println(d.dequeueHead());
        System.out.println(d.dequeueHead());
        System.out.println(d.dequeueHead());
        System.out.println("==================");
        PriorityQueue pq = new PriorityQueue(10);
        pq.insert(5);
        pq.insert(2);
        pq.insert(1);
        pq.insert(6);
        pq.insert(3);
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println();

        System.out.println(bracesCheck("(){}[]"));
        System.out.println(bracesCheck("()][]"));
        System.out.println(bracesCheck("(a)d]f[asf]df"));
    }
}
