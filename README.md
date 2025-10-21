Note: ChatGPT documentation and dataset modifications are included at the bottom of this README.md

# Project 2 @ CSC 201 Fall 2025: AVL Tree

## Pledged Work Policy

This is a ___Pledged Work___ assignment.  This means that the work you submit for grading ___must___ be your work product.  
You may not submit the work of others outside of your team, or the modification of work of others outside of your team.
You are encouraged to talk with each other about general problems.  For example, you may talk to someone about "What does it mean when the compiler says there is a semicolon missing on line 20", or "I can not get my assignment template to download from GitHub, what did you do?".  However, you may not engage in "Could you send me a copy of your work so I can see how to get started?".  You may get full and detailed assistance from me, the Teaching Assistant (TA), and the TAs in the Computer Science Center.  If you have any question about the appropriateness of assistance, do not hesitate to consult with me.

Use of ChatGPT or similar resources are encouraged but they must be documented in this README.md. That includes 1) the exact prompt used, 2) the screenshots of the outputs, and 3) your personal assessment on how useful it was. Even erroneous or unuseful results must be documented.

If I believe you have violated our ___Pledge Work___ agreement, I will pursue this matter through the college Honor Council.

## Overview

An AVL Tree is a type of self-balancing Binary Search Tree (BST) that ensures that the tree is approximately balanced. An AVL Tree remains balanced as elements are inserted or deleted. During class, we discussed the general algorithms for a BST and an AVL tree.  In particular, we emphasized how a regular BST structure can become basically a linked list if its balance is not maintained, resulting in a O(N) running time instead of the O(log N) we expect from a properly balanced BST.

In this project, you will:
1. Implement a generic BST with an iterator interface. (You developed this in Project 1, which you can use as is or update.)
2. Implement a generic AVL Tree with an iterator interface.
3. Insert sorted and randomized datasets into BST and AVL Trees.
4. Time the insertion and search operations for BST and AVL Trees.
5. Graph and analyze the insertion and search operation timings.

## Invocation and I/O Files:

The name of the program is `Proj2` ( provided with a `main` method in`Proj2.java` ). 

You are encouraged to run and debug code in __IntelliJ IDEA__. Also, the program can be invoked from the command-line as:

```shell
java Proj2 {dataset-file} {number of lines}
```

## 1. **Generic BST with Iterator Interface**

You already created Node and BST classes with a Comparable Interface for Project 1. If your implementation is perfect, you can simply copy over your files and continue to the next section. However, you can make whatever modifications that you deem necessary to complete this project.

## 2. **Generic AVL Tree Interface**

I have enclosed three starter codes:
1. `AvlTree.java`
2. `TestAvl.java`
3. `Proj2.java`

The `AvlTree.java` file contains an overall structure of that AVL Tree class, and you are expected to complete the code where it is indicated (Search for `// FINISH ME`). The `TestAvl.java` file must not be modified, and it will be used for testing your AVL Tree class. It does not check for every error, but I hope that it will be helpful for you. The `Proj2.java` file contains a starter code for you to implement the main driver of the program.

## 3. **Sorted and Randomized Datasets for BST and AVL Trees**

You already created a well-written class to store the records from a dataset for Project 1. If your dataset and implementation is perfect, you can simply copy over your files. However, you can make whatever modifications that you deem necessary to complete this project, and you can also choose a completely different dataset. The source of the dataset and modifications made to it must be documented inside the class.

I have enclosed `Proj2.java` that takes in two command line arguments: 1) the filename if your dataset, and 2) the number of lines of your dataset to read. 

You will read your dataset and store the data in an ArrayList. To sort and randomize your ArrayList, you will use the `Collections.sort()` and `Collections.shuffle()` commands.

You will then insert each element if your sorted and randomized ArrayLists into BST and AVL Trees. In total, there will be four trees.

You will then use your original ArrayList to search for each element in your BST and AVL Trees. In total, you will be searching four times.

## 4. **Time the Insertion and Search operations for BST and AVL Trees**

For each of the insertion and search operations, you will use `System.nanoTime()` to calculate the time it takes to run the insertion and search operations for the sorted and randomized BST and AVL Trees. Your program will print out the number of lines and the times to insert and search for BST and AVL Trees to the screen in a human-readable format (i.e., nice to look at) and also separtely to a file named `output.txt` in CSV format. Each time the program runs, it will append the timing results to `output.txt`.

## 5. Graph and analyze the insertion and search operation for BST and AVL Trees**

Run your program several times for different number of lines of your dataset, N, by choosing different values of the second command line argument. After several runs, your `output.txt` file will be filled with timing data.

Using your favorite graphing software (e.g., MS Excel or Google Sheets), plot the running time (in seconds) and rate (in seconds per node) vs. N for each case, comparing the BST and AVL Trees (i.e., two lines per graph). Take a screenshot of your graph and put them here by modifying this file, committing, and pushing it to this repository.

Note: all of my following inserted graphs have the x-axis as number of datapoints (nodes) and the y-axis as seconds

BST vs. AVL Tree running time (insertion):
<img width="733" height="224" alt="Screenshot 2025-10-21 at 10 18 44" src="https://github.com/user-attachments/assets/923747ac-c291-41c3-a09f-a0f753c93c0d" />

BST vs. AVL Tree running time (search):
<img width="755" height="244" alt="Screenshot 2025-10-21 at 10 18 55" src="https://github.com/user-attachments/assets/b933dca1-62a4-4454-8e35-f08626711521" />


BST vs. AVL Tree running rate (insertion):
<img width="780" height="238" alt="Screenshot 2025-10-21 at 10 19 07" src="https://github.com/user-attachments/assets/3b0d5045-4a2b-483f-8502-1c9cbb075db5" />


BST vs. AVL Tree running rate (search):
<img width="712" height="234" alt="Screenshot 2025-10-21 at 10 25 19" src="https://github.com/user-attachments/assets/a2a91a8d-5776-41fe-b4a2-39c340805443" />

## Submission:

Your project will be developed and graded via GitHub. Your final "push" is your final submission, and it must occur before it is due. On Canvas, enter the url to your Github repository. Your project will not be graded without it.

## Recommendations:

I ___strongly suggest___ that you carefully think through your strategy before just jumping into the code.  Once that is working, start adding in new features individually.  A good place to start is building your class.

*In order to get full points of Commenting and Code Style, you need to add comments to every methods and head comments for each file (providing file description, author, date, and acknowledgement).

```
/∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗*
∗ @file: filename.java
∗ @description: This program implements . . .
∗ @author: Your Name
∗ @date: October 21, 2025
∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗/
```
# Modifications and Documentation

## ChatGPT
### Prompt 1: Provide me example code of how to use Collections.sort() and Collections.shuffle() to store data objects in an array list. I would like to sort them, if possible, by a specific integer attribute of the object. Program it in java.

Response: https://chatgpt.com/s/t_68f7896d9cd88191b2cfb265e80634f6
Assessment: This was useful to learn how the Collections.sort() and Collections.shuffle() operations work and how they are typically implemented, as I had not previously used them before in any of my projects. I felt more comfortable using these operaitons after this

### Prompt 2: Is there a way to have Collections return a new array without modifying the original array?

Response: https://chatgpt.com/s/t_68f78ad31220819182f1de475447eea3
Assessment: This was not particularly helpful. I wanted to see if there was an easier way to implement the .sort() and .shuffle() algorithms, here GPT did not give me much of a solution and more gave me a long answer of "no".

### Prompt 3: I would like to use System.nanotime() to compare the speed of search algorithms with sorted and unsorted AVL and BST trees. I would like to understand how System.nanotime() works, and how to return time values from it. Please write some example code, walk me through it, and suggest potential implementations

Response: https://chatgpt.com/s/t_68f78a14741881918ee1652fa6923ff8
Assessment: This was a good response, it helped me understand how System.nanotime() is used rather than just programming it for me. This was also an operation I had not previously used, but after this explanation I knew how to implement it.

### Prompt 3: How would i be able to have a select 4 classes be able to be used for a method and no others?

Response: https://chatgpt.com/s/t_68f78bea342881919ff8fc6069f9e44d
Assessment: Really useful! I used this to implement my timeTreeSearch and timeTreeInsert operations in java, as I did not want to copy and paste the same lines of code for each tree.

### Prompt 4: "public class AvlTree<AnyType extends Comparable<? super AnyType>> extends Tree<AnyType extends Comparable<? super AnyType>>" please explain what is wrong with this statement so I may correct it.

Response: https://chatgpt.com/s/t_68f78c9eba4c81918a0572690dc77389
Assessment: Was struggling to implement an extended class so I could refer to both a BST and an AVL Tree in my timeTreeSearch and timeTreeInsert methods. Here, GPT did not work and just overcomplicated the code, so I asked a follow up prompt

### Prompt 5: With this code I receive the following error: Type parameter 'AnyType' is not within its bound; should extend 'java.lang.Comparable<AnyType>'. Please assist with resolving the issue and explain why the resolution works

Response: https://chatgpt.com/s/t_68f78d4527708191ba85baec53d7117a
Asssessment: This response was much better, I had just needed to be more specific with my prompt.

## Modifications to Original Dataset
One datapoint needed to be modified slightly: I changed the "," to an "and" in the drink title for the 125th datapoint. This was due to this data point causing bugs, as data attributes were determined were determined by the split(",") command.


