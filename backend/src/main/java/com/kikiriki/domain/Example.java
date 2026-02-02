package com.kikiriki.domain;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Example {

    public record Test(Queue<String> queue) {
        
    }

    public static void main(String[] args) {
        Queue<String> queue = new LinkedBlockingQueue<>();
        Test test = new Test(queue);

        test.queue.add("first");
        test.queue.add("second");
        test.queue.add("third");

        while (test.queue.peek() != null) {
            IO.println(test.queue.remove());
        }
    }
}
