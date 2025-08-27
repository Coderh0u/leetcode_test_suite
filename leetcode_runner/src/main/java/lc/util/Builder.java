package main.java.lc.util;

import java.util.LinkedList;
import java.util.Queue;

import main.java.lc.ds.ListNode;
import main.java.lc.ds.TreeNode;

/**
 * Builder utility to help construct various data structures.
 * 
 * Currently supported data structures:
 * ListNode (linked list)
 * TreeNode (binary tree)
 */
public class Builder {
  /**
   * Returns the head of a linked list
   * 
   * @param arr an array of type int
   * @return the head of a linked list
   */
  public ListNode buildLinkedList(int[] arr) {
    ListNode list = new ListNode(0);
    ListNode start = list;
    for (int i : arr) {
      ListNode curr = new ListNode(i);
      start.next = curr;
      start = start.next;
    }
    return list.next;
  }

  /**
   * Returns the root of a binary tree
   * 
   * @param arr an array of type Integer
   * @return the root of a binary tree
   */
  public TreeNode buildTreeNode(Integer[] arr) {
    if (arr.length == 0) {
      return null;
    }
    if (arr[0] == null) {
      return null;
    }
    TreeNode root = new TreeNode(arr[0]);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int i = 1;
    while (!queue.isEmpty() && i < arr.length) {
      TreeNode curr = queue.poll();
      if (i < arr.length && arr[i] != null) {
        TreeNode left = new TreeNode(arr[i]);
        queue.add(left);
        curr.left = left;
      }
      i++;
      if (i < arr.length && arr[i] != null) {
        TreeNode right = new TreeNode(arr[i]);
        queue.add(right);
        curr.right = right;
      }
      i++;
    }
    System.out.println("built");
    return root;
  }
}
