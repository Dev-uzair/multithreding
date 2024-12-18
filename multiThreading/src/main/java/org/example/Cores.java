package org.example;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Cores {

        public static void main(String[] args) {
//            Available processors (logical cores)
            int processors = Runtime.getRuntime().availableProcessors ();

            System.out.println("Total Logical Processors: " + processors);


            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

            // Total thread count
            int threadCount = threadMXBean.getThreadCount();

            // Detailed thread information
            long[] threadIds = threadMXBean.getAllThreadIds();

            System.out.println("Total Active Threads: " + threadCount);
            System.out.println("Thread IDs:");

            for (long threadId : threadIds) {
                // Get thread info
                String threadName = threadMXBean.getThreadInfo(threadId).getThreadName();
                boolean isThreadCpuTimeSupported = threadMXBean.isThreadCpuTimeSupported();

                System.out.println("Thread ID: " + threadId +
                        ", Name: " + threadName +
                        ", CPU Time Supported: " + isThreadCpuTimeSupported);
            }

        }

}
