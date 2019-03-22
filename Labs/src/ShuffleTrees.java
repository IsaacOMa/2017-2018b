

import java.util.Random;






// CSCI 1913 Project 3 Will Davies (davie304@umn.edu)
class ShuffleTrees<Value> {

    private class Node {
        private String key;
        private Value value;
        private Node left, right;

        private Node(String key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    /*
     * Temporary sort of buffer arrays to help minimize tree depth,
     * these arrays are flushed to the tree at various moments
     */
    private String[] keys;
    private Value[] values;

    private int count; // the current number of objects in the buffer arrays
    private Node root; // head of the tree
    private Random generator;

    public ShuffleTrees(int size) {
        if(size < 0) throw new IllegalArgumentException("Size can't be negative.");

        keys = new String[size];
        values = (Value[]) new Object[size];

        count = 0;
        root = null;
        generator = new Random();
    }

    // Shuffles the buffer array and flushes it to the tree
    public void flush() {
    	System.out.println(count);
        // Shuffle array using Durstenfeld-Fisher-Yates
        for(int i = 0; i < count - 2; i++) {
        	int j = Math.abs(generator.nextInt()) % (count - i);

            String tempKey = keys[i];
            Value tempValue = values[i];
            keys[i] = keys[i + j];
            values[i] = values[i + j];
            keys[i + j] = tempKey;
            values[i + j] = tempValue;
        }
        
        for(int i = 0; i < count; i++) putInTree(keys[i], values[i]);

        // Clear the buffer arrays
        count = 0;
        keys = new String[keys.length];
        values = (Value[]) new Object[values.length];
    }
  

        // Write keys[] and values[] to the tree (throw exception if duplicate found)
   
    // Helper function to insert a value into the tree
    private void putInTree(String key, Value value) {
        if(root == null) {
            root = new Node(key, value);
        } else {
            Node subtree = root;
            while(true) {
                int test = key.compareTo(subtree.key);
                if(test < 0) {
                    if(subtree.left == null) {
                        subtree.left = new Node(key, value);
                        return;
                    } else {
                        subtree = subtree.left;
                    }
                } else if(test > 0) {
                    if(subtree.right == null) {
                        subtree.right = new Node(key, value);
                        return;
                    } else {
                        subtree = subtree.right;
                    }
                } else {
                    throw new IllegalStateException("Error: The value associated with key "+key+" can not be modified.");
                }
            }
        }
    }

    // Returns the value associated with the key in the tree
    public Value get(String key) {
        if(root == null) throw new IllegalArgumentException("Error: Tree is empty.");

        if(count != 0) flush();

        Node subtree = root;
        while(subtree != null) {
            int test = key.compareTo(subtree.key);
            if(test < 0) {
                subtree = subtree.left;
            } else if(test > 0) {
                subtree = subtree.right;
            } else {
                return subtree.value;
            }
        }

        throw new IllegalArgumentException("Tree does not contain key "+key+".");
    }
    

    // Returns the height of the tree
    public int height() {
        if(count != 0) flush();

        return heighting(root);
    }

    // Helper function that recursively calculates the height of the tree
    private int heighting(Node root) {
        if(root == null) return 0;

        int left = heighting(root.left);
        int right = heighting(root.right);
        if(left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }
    


    // Adds a value to the buffer and flushes the buffer to the tree if the buffer is full
    public void put(String key, Value value) {
        if(key == null) throw new IllegalArgumentException("Key mustn't be null!");

        if(count == keys.length) flush(); // if full, flush

        keys[count] = key;
        values[count] = value;
        count++;
    }
}

/*
 * DRIVER CLASS
 */
