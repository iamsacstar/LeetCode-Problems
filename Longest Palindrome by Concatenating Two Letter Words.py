"""
You are given an array of strings words. Each element of words consists of two lowercase English letters.

Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.

Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.

A palindrome is a string that reads the same forward and backward.
"""

class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        wDict = defaultdict(int)
        count = 0
        for w in words:
            if w == w[::-1] and wDict[w]:
                count +=4
                wDict[w] -=1
            elif wDict[w[::-1]] :
                count +=4
                wDict[w[::-1]] -=1
            else:
                wDict[w] +=1
        
        for w in wDict:
            if wDict[w] and w == w[::-1]:
                count +=2
                break
        return count
