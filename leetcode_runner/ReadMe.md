# LeetCode Sandbox in Java

A lightweight Java project for experimenting with [LeetCode](https://leetcode.com/) problems.  
This sandbox makes debugging easier by letting you **print and visualize data structures** directly in the console—something that isn't easy to do on the LeetCode platform.

---

## ✨ Features

- **Custom Data Structures** (for now)

  - `ListNode` for linked list problems
  - `TreeNode` for binary tree problems

- **Utility Package (`util`)**

  - **Builder** – quickly create test data structures (e.g., build a `ListNode` from an array, a `TreeNode` from level-order input)
  - **Logger** – pretty-print data structures to the console
    - Linked lists with arrows (`1 → 2 → 3`)
    - Binary trees _(planned: ASCII/Unicode visualization for easier learning)_

- **Lightweight Setup**
  - This is intentionally lightweight (for now at least), no Maven or Gradle
  - Pure Java project, easy to open and run in IntelliJ or VS Code

---

## 🚀 Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/leetcode-sandbox-java.git
   cd leetcode-sandbox-java
   ```
