/************************************************************************
 * @file Iterator.java
 * @brief This program implements java to create an iterator interface
 * @author Dylan Kane
 * @date October 21, 2025
 *************************************************************************/

public interface Iterator<T extends Comparable<T>> {
    void next();
    void goLeftFrom(Node<T> currNode);
}