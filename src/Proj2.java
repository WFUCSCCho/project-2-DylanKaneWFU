/************************************************************************
 * @file Proj2.java
 * @brief This program implements java to run and time the search and insert operations for the trees
 * @author Dylan Kane
 * @date October 21, 2025
 *************************************************************************/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.io.StringWriter;
import java.io.File;

public class Proj2 {
    public static double timeTreeSearch(Tree<DataObj> tree, ArrayList<DataObj> initData) {
        //times the search operation of a tree in seconds
        long startTimer = System.nanoTime();
        for (DataObj initDatum : initData) {
            boolean searchResult = tree.contains(initDatum); //result is not used, just for timing purposes
        }

        long endTimer = System.nanoTime();
        return (endTimer - startTimer) / 1_000_000_000.0;
    }

    public static double timeTreeInsert(Tree<DataObj> tree, ArrayList<DataObj> data) {
        //times the insert operation of a tree in seconds
        long startTimer = System.nanoTime();
        for (int i = 0; i < data.size(); i++) {
            tree.insert(data.get(i));
        }
        long endTimer = System.nanoTime();
        return (endTimer - startTimer) / 1_000_000_000.0;
    }

    public static void main(String[] args) throws IOException {
        // Use command line arguments to specify the input file
        if (args.length != 2) {
            System.err.println("Usage: java TestAvl <input file> <number of lines>");
            System.exit(1);
        }

        String inputFileName = args[0];
        int numLines = Integer.parseInt(args[1]);

        // For file input
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream(inputFileName);
        inputFileNameScanner = new Scanner(inputFileNameStream);

        // ignore first line
        inputFileNameScanner.nextLine();

	// FINISH ME

        BST<DataObj> sortedBST = new BST<>();
        AvlTree<DataObj> sortedAVL = new AvlTree<>();
        BST<DataObj> randomBST = new BST<>();
        AvlTree<DataObj> randomAVL = new AvlTree<>();

        ArrayList<DataObj> initData = new ArrayList<>();

        for (int i = 0; i < numLines; i++) {
            String obj = inputFileNameScanner.nextLine();
            String[] objInfo;

            objInfo = obj.split(",");
            DataObj currData = new DataObj(objInfo[0],
                    Double.parseDouble(objInfo[1]),
                    Integer.parseInt(objInfo[2]),
                    Integer.parseInt(objInfo[3]),
                    objInfo[4]
            );

            initData.add(currData);
        }

        inputFileNameStream.close();

        ArrayList<DataObj> randomData = new ArrayList<>(initData);
        Collections.shuffle(randomData);

        ArrayList<DataObj> sortedData = new ArrayList<>(initData);
        Collections.sort(sortedData, Comparator.comparingInt(DataObj::caffeine));

        double sortedBSTInsertTime = timeTreeInsert(sortedBST, sortedData);
        double sortedAVLInsertTime = timeTreeInsert(sortedAVL, sortedData);
        double randomBSTInsertTime = timeTreeInsert(randomBST, randomData);
        double randomAVLInsertTime = timeTreeInsert(randomAVL, randomData);

        double sortedBSTSearchTime = timeTreeSearch(sortedBST, initData);
        double randomBSTSearchTime = timeTreeSearch(randomBST, initData);
        double sortedAVLSearchTime = timeTreeSearch(sortedAVL, initData);
        double randomAVLSearchTime = timeTreeSearch(randomAVL, initData);

        File file = new File("output.txt");
        boolean needsHeader = false;
        if (!file.exists()) needsHeader = true;

        //Write to output file
        FileOutputStream myFile = new FileOutputStream("output.txt", true);
        PrintWriter fileWriter = new PrintWriter(myFile);
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        //print results in readable form
        printWriter.printf("Number of lines read: %d\n", numLines);

        printWriter.println("Insert Times:");
        printWriter.printf("\tSorted BST = %f\n", sortedBSTInsertTime);
        printWriter.printf("\tRandom BST = %f\n", randomBSTInsertTime);
        printWriter.printf("\tSorted AVL = %f\n", sortedAVLInsertTime);
        printWriter.printf("\tRandom AVL = %f\n", randomAVLInsertTime);

        printWriter.println("Search Times:");
        printWriter.printf("\tSorted BST = %f\n", sortedBSTSearchTime);
        printWriter.printf("\tRandom BST = %f\n", randomBSTSearchTime);
        printWriter.printf("\tSorted AVL = %f\n", sortedAVLSearchTime);
        printWriter.printf("\tRandom AVL = %f\n", randomAVLSearchTime);
        printWriter.println();

        String results = stringWriter.toString();

        //print results in human-readable format to screen for user
        System.out.print(results);

        //write results to output.txt file in csv format

        //check if file is empty, if so add a header
        if (needsHeader) fileWriter.println("Lines Read," +
                "Sorted BST Insert Time," +
                "Random BST Insert Time," +
                "Sorted AVL Insert Time," +
                "Random AVL Insert Time");

        fileWriter.printf("%d,%.9f,%.9f,%.9f,%.9f\n",
                numLines,
                sortedBSTSearchTime,
                randomBSTSearchTime,
                sortedAVLSearchTime,
                randomAVLSearchTime
        );

        fileWriter.flush();
        fileWriter.close();

    }
}
