package com.kt.ds.learning.queues;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***
 * Problem Statement
 *
 * Given a string A denoting a stream of lowercase alphabets. You have to make new string B.
 *
 * B is formed such that we have to find first non-repeating character each time a character is inserted to the stream
 * and append it at the end to B.
 * If no non-repeating character is found then append '#' at the end of B
 *
 * Input -  "abadbc"
 * Output - "aaabc#"
 *<a href="URL#https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters">Question Link</a>
 *
 * */



public class FirstNonRepeatingCharacterInStream {

    public String solve(String A) {
        StringBuilder builder = new StringBuilder();
        Map<Character, Node> index = new HashMap<>();
        Set<Character> repeatedSet = new HashSet<>();
        Node head = null, tail = null;
        //Need a LRU type datastructure .. where we can maintain order as well as know exact
        //position of the repeating element
        //Also a set to avoid duplicate elements
        for(char ch: A.toCharArray()) {

            if(index.containsKey(ch)){
                //removeNode
                Node node = index.get(ch);
                if(head == tail) {
                    head = null;
                    tail = null;
                } else if(head == node){
                    head = head.next;
                    head.prev = null;
                } else if(tail == node) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                index.remove(ch);

            }else if(!repeatedSet.contains(ch)){
                //add the node
                Node node = new Node(ch);
                if(head == null){
                    head = node;
                    tail = node;
                }else {
                    node.prev = tail;
                    tail.next = node;
                    tail = tail.next;
                }
                index.put(ch, node);
                repeatedSet.add(ch);
            }
            builder.append(head!=null?head.val:'#');
        }
        return builder.toString();

    }

    class Node {
        public Node prev;
        public Node next;
        public Character val;
        public Node(char ch) {
            this.val = ch;
        }

    }

    //Test
    public static void main(String[] args) {
        FirstNonRepeatingCharacterInStream firstNonRepeatingCharacterInStream = new FirstNonRepeatingCharacterInStream();
        String input1 = "abadbc";
        System.out.println(firstNonRepeatingCharacterInStream.solve(input1));
    }
}
