# CSCD300Lab2

Purpose

The purpose of this assignment is to allow you to demonstrate basic knowledge of Circular Doubly Linked Lists and edge cases.  These operations include (directly or indirectly): inserting, deleting, returning a sub-list, finding, modifying and "printing."  This assignment should be done by you without outside help (other than from your instructor). If you are unable to complete this assignment in the allotted time, it is a strong indication you are not ready for the material in this class and you MUST meet with the instructor to discuss your continued enrollment in the class.

Specifics

•	As defined in the CDoublyLinkedList class, you have to use a dummy node for your Circular Doubly Linked List.
•	Please implement all the methods in the CDoublyLinkedList class except for the AddFirst()  and toString() methods. The requirements and specifications for each method are provided in the comments above each method header. You are permitted to add helper methods into the class as needed.
•	Please do NOT change the interface and signature (the list of arguments and their type, and return type) of the provided methods in the CDoublyLinkedList class.
•	Please do NOT change the provided AddFirst() and toString() methods in the CDoublyLinkedList class.
•	Please do NOT change any code in the provided Tester class. However, during your testing and debugging, you can comment out some method calls in the main() of the Tester class in order to single out the method that you are currently debugging. After finish debugging, please make sure all methods are called (uncommented) in the main() of the Tester class, as it was initially provided by the instructor. 
•	Please read and understand the design and implementation of the Tester class. So that you can imitate its design in other project when testing each method of your implementation. 

List of methods you have to implement
1.	void addLast(Object data)
2.	CDoublyLinkedList subListOfSmallerValues(Comparable data)
3.	boolean removeStartingAtBack(Object dataToRemove)
4.	int lastIndexOf(Object o)
5.	boolean retainAll(CDoublyLinkedList other)
6.	void insertionSort()
