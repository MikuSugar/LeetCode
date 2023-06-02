package utils;

import JavaCode.linked_list.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * author:fangjie
 * time:2020/4/17
 */
public class Parse {

    public static String listNode2Str(ListNode listNode) {
        if (listNode == null) return "[]";
        final StringBuilder res = new StringBuilder();
        res.append("[");
        ListNode p = listNode;
        while (p != null) {
            res.append(p.val);
            p = p.next;
            if (p != null) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    public static int[] toIntArr(String str) {
        str = str.replaceAll("\n", "");
        // @formatter:off
        final List<String> strs = Arrays.stream(str.substring(1, str.length() - 1).split(","))
                .map(String::trim).filter(s -> !s.isEmpty()).collect(Collectors.toList());
        // @formatter:on
        final int[] res = new int[strs.size()];
        for (int i = 0; i < strs.size(); i++) res[i] = Integer.parseInt(strs.get(i));
        return res;
    }

    public static int[][] toIntTwoArr(String str) {
        char[] strs = str.substring(1, str.length() - 1).trim().replaceAll(" +", "").replaceAll("\n", "").toCharArray();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : strs) {
            if (c == '[') {
                sb = new StringBuilder();
                sb.append(c);
            } else if (c == ']') {
                sb.append(c);
                list.add(sb.toString());
            } else sb.append(c);
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = toIntArr(list.get(i));
        }
        return res;
    }


    public static char[] toCharArr(String str) {
        //['E', 'E', 'E', 'E', 'E']
        String[] strs = str.substring(1, str.length() - 1).replaceAll(" +", "").replaceAll("'", "").replaceAll("\"", "").split(",");
        char[] res = new char[strs.length];
        for (int i = 0; i < strs.length; i++) {
            res[i] = strs[i].charAt(0);
        }
        return res;
    }

    public static char[][] toCharTwoArr(String str) {
        char[] strs = str.substring(1, str.length() - 1).trim().replaceAll(" +", "").replaceAll("\n", "").toCharArray();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : strs) {
            if (c == '[') {
                sb = new StringBuilder();
                sb.append(c);
            } else if (c == ']') {
                sb.append(c);
                list.add(sb.toString());
            } else sb.append(c);
        }
        char[][] res = new char[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = toCharArr(list.get(i));
        }
        return res;
    }

    public static String[] toStrArr(String str) {
        return str.substring(1, str.length() - 1).split(",");
    }


    public static ListNode toListNodeForArrStr(String str) {
        final int[] arr = toIntArr(str);
        final ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int v : arr) {
            p.next = new ListNode(v);
            p = p.next;
        }
        return head.next;
    }

    public static ListNode toListNode(String str) {
        ListNode head = new ListNode(-1);
        String[] strs = str.split("->");
        ListNode p = head;
        for (String s : strs) {
            p.next = new ListNode(Integer.parseInt(s));
            p = p.next;
        }
        return head.next;
    }
}
