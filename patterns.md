## 📊 Array & String Patterns

### 1\. Sliding Window (Variable Size)

**📝 Description:** Used to find the best (longest, shortest, etc.) subarray/substring that matches a condition. It involves a `left` and `right` pointer, where `right` expands the window and `left` contracts it.

**☕ Java Template:**

```java
import java.util.Map;
import java.util.HashMap;

public class SlidingWindowTemplate {
    public int findBestSubarray(int[] arr) {
        int left = 0;
        int bestResult = 0; // Or Integer.MAX_VALUE, etc.
        
        // Use a Map or other structure to track the window's state
        Map<Integer, Integer> windowCounts = new HashMap<>();
        
        for (int right = 0; right < arr.length; right++) {
            // 1. ADD: Add the new element (arr[right]) to the window
            // (e.g., update windowCounts)
            
            // 2. SHRINK: While the window is invalid (based on problem constraints)
            while (/* condition is invalid */) {
                // Remove the 'left' element (arr[left]) from the window
                // (e.g., update windowCounts)
                
                left++;
            }
            
            // 3. UPDATE: Window is now valid. Update the best result.
            // (e.g., bestResult = Math.max(bestResult, right - left + 1);)
        }
        
        return bestResult;
    }
}
```

**💡 Example Problems:**

  * [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
  * [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)
  * [Permutation in String](https://leetcode.com/problems/permutation-in-string/)

-----

### 2\. Two Pointers (Opposite Ends)

**📝 Description:** Uses two pointers, one at the start (`left`) and one at the end (`right`), that move towards each other. It's extremely effective on **sorted** arrays.

**☕ Java Template:**

```java
public class TwoPointersTemplate {
    public int[] findPair(int[] sortedArr, int target) {
        int left = 0;
        int right = sortedArr.length - 1;

        while (left < right) {
            int currentSum = sortedArr[left] + sortedArr[right];

            if (currentSum == target) {
                // Found it!
                return new int[]{left, right};
            } else if (currentSum < target) {
                // Sum is too small, need a bigger number
                left++;
            } else {
                // Sum is too big, need a smaller number
                right--;
            }
        }
        
        return new int[]{-1, -1}; // Or null, empty array, etc.
    }
}
```

**💡 Example Problems:**

  * [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
  * [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)
  * [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)

-----

### 3\. Prefix Sum

**📝 Description:** A pre-calculation technique. You create an array `prefixSum` where `prefixSum[i]` is the sum of all elements from `arr[0]` to `arr[i-1]`. This lets you find the sum of any subarray `[i, j]` in O(1) time.

**☕ Java Template:**

```java
public class PrefixSum {
    private int[] prefixSum;

    // 1. Build the prefix sum array
    public PrefixSum(int[] nums) {
        prefixSum = new int[nums.length + 1]; // One extra space
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    // 2. Get sum of range [i, j] (inclusive) in O(1)
    public int getRangeSum(int i, int j) {
        // Sum(i, j) = Sum(0, j) - Sum(0, i-1)
        return prefixSum[j + 1] - prefixSum[i];
    }
}
```

**💡 Example Problems:**

  * [Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/)
  * [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/) (Use Prefix Sums in a HashMap)
  * [Find Pivot Index](https://leetcode.com/problems/find-pivot-index/)

-----

## 🧭 Search & Traversal Patterns

### 4\. Binary Search

**📝 Description:** An O(log n) algorithm to find an element in a **sorted** array. It works by repeatedly dividing the search space in half.

**☕ Java Template:**

```java
public class BinarySearchTemplate {
    public int search(int[] sortedArr, int target) {
        int left = 0;
        int right = sortedArr.length - 1;

        while (left <= right) {
            // Prevents integer overflow: (left + right) / 2
            int mid = left + (right - left) / 2; 

            if (sortedArr[mid] == target) {
                return mid; // Found
            } else if (sortedArr[mid] < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }
        
        return -1; // Not found
    }
}
```

**💡 Example Problems:**

  * [Binary Search](https://leetcode.com/problems/binary-search/)
  * [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)
  * [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

-----

### 5\. Breadth-First Search (BFS)

**📝 Description:** A traversal algorithm that explores "layer by layer." It uses a **Queue** and is perfect for finding the **shortest path** in unweighted graphs or trees.

**☕ Java Template:**
(Assumes a `TreeNode` class or a graph as `Map<Node, List<Node>>`)

```java
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class BFSTemplate {
    // 'Node' can be TreeNode, an Integer, or a custom class
    public void bfs(Node startNode) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> seen = new HashSet<>();
        
        queue.offer(startNode);
        seen.add(startNode);
        
        int level = 0;

        while (!queue.isEmpty()) {
            // Process all nodes at the current level
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();

                // --- Process the node ---
                // System.out.println(currentNode.val);
                // if (isTarget(currentNode)) return level;
                // -------------------------

                for (Node neighbor : currentNode.neighbors) {
                    if (!seen.contains(neighbor)) {
                        seen.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            level++;
        }
    }
}
```

**💡 Example Problems:**

  * [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)
  * [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)
  * [Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/)

-----

### 6\. Depth-First Search (DFS) - Recursive

**📝 Description:** A traversal algorithm that explores as far down one path as possible before backtracking. It's often implemented with **recursion** (using the call stack).

**☕ Java Template:**
(Assumes a graph as `Map<Node, List<Node>>`)

```java
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DFSTemplate {
    
    private Set<Node> seen = new HashSet<>();

    public void startDfs(Node startNode, Map<Node, List<Node>> graph) {
        dfsRecursive(startNode, graph);
    }

    private void dfsRecursive(Node node, Map<Node, List<Node>> graph) {
        // 1. Base case: already visited
        if (seen.contains(node)) {
            return;
        }
        seen.add(node);

        // --- Process node (PRE-ORDER) ---
        // System.out.println(node.val);
        // --------------------------------

        for (Node neighbor : graph.get(node)) {
            dfsRecursive(neighbor, graph);
        }
        
        // --- Process node (POST-ORDER) ---
        // ---------------------------------
    }
}
```

**💡 Example Problems:**

  * [Number of Islands](https://leetcode.com/problems/number-of-islands/)
  * [Max Area of Island](https://leetcode.com/problems/max-area-of-island/)
  * [All Paths From Source to Target](https://leetcode.com/problems/all-paths-from-source-to-target/)

-----

### 7\. Backtracking

**📝 Description:** A refined DFS used to find **all possible solutions** (subsets, permutations, combinations). The key is the "choose, explore, un-choose" pattern.

**☕ Java Template:**

```java
import java.util.List;
import java.util.ArrayList;

public class BacktrackingTemplate {
    
    public List<List<Integer>> findSolutions(int[] candidates) {
        List<List<Integer>> results = new ArrayList<>();
        backtrackHelper(results, new ArrayList<>(), candidates, 0);
        return results;
    }

    private void backtrackHelper(List<List<Integer>> results, 
                                 List<Integer> currentPath, 
                                 int[] candidates, 
                                 int startIndex) {
        
        // 1. Base Case: Is this a valid, complete solution?
        if (/* is_solution(currentPath) */) {
            results.add(new ArrayList<>(currentPath)); // Add a *copy*
            return; // Stop this path
        }
        
        // 2. Base Case: Is this path a dead end?
        if (/* is_dead_end(currentPath) */) {
            return;
        }

        // 3. Explore: Iterate through all possible next choices
        for (int i = startIndex; i < candidates.length; i++) {
            int choice = candidates[i];
            
            // A. Choose: Add choice to the path
            currentPath.add(choice);

            // B. Recurse: Explore with this choice
            // (Use i+1 for unique combinations, i for reusable)
            backtrackHelper(results, currentPath, candidates, i + 1); 

            // C. Un-choose: (BACKTRACK)
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
```

**💡 Example Problems:**

  * [Subsets](https://leetcode.com/problems/subsets/)
  * [Permutations](https://leetcode.com/problems/permutations/)
  * [Combination Sum](https://leetcode.com/problems/combination-sum/)

-----

## 🧠 Optimization & Advanced

### 8\. Dynamic Programming (Top-Down Memoization)

**📝 Description:** Solves complex problems by breaking them into simpler, **overlapping subproblems**. We store the result of each subproblem in a cache (memo) to avoid re-computation.

**☕ Java Template:**

```java
import java.util.Map;
import java.util.HashMap;

public class DPTemplate {
    
    // 'memo' can be an array, 2D array, or HashMap
    // Using Integer (object) allows 'null' to mean "not computed"
    private Integer[] memo; 

    public int solve(int n) {
        memo = new Integer[n + 1];
        return dpHelper(n);
    }

    private int dpHelper(int state) {
        // 1. Base Case(s):
        if (state == 0 || state == 1) {
            return 1; // e.g., for Fibonacci/Climbing Stairs
        }
        
        // 2. Check Cache:
        if (memo[state] != null) {
            return memo[state];
        }
        
        // 3. Recurrence Relation:
        // Compute the result by breaking it into subproblems
        int result = dpHelper(state - 1) + dpHelper(state - 2);
        
        // 4. Save to Cache & Return:
        memo[state] = result;
        return result;
    }
}
```

**💡 Example Problems:**

  * [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
  * [Coin Change](https://leetcode.com/problems/coin-change/)
  * [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)

-----

### 9\. Topological Sort (Kahn's Algorithm - BFS)

**📝 Description:** Used to find a linear ordering of tasks that have **dependencies** (e.g., "task A must be done before B"). It works on Directed Acyclic Graphs (DAGs).

**☕ Java Template:**

```java
import java.util.*;

public class TopoSortTemplate {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1. Build Adjacency List (graph) and In-Degree Array
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        
        for (int[] prereq : prerequisites) {
            int child = prereq[0];
            int parent = prereq[1];
            graph.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
            inDegree[child]++;
        }

        // 2. Initialize Queue with all nodes having in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> sortedOrder = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            sortedOrder.add(node);

            // 3. "Remove" node: Decrement neighbors' in-degrees
            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    inDegree[neighbor]--;
                    
                    // 4. If neighbor now has in-degree 0, add to queue
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
                
        // 5. Check for cycle
        if (sortedOrder.size() == numCourses) {
            return sortedOrder.stream().mapToInt(i -> i).toArray();
        } else {
            return new int[]{}; // Cycle detected
        }
    }
}
```

**💡 Example Problems:**

  * [Course Schedule](https://leetcode.com/problems/course-schedule/)
  * [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)
  * [Alien Dictionary](https://leetcode.com/problems/alien-dictionary/)

-----

## 📚 Data Structure Patterns

### 10\. Heap (Top 'K' Elements)

**📝 Description:** Uses a **PriorityQueue** (Min-Heap or Max-Heap) to keep track of the largest or smallest elements. Perfect for "Top K" or "K-th Largest" problems.

**☕ Java Template:**

```java
import java.util.PriorityQueue;

public class HeapTemplate {
    
    // Finds the K largest elements
    public int findKthLargest(int[] nums, int k) {
        
        // 1. Create a Min-Heap of size K.
        // By default, PriorityQueue is a Min-Heap.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            
            // 2. If the heap is larger than k, remove the smallest element.
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
            
        // 3. The root of the Min-Heap is the K-th largest element.
        return minHeap.peek();
    }
}
```

**💡 Example Problems:**

  * [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)
  * [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)
  * [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/) (Uses one Min-Heap and one Max-Heap)

-----

### 11\. Merge Intervals

**📝 Description:** A pattern for problems involving time intervals or ranges. The core idea is to **sort the intervals by their start time** and then merge or check for overlaps.

**☕ Java Template:**

```java
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class MergeIntervalsTemplate {
    
    public int[][] merge(int[][] intervals) {
        // 1. Sort the intervals by their start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        List<int[]> merged = new ArrayList<>();
        
        for (int[] interval : intervals) {
            // If 'merged' is empty or no overlap with the last one
            if (merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(interval);
            } else {
                // Overlap exists: update the end time of the last interval
                int[] lastInterval = merged.get(merged.size() - 1);
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            }
        }
            
        return merged.toArray(new int[merged.size()][]);
    }
}
```

**💡 Example Problems:**

  * [Merge Intervals](https://leetcode.com/problems/merge-intervals/)
  * [Insert Interval](https://leetcode.com/problems/insert-interval/)
  * [Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/) (Find max overlapping intervals)