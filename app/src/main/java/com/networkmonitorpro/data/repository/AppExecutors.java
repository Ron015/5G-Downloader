package com.networkmonitorpro.data.repository; import java.util.concurrent.*; public class AppExecutors{ public static final ExecutorService IO=Executors.newFixedThreadPool(4); }
