---
title: "Manacher's Algorithm"
description: 'Helps in finding longest palindromic substring in linear time'
keywords:
  - leetcode
  - tutorial
  - manacher
  - algorithm
---


# Overview

There are many ways to find the `longest palindromic substring`. One can find it in $O(N ^ 3)$ and also in $O(N ^ 2)$ time complexity. But using `Manacher's Algorithm` we do it in `O(N) time`. This algorithm was discovered by `Glenn K. Manacher` in 1975.

First of all we need to understand that what is a substring. So, a substring is basically contiguous part of any array or string. For example: $square$ is a substring of string $abigsquare$

And secondly what is a palindrome. So, a palindrome is any word or phrase that reads the same backwards as forwards. For example: $madam$, $a nut for a jar of tuna$ etc.

Given a string, find the longest substring which is palindrome. 

* if the given string is $iplayracecar$, the output should be $racecar$
* if the given string is $acacacb$, the output should be $acacacb$
* if the given string is $abababa$, the output should be $abababa$
* if the given string is $findnishi$, the output should be $indni$

* ## Brute force Approach $O(N ^ 3)$ time

```java

import java.util.*;

class Manacher{
    
    // A function to print a substring.
    static void printSubstring(String str, int left, int right){
        for (int i = left; i <= right; i++)
            System.out.print(str.charAt(i));
    }
    
    // # A function to get the longest palindromic
    // substring in the a given string using Brute Force Approach
    static void longestPalSubstring(String str){
        // Getting length of the input string
        int n = str.length();

        // All substrings of length 1 are palindromes
        int maxLength = 1, start = 0;

        // Checking all the substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int flag = 1;

                // Checking for a palindromic subtring
                for (int k = 0; k < (j - i + 1) / 2; k++)
                    if (str.charAt(i + k) != str.charAt(j - k))
                        flag = 0;

                // If substring is palindromic
                if (flag!=0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }

        // Printing the longest Palindromic substring
        System.out.print("The Longest Palindromic Substring is: ");
        printSubstring(str, start, start + maxLength - 1);
    }
    
    // Driver Code
    public static void main(String[] args) {
        String str = "ppasaippuakivikauppiaska";
        longestPalSubstring(str);
    }
}

```
### Input: 
ppasaippuakivikauppiaska

### Output: 
The Longest Palindromic Substring is: saippuakivikauppias

> `saippuakivikauppias` is the longest known palindromic word (19 letters)

### Time complexity 
$O(N ^ 3)$

Since, three nested loops are used here so the time complexity of finding longest palindromic substring will be $O(N ^ 3)$.

### Space complexity
$O(1)$

No extra space is needed in this approach, so the space complexity will be $O(1)$.

## Manacher's Algorithm
 
`Manacher's Algorithm` is way faster than the brute force approach to find the longest substring, because it uses the precomputed data. Hence, making the algorithm run in linear time. 

One important point that we need to keep in mind is that using Manacher's Algorithm we can find the palindromic substrings of odd length string or array only. To find palindromic substrings of even length string or array, we need to do a slight change in the given input i.e. in the given input string we insert "#" character at the beginning and also at each alternate position(changing $level$ to _#l#e#v#e#l#_).

In the case of an odd length palindrome, we will surround the middle character of the string with "#"

Example: string = $abbba$ -> _ab#b#ba_

In the case of an even length palindrome, the middle character will be a "#" character.

Example: string = $aaccccaa$ -> _#a#a#c#c#c#c#a#a#_ . Here, we can see that the middle character will come out to be a "#"

#### Implementation -

```java

import java.util.*;
 
class string
{
    static void findLongestPalindromicString(String text)
    {
        int N = text.length();
        if (N == 0)
            return;
        N = 2 * N + 1; // Position count
        int[] L = new int[N + 1]; // LPS Length Array
        L[0] = 0;
        L[1] = 1;
        int C = 1; // centerPosition
        int R = 2; // centerRightPosition
        int i = 0; // currentRightPosition
        int iMirror; // currentLeftPosition
        int maxLPSLength = 0;
        int maxLPSCenterPosition = 0;
        int start = -1;
        int end = -1;
        int diff = -1;
 
        // Uncomment it to print LPS Length array
        // printf("%d %d ", L[0], L[1]);
        for (i = 2; i < N; i++)
        {
 
            // get currentLeftPosition iMirror
            // for currentRightPosition i
            iMirror = 2 * C - i;
            L[i] = 0;
            diff = R - i;
 
            // If currentRightPosition i is within
            // centerRightPosition R
            if (diff > 0)
                L[i] = Math.min(L[iMirror], diff);
 
            // Attempt to expand palindrome centered at
            // currentRightPosition i. Here for odd positions,
            // we compare characters and if match then
            // increment LPS Length by ONE. If even position,
            // we just increment LPS by ONE without
            // any character comparison
            while (((i + L[i]) + 1 < N && (i - L[i]) > 0) &&
                               (((i + L[i] + 1) % 2 == 0) ||
                         (text.charAt((i + L[i] + 1) / 2) ==
                          text.charAt((i - L[i] - 1) / 2))))
            {
                L[i]++;
            }
 
            if (L[i] > maxLPSLength) // Track maxLPSLength
            {
                maxLPSLength = L[i];
                maxLPSCenterPosition = i;
            }
 
            // If palindrome centered at currentRightPosition i
            // expand beyond centerRightPosition R,
            // adjust centerPosition C based on expanded palindrome.
            if (i + L[i] > R)
            {
                C = i;
                R = i + L[i];
            }
 
            // Uncomment it to print LPS Length array
            // printf("%d ", L[i]);
        }
 
        start = (maxLPSCenterPosition - maxLPSLength) / 2;
        end = start + maxLPSLength - 1;
        System.out.printf("The Longest Palindromic Substring is: ", text);
        for (i = start; i <= end; i++)
            System.out.print(text.charAt(i));
        System.out.println();
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        String text = "upthelevel";
        findLongestPalindromicString(text);
    }
}
```
### Input: 
upthelevel

### Output: 
The Longest Palindromic Substring is: level

### Time Complexity Analysis of Manacher's Algorithm
$O(N)$

At first one might think that the algorithm has $O(N ^ 2)$ time complexity because there is a for loop inside which a while loop is nested. But on seeing clearly we can observe that as we move ahead doing the comparisons the R always increases by one, it never decreases.  

Other parts of Manacher's Algorithm run in $O(N)$ time. So, overall complexity is $O(N)$.

### Space Complexity
$O(N)$

$O(N)$ because we just need an extra array Plen to store the length of longest Palindromic substring found.

----

To make you understand better `Manacher's Algorithm`, we can do one `Leetcode question` on it.

<ins>Problem Title</ins> : Longest Palindromic Substring

<ins>Difficulty Level</ins> : Medium

<ins>Problem Link</ins> : https://leetcode.com/problems/longest-palindromic-substring/

<ins>Problem Statement</ins> : Given a string s, return the longest palindromic substring in s.

A string is called a palindrome string if the reverse of that string is the same as the original string.

<ins>Example 1</ins> :

Input: s = $babad$

Output: $bab$

Explanation: $aba$ is also a valid answer.

<ins>Example 2</ins> :

Input: s = $cbbd$

Output: $bb$

<ins>Solution</ins> : We can do this problem using the same approach as mentioned in the above algorithm. This problem states to find the longest palindromic substring which indeed is the `Manacher's Algorithm`. Hence, we can directly apply it here.

Here we will try to implement the algorithm using array and following the same algorithm as stated above. 

```java

import java.util.*;
 
class string
{
    static void findLongestPalindromicString(String text)
    {
        int N = text.length();
        if (N == 0)
            return;
        N = 2 * N + 1; // Position count
        int[] L = new int[N + 1]; // LPS Length Array
        L[0] = 0;
        L[1] = 1;
        int C = 1; // centerPosition
        int R = 2; // centerRightPosition
        int i = 0; // currentRightPosition
        int iMirror; // currentLeftPosition
        int maxLPSLength = 0;
        int maxLPSCenterPosition = 0;
        int start = -1;
        int end = -1;
        int diff = -1;
 
        // Uncomment it to print LPS Length array
        // printf("%d %d ", L[0], L[1]);
        for (i = 2; i < N; i++)
        {
 
            // get currentLeftPosition iMirror
            // for currentRightPosition i
            iMirror = 2 * C - i;
            L[i] = 0;
            diff = R - i;
 
            // If currentRightPosition i is within
            // centerRightPosition R
            if (diff > 0)
                L[i] = Math.min(L[iMirror], diff);
 
            // Attempt to expand palindrome centered at
            // currentRightPosition i. Here for odd positions,
            // we compare characters and if match then
            // increment LPS Length by ONE. If even position,
            // we just increment LPS by ONE without
            // any character comparison
            while (((i + L[i]) + 1 < N && (i - L[i]) > 0) &&
                               (((i + L[i] + 1) % 2 == 0) ||
                         (text.charAt((i + L[i] + 1) / 2) ==
                          text.charAt((i - L[i] - 1) / 2))))
            {
                L[i]++;
            }
 
            if (L[i] > maxLPSLength) // Track maxLPSLength
            {
                maxLPSLength = L[i];
                maxLPSCenterPosition = i;
            }
 
            // If palindrome centered at currentRightPosition i
            // expand beyond centerRightPosition R,
            // adjust centerPosition C based on expanded palindrome.
            if (i + L[i] > R)
            {
                C = i;
                R = i + L[i];
            }
 
            // Uncomment it to print LPS Length array
            // printf("%d ", L[i]);
        }
 
        start = (maxLPSCenterPosition - maxLPSLength) / 2;
        end = start + maxLPSLength - 1;
        System.out.printf("The Longest Palindromic Substring is: ", text);
        for (i = start; i <= end; i++)
            System.out.print(text.charAt(i));
        System.out.println();
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        String text = "upthelevel";
        findLongestPalindromicString(text);
    }
}

```
* Some suggested problems for `Manacher's Algorithm`-

| Problem Title        | Difficulty |
| ---------------- | ---------- |
| [214 - Shortest Palindrome](https://leetcode.com/problems/shortest-palindrome/) | Hard   | 


## Authors

- [@wizeewig](https://www.github.com/wizeewig)
