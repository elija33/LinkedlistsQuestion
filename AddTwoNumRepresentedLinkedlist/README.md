# LinkedlistsQuestion

Given two positive integers represented as two singly linked lists of digits, implement a function to add the two numbers and produce the sum also as a singly linked list of digits.

Sample Inputs --- Expected Outputs

linked A : 1-->2-->3
linked B : 4-->5-->6
linked C = linked A + linked
linked C = 5-->7-->9

Example 2:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)

Output: 7 -> 0 -> 8

Explanation: 
Input: 3-->4-->2 + 4-->6-->5 = 8-->0-->7.

                                                
                                                Approach
Traverse two linked lists.
In each iteration, add the numbers in the nodes of the linked lists
If the lists are unequal, then the smaller one will end before the longer. In this case, we will put only the remaining nodes of the longer list in the resultant list
If the sum of two digits is greater than 9, then we will have to find out the “carry” to be added in the next iteration.