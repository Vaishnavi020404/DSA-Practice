# 📚 DSA Practice Repository

This repository contains my daily Data Structures & Algorithms practice solutions, focusing on Java and LeetCode problems.  
I am following Kunal Kushwaha's "Java + DSA + Interview Preparation Course" on Youtube.

---

✅ **Goals:**
- Strengthen problem-solving skills
- Prepare for product-based and service-based companies
- Consistent daily coding

---

I have already solved a few problems on Leetcode on arrays and other basic concepts on my machine which will be added to this repository shortly.

---

## ✅ Example Problem Format

Each problem file includes:
- Problem title and LeetCode link
- Time and space complexity
- Java solution with main method (for testing) and the approaches used to solve the problem.

---

## ⚙️ How to Run

- Clone this repository:
  `git clone https://github.com/Vaishnavi020404/DSA-Practice.git`
- Open in your IDE (VS Code, IntelliJ, etc.)
- Compile and run Java files individually.

---

## ⭐ Contributions

This repo is mainly for my personal practice.
Feedback and suggestions are welcome!

---

Abbreviations used to avoid writing long names for files:
1.Leetcode 33 and 81:
SIRSA-SearchingInRotatedSortingArray
SIRSAD-SearchingInRotatedSortingArrayWithDuplicates 

🔹 Problem 33 — LeetCode Search in Rotated Sorted Array
Input: Distinct integers only

Return Type: int — index of target, or -1 if not found

No duplicates

Binary Search + Pivot logic

🔹Problem 81 — LeetCode Search in Rotated Sorted Array II
Input: Integers (can contain duplicates)

Return Type: boolean — true if found, false if not

Duplicates allowed

Binary Search + Duplicates Handling


---

NOTES given by My dear Chatgpt for a sundar code:(I have not implemented the techniques of this type of code through out ,but I started doing it consistently after the creation of Arrays folder.)
1️⃣ Naming Conventions
| Type           | Style                       | Example                                |
| -------------- | --------------------------- | -------------------------------------- |
| Class          | PascalCase                  | `ContainsDuplicates`, `LinkedListNode` |
| Method         | camelCase                   | `containsDuplicatesUsingHashSet()`     |
| Boolean Method | camelCase + is/has/contains | `hasDuplicate()`, `isSorted()`         |
| Variable       | camelCase, meaningful       | `nums`, `count`, `set`, `index`        |
| Constant       | ALL\_CAPS                   | `MAX_SIZE`, `DEFAULT_TIMEOUT`          |


Rule: names should reflect purpose clearly.

2️⃣ Code Formatting

Indent 4 spaces per level.

Leave blank lines between logical sections (input, processing, output).

Keep line length ≤ 100 chars if possible.

Group related code together.

Example:

Scanner sc = new Scanner(System.in); // Input section

int n = sc.nextInt();
int[] nums = new int[n];

for (int i = 0; i < n; i++) {
    nums[i] = sc.nextInt();
}

3️⃣ Commenting

Header comments: Problem, link, date, approach, complexity.

Section comments: Input / Processing / Output.

Method comments: Purpose, approach, complexity.

Inline comments: Only for non-obvious steps.

Example:

// Approach 1: Using HashSet to track seen numbers
// Returns true if any duplicate exists
static boolean containsDuplicatesUsingHashSet(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) {
        if (set.contains(num)) return true; // Duplicate found
        set.add(num);
    }
    return false; // No duplicates
}

4️⃣ Structure

Header comment

Imports

Class declaration

Main method

Input section

Processing section

Output section

Helper methods (approaches, utils)

5️⃣ Optional Enhancements

Close resources (like Scanner).

Consistent naming (don’t switch num → val).

Use descriptive boolean names: isDuplicateFound instead of res.






