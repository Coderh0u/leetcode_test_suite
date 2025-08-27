package main.java.lc.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.java.lc.ds.ListNode;
import main.java.lc.ds.TreeNode;

/**
 * Logger class for printing custom data structures (e.g. ListNode, TreeNode,
 * arrays) into the console
 * Useful for data structures where System.out.print() would not print something
 * meaningful
 */
public class Logger {
  /**
   * Prints an array to the console
   * 
   * @param array
   */
  public void log(Object array) {
    int length = Array.getLength(array);
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < length; i++) {
      sb.append(Array.get(array, i).toString());
      if (i < length - 1) {
        sb.append(", ");
      }
    }
    sb.append("]");
    System.out.println(sb.toString());
  }

  /**
   * Prints a linked list to the console
   * 
   * @param ListNode
   */
  public void log(ListNode head) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    while (head != null) {
      if (head.next != null) {
        sb.append(head.val);
        sb.append(" -> ");
      } else {
        sb.append(head.val);
      }
      head = head.next;
    }
    sb.append("]");
    System.out.println(sb.toString());
  }

  /**
   * Prints a binary tree to console
   * 
   * @param TreeNode
   */
  public void log(TreeNode root) {
    if (root == null) {
      System.out.println("[]");
      return;
    }

    StringBuilder sb = new StringBuilder();
    sb.append("[");

    List<Integer> ls = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      if (curr != null) {
        ls.add(curr.val);
        queue.add(curr.left);
        queue.add(curr.right);
      } else {
        ls.add(null);
      }
    }

    int last = ls.size() - 1;
    while (last >= 0 && ls.get(last) == null) {
      last--;
    }

    for (int i = 0; i <= last; i++) {
      sb.append(ls.get(i));
      if (i != last) {
        sb.append(", ");
      }
    }
    sb.append("]");

    System.out.println(sb.toString());
  }

}
