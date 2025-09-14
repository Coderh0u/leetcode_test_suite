package main.java.lc.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.java.lc.ds.ListNode;
import main.java.lc.ds.TreeNode;

/**
 * Builder factory to help construct various data structures.
 * 
 * Currently supported data structures:
 * ListNode (linked list)
 * TreeNode (binary tree)
 */
public class DSFactory {
  @SuppressWarnings("unchecked")
  public <T> T build(String objectType, Object params) {
    switch (objectType) {
      case "LIST":
        return (T) buildLinkedList(params);
      case "TREE":
        return (T) buildTreeNode(params);
      default:
        throw new IllegalArgumentException("Unsupported object type: " + objectType);
    }
  }

  /**
   * Returns the head of a linked list
   * 
   * @param arr an array like of numbers
   * @return the head of a linked list
   */
  private ListNode buildLinkedList(Object params) {
    int[] arr = new int[1];
    if (params instanceof int[]) {
      arr = (int[]) params;
    } else if (params instanceof Integer[]) {
      arr = Arrays.stream((Integer[]) params).mapToInt(Integer::intValue).toArray();
    } else if (params instanceof List<?>) {
      List<?> rawList = (List<?>) params;
      if (!rawList.stream().allMatch(e -> e instanceof Integer)) {
        throw new IllegalArgumentException("List must contain Integers only.");
      }
      arr = rawList.stream().mapToInt(e -> ((Integer) e).intValue()).toArray();
    } else {
      throw new IllegalArgumentException("Unsupported param type");
    }

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
   * @param arr an array like of numbers
   * @return the root of a binary tree
   */
  private TreeNode buildTreeNode(Object params) {
    Integer[] arr = new Integer[1];
    if (params instanceof Integer[]) {
      arr = (Integer[]) params;
    } else if (params instanceof List) {
      List<?> rawList = (List<?>) params;
      if (!rawList.stream().allMatch(e -> e == null || e instanceof Integer)) {
        throw new IllegalArgumentException("Tree list must contain Integer or null only");
      }
      arr = rawList.toArray(new Integer[0]);
    } else {
      throw new IllegalArgumentException("Unsupported param type");
    }

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
    return root;
  }
}
