import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;



public class Proj2 {
    public static double timeTree(Tree<DataObj> tree, ArrayList<DataObj> initData) {
        //times a tree
        long startTimer = System.nanoTime();
        for (DataObj initDatum : initData) {
            boolean searchResult = tree.contains(initDatum); //result is not used, just for timing purposes
        }

        long endTimer = System.nanoTime();
        return endTimer - startTimer;
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

        for (int i = 0; i < initData.size(); i++) {
            sortedBST.insert(sortedData.get(i));
            sortedAVL.insert(sortedData.get(i));
            randomBST.insert(randomData.get(i));
            randomAVL.insert(randomData.get(i));
        }

        double sortedBSTTime = timeTree(sortedBST, initData);
        double randomBSTTime = timeTree(randomBST, initData);
        double sortedAVLTime = timeTree(sortedAVL, initData);
        double randomAVLTime = timeTree(randomAVL, initData);

        //Write to output file
        FileOutputStream myFile = new FileOutputStream("output.txt", true);
        PrintWriter fileWriter = new PrintWriter(myFile);

        fileWriter.printf("Number of lines read: %d\n", numLines);
        fileWriter.println("Times:");
        fileWriter.printf("\tSorted BST = %f\n", sortedBSTTime);
        fileWriter.printf("\tRandom BST = %f\n", randomBSTTime);
        fileWriter.printf("\tSorted AVL = %f\n", sortedAVLTime);
        fileWriter.printf("\tRandom AVL = %f\n", randomAVLTime);
        System.out.println();

        fileWriter.flush();
        fileWriter.close();

    }
}
