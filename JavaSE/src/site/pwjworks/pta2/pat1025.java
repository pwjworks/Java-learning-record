package site.pwjworks.pta2;

import java.util.Scanner;

public class pat1025 {
    private static int num;
    private static node[] list;
    private static node dump;

    public static void main(String[] args) {
        // init
        Scanner input = new Scanner(System.in);

        int start = input.nextInt();
        int n = input.nextInt();
        num = input.nextInt();
        list = new node[n];
        // input
        node workNode = new node(-1, -1, -1);
        for (int i = 0; i < n; i++) {
            int addr = input.nextInt();
            int data = input.nextInt();
            int next = input.nextInt();
            list[i] = new node(addr, data, next);
            if (addr == start) {
                workNode = list[i];
            }
        }
        // solution
        node p;
        node q;
        while (workNode != null) {
            p = workNode;
            q = workNode;
            int i = 0;
            // move
            for (; i < num && p != null; i++) {
                p = find(p.next);
            }
            // satisfied
            if (i == num) {
                reverse(q, p);
            }
            workNode = p;
        }
        printlist(dump);
    }

    public static void reverse(node start, node end) {
        node dumpNode = new node(-1, -1, end == null ? -1 : end.addr);
        while (start != end) {
            node tmp = find(start.next);
            // save dump
            if (tmp == end && dump == null) {
                dump = start;
            }
            start.next = dumpNode.next;
            dumpNode.next = start.addr;
            // change start
            start = tmp;
        }
    }

    public static node find(int addr) {
        for (node tmp : list) {
            if (addr == tmp.addr) {
                return tmp;
            }
        }
        return null;
    }

    public static void printlist(node dump) {
//        for (node curr : list) {
//            System.out.println(curr.addr + " " + curr.data + " " + curr.next);
//        }
        while (dump != null) {
            if (dump.next >= 0)
                System.out.format("%05d %d %05d", dump.addr, dump.data, dump.next);
            else
                System.out.format("%05d %d %d", dump.addr, dump.data, dump.next);
            System.out.println();
            dump = find(dump.next);
        }
    }
}

// node class
class node {
    int addr;
    int data;
    int next;

    public node(int addr, int data, int next) {
        this.addr = addr;
        this.data = data;
        this.next = next;
    }
}
