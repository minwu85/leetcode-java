Reverse Number / Palindrome — Thinking Process and Summary
1. First understand the data type

For the palindrome problem:

public boolean isPalindrome(int x)


x is an:

int


It is not a ListNode.

This is very important.

With a linked list:

ListNode cur


we can do:

cur = cur.next;


because ListNode has a next field.

But with:

int cur


there is no:

cur.next


An integer is just a number.

2. Why cur != null doesn't work

You might write:

int cur = x;

while (cur != null) {
}


This is wrong because cur is an int.

null is used for objects/references when there is no object.

An int has a numeric value:

0
1
2
121
12345


It is not:

null


For an integer, we can use:

while (x != 0)


to process its digits.

3. What is a palindrome?

A palindrome reads the same forwards and backwards.

Examples:

121


Forward:

121


Backward:

121


Therefore:

true


Another example:

123


Forward:

123


Backward:

321


Therefore:

false

4. Main thinking process

A simple approach is:

Save the original number.
Reverse the number.
Compare the reversed number with the original.
If they are equal, it is a palindrome.

For:

121


we want:

original = 121
reverse  = 121


Therefore:

original == reverse


is true.

5. How do we get the last digit?

Use:

x % 10


% means remainder.

For:

x = 123


we get:

123 % 10 = 3


So % 10 gives us the last digit.

Examples:

123 % 10 = 3
45 % 10 = 5
8 % 10 = 8

6. How do we remove the last digit?

Use:

x / 10


Because integer division removes the decimal portion.

For:

123 / 10


we get:

12


Then:

12 / 10 = 1


Then:

1 / 10 = 0


So:

x = x / 10;


removes the last digit.

7. How do we build the reversed number?

We use:

reverse = reverse * 10 + digit;


Suppose:

x = 123

First digit

Get:

123 % 10 = 3


So:

digit = 3


Initially:

reverse = 0


Build:

reverse = 0 * 10 + 3
        = 3


Now:

reverse = 3

Second digit

Remove the 3:

123 / 10 = 12


Get the last digit:

12 % 10 = 2


Build:

reverse = 3 * 10 + 2
        = 32


Now:

reverse = 32

Third digit

Remove 2:

12 / 10 = 1


Get:

1 % 10 = 1


Build:

reverse = 32 * 10 + 1
        = 321


Now:

reverse = 321


So:

123


became:

321

8. Complete example: 121

Start:

original = 121
x        = 121
reverse  = 0

Step 1
digit = 121 % 10
      = 1

reverse = 0 * 10 + 1
        = 1


Remove the last digit:

x = 121 / 10
  = 12

Step 2
digit = 12 % 10
      = 2

reverse = 1 * 10 + 2
        = 12


Remove last digit:

x = 12 / 10
  = 1

Step 3
digit = 1 % 10
      = 1

reverse = 12 * 10 + 1
        = 121


Remove last digit:

x = 1 / 10
  = 0


Stop because:

x != 0


is now false.

Compare:

original = 121
reverse  = 121


Therefore:

true

9. Complete code
class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int original = x;
        int reverse = 0;

        while (x != 0) {

            int digit = x % 10;

            reverse = reverse * 10 + digit;

            x = x / 10;
        }

        return original == reverse;
    }
}

10. Why check x < 0?

A negative number such as:

-121


backwards would be:

121-


So it is not a palindrome.

Therefore:

if (x < 0) {
    return false;
}

11. Important difference from Linked Lists

This is the biggest concept to remember.

Linked List

You have nodes:

[2] → [4] → [3] → null


You move using:

node = node.next;


because each node contains a next.

Integer

You have a number:

123


There are no nodes and no .next.

You manipulate digits using:

x % 10


to get the last digit.

And:

x / 10


to remove the last digit.

12. Mental model

For linked list:

node
 ↓
[ value | next ] → [ value | next ] → null


Think:

Move through boxes.

For an integer:

12345


Think:

Take digits from the right side one at a time.

12345
    ↑
   last digit = 5


Then:

1234
   ↑
  last digit = 4


Then:

123
  ↑
 last digit = 3


And so on.

13. Key summary
int x

A number, not a linked-list node.

x % 10

Gets the last digit.

123 % 10 = 3

x / 10

Removes the last digit.

123 / 10 = 12

reverse * 10 + digit

Adds a digit to the end of the reversed number.

reverse = 32
digit = 1

32 * 10 + 1 = 321

original == reverse

Checks whether the number is the same forwards and backwards.

Most important idea

For an integer palindrome:

original number
       ↓
take last digit
       ↓
put it into reverse
       ↓
remove last digit
       ↓
repeat
       ↓
compare original and reverse


Don't think about .next here.

.next belongs to the linked-list ListNode problem.

% 10 and / 10 belong to manipulating the digits of an integer.