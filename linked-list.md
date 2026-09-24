Linked List — Thinking Process and Summary
1. What is a ListNode?

A ListNode is a small object used to create a linked list.

A typical LeetCode definition looks like:

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


Each node contains two things:

┌──────────────┐
│ val          │  ← the value
│ next         │  ← reference to the next node
└──────────────┘


For example:

[2] → [4] → [3] → null


means:

Node 1:
val = 2
next → Node 2

Node 2:
val = 4
next → Node 3

Node 3:
val = 3
next → null

2. What does new ListNode(7) mean?
new ListNode(7)


creates a new node.

Think of it as creating a box:

┌──────────┐
│ val = 7  │
│ next=null│
└──────────┘


So:

ListNode node = new ListNode(7);


means:

Create a new node containing 7, and store a reference to that node in node.

3. What does .val mean?

If:

ListNode node = new ListNode(7);


then:

node.val


is:

7


val comes from the ListNode class definition.

Similarly:

node.next


means:

Give me the next node.

4. Understanding l1 and l2

Suppose:

l1 = [2,4,3]
l2 = [5,6,4]


The actual linked lists are:

l1

[2] → [4] → [3] → null


l2

[5] → [6] → [4] → null


l1 does not contain all three numbers directly.

It points to the first node.

l1
 ↓
[2] → [4] → [3] → null


When we do:

l1 = l1.next;


we move l1 to the next node:

      l1
       ↓
[2] → [4] → [3] → null


becomes:

             l1
              ↓
[2] → [4] → [3] → null


Then another:

l1 = l1.next;


gives:

                    l1
                     ↓
[2] → [4] → [3] → null

5. Why don't we reverse the input?

This problem stores digits in reverse order.

[2] → [4] → [3]


represents:

342


not:

243


The first node is the ones digit:

[2] → [4] → [3]
 ↓      ↓      ↓
ones   tens  hundreds


Therefore:

2 + 5 = 7
4 + 6 = 10
3 + 4 + 1 = 8


This is convenient because normal addition starts from the rightmost digit.

We don't need to reverse anything.

6. The carry

Consider:

  342
+ 465
-----


Start from the right:

2 + 5 = 7


Then:

4 + 6 = 10


We write 0 and carry 1.

Then:

3 + 4 + 1 = 8


So:

807


In code:

carry = sum / 10;


gets the carry.

For example:

sum = 17

17 / 10 = 1


So:

carry = 1

7. Getting the digit with %
sum % 10


gets the digit that should be stored in the current node.

For:

sum = 17


we get:

17 % 10 = 7


Therefore:

carry = sum / 10;
current.next = new ListNode(sum % 10);


means:

17

 ↓

carry = 1
digit = 7

8. Understanding dummy

We start with:

ListNode dummy = new ListNode(0);
ListNode current = dummy;


Initially, both variables point to the same node:

dummy
  ↓
[0]
  ↑
current


The 0 is a fake/placeholder node.

It makes it easier to build the real answer.

9. Understanding current

When we do:

current.next = new ListNode(7);


we create and connect a new node:

dummy
  ↓
[0] → [7]
         ↑
       current


Then:

current = current.next;


moves current forward.

Conceptually:

dummy
  ↓
[0] → [7]
         ↑
       current


dummy stays where it is.

current moves.

10. Building the complete answer

Suppose the digits are:

7 → 0 → 8


We build:

dummy
  ↓
[0] → [7] → [0] → [8] → null


dummy always stays at the beginning.

current moves to the newest node.

11. Why return dummy.next?

We don't want the fake [0].

We want:

[7] → [0] → [8]


Since:

dummy
  ↓
[0] → [7] → [0] → [8]
       ↑
     answer


the answer begins at:

dummy.next


Therefore:

return dummy.next;


returns:

[7] → [0] → [8]

12. Complete mental model

When solving linked-list problems, think:

ListNode
   ↓
┌─────────┐
│ val     │
│ next ───────→ next node
└─────────┘


Important operations:

node.val


Get the value.

node.next


Get the next node.

node = node.next;


Move to the next node.

new ListNode(7)


Create a new node containing 7.

current.next = new ListNode(7);


Create a new node and connect it after current.

13. Key summary
ListNode

A node containing:

value + pointer to next node

val

The value stored in the node.

next

The reference to the next node.

new ListNode(x)

Creates a new node containing x.

current = current.next

Moves the current pointer forward.

current.next = new ListNode(x)

Creates a new node and attaches it to the current node.

dummy

A fake starting node used to make linked-list construction easier.

dummy.next

The first real node of the answer.

carry = sum / 10

Gets the carry when adding digits.

sum % 10

Gets the digit to put into the new node.

Most important idea

For linked lists, visualize the arrows:

[2] → [4] → [3] → null
 ↑
first node


A variable such as l1 or current is usually pointing to one of these nodes.

When you write:

current = current.next;


you are simply moving the pointer to the next box.