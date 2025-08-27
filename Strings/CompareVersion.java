// Date: Tuesday, August 25, 2025
// Problem: Compare Version Numbers (LeetCode 165)-> https://leetcode.com/problems/compare-version-numbers/description/
// Description:
// Given two version strings, version1 and version2, compare them revision by revision.
// Return -1 if version1 < version2, 1 if version1 > version2, and 0 if they are equal.
// Missing revisions are treated as 0. Leading zeros are ignored.
//
// Approach (Brute Force):
// 1. Split both version strings by "." to get arrays of revisions.
// 2. Loop through the maximum length of the two arrays.
// 3. Convert each revision to integer (Integer.parseInt) to ignore leading zeros.
// 4. Compare revisions one by one.
// 5. Return -1 / 1 at first difference. If all equal, return 0.
//
// Time Complexity: O(N + M) → N = length of version1, M = length of version2
// Space Complexity: O(N + M) → arrays for storing split strings

import java.util.Scanner;

public class CompareVersion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter version1: ");
        String version1 = sc.nextLine();

        System.out.print("Enter version2: ");
        String version2 = sc.nextLine();

        int result = compareVersion(version1, version2);

        System.out.println("Comparison result: " + result);

    }

    //BRUTE-FORCE
    public static int compareVersion(String version1, String version2) {
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");

        int n = Math.max(parts1.length, parts2.length);

        for (int i = 0; i < n; i++) {
            int num1 = i < parts1.length ? Integer.parseInt(parts1[i]) : 0;
            int num2 = i < parts2.length ? Integer.parseInt(parts2[i]) : 0;

            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
        }

        return 0;
    }

    //OPTIMIZED
}

