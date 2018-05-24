JMH (Java Microbenchmark Harness) Benchmark Examples
==========================================================

The performance of Java is affected by different factors including the Java 
Virtual Machine (JVM) itself, garbage collection, heap size, Just-In-Time (JIT) 
compilation and optimization in VM based on time based sampling, 
thread scheduling, etc.

Benchmarking Java is difficult as JVM is an adaptive virual machine. To address
the difficulties in benchmarking, OpenJDK came up with
[JMH (Java Microbenchmark Harness)](http://openjdk.java.net/projects/code-tools/jmh/) .
JM is abenchmarking harness to measure performance of any JVM based language.

### Overview

### Build
Execute the following command from the parent directory:
```
mvn clean install
```

### Run
To run 

```
java -jar jmh-benchmark-examples/target/benchmarks.jar
```

```
Iteration   8: 4492.310 ops/s
Iteration   9: 4542.304 ops/s
Iteration  10: 4485.150 ops/s
Iteration  11: 4570.859 ops/s
Iteration  12: 4512.431 ops/s
Iteration  13: 4504.347 ops/s
Iteration  14: 4507.201 ops/s
Iteration  15: 4537.745 ops/s
Iteration  16: 4498.746 ops/s
Iteration  17: 4504.224 ops/s
Iteration  18: 4512.569 ops/s
Iteration  19: 4506.216 ops/s
Iteration  20: 4513.704 ops/s

...

Result "com.basaki.MapSizeBench.hashMap":
  360.474 ±(99.9%) 2.509 ops/s [Average]
  (min, avg, max) = (309.812, 360.474, 380.827), stdev = 10.623
  CI (99.9%): [357.965, 362.983] (assumes normal distribution)

...

# JMH version: 1.19
# VM version: JDK 1.8.0_92, VM 25.92-b14
# VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_92.jdk/Contents/Home/jre/bin/java
# VM options: <none>
# Warmup: 20 iterations, 1 s each
# Measurement: 20 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.basaki.MyBenchmark.testMethod

# Run progress: 83.33% complete, ETA 00:06:46

# Run progress: 83.33% complete, ETA 00:06:46
# Fork: 1 of 10
# Warmup Iteration   1: 2739240995.620 ops/s
# Warmup Iteration   2: 2806497026.407 ops/s
# Warmup Iteration   3: 2870465694.743 ops/s
# Warmup Iteration   4: 2785738861.253 ops/s
# Warmup Iteration   5: 2777911103.446 ops/s
# Warmup Iteration   6: 2725857635.602 ops/s
# Warmup Iteration   7: 2793702371.648 ops/s
# Warmup Iteration   8: 2706405184.739 ops/s
# Warmup Iteration   9: 2729829009.919 ops/s
# Warmup Iteration  10: 2752911004.458 ops/s
# Warmup Iteration  11: 2773057061.563 ops/s
# Warmup Iteration  12: 2773662165.308 ops/s
# Warmup Iteration  13: 2781075459.505 ops/s
# Warmup Iteration  14: 2781199890.528 ops/s
# Warmup Iteration  15: 2800439666.311 ops/s
# Warmup Iteration  16: 2792258246.103 ops/s
# Warmup Iteration  17: 2762024669.091 ops/s
# Warmup Iteration  18: 2756161587.009 ops/s
# Warmup Iteration  19: 2828481305.869 ops/s
# Warmup Iteration  20: 2848941944.994 ops/s
Iteration   1: 2803138856.642 ops/s
Iteration   2: 2807847971.681 ops/s
Iteration   3: 2779947176.390 ops/s
Iteration   4: 2737790818.995 ops/s
Iteration   5: 2820011994.307 ops/s
Iteration   6: 2780954578.067 ops/s
Iteration   7: 2774127267.129 ops/s
Iteration   8: 2780610734.496 ops/s
Iteration   9: 2781888077.598 ops/s
Iteration  10: 2785290670.251 ops/s
Iteration  11: 2799372869.313 ops/s
Iteration  12: 2783280727.813 ops/s
Iteration  13: 2787211073.828 ops/s
Iteration  14: 2774473248.685 ops/s
Iteration  15: 2767598224.726 ops/s
Iteration  16: 2785384543.456 ops/s
Iteration  17: 2788779901.345 ops/s
Iteration  18: 2795780372.933 ops/s
Iteration  19: 2761568970.880 ops/s
Iteration  20: 2778661703.067 ops/s

# Run progress: 85.00% complete, ETA 00:06:05
# Fork: 2 of 10

...
Result "com.basaki.MyBenchmark.testMethod":
  2731561545.160 ±(99.9%) 11314792.676 ops/s [Average]
  (min, avg, max) = (2603575911.676, 2731561545.160, 2851333603.534), stdev = 47907540.683
  CI (99.9%): [2720246752.485, 2742876337.836] (assumes normal distribution)


# Run complete. Total time: 00:40:40

Benchmark               (size)   Mode  Cnt           Score          Error  Units
MapSizeBench.hashMap        10  thrpt  200     5590292.932 ±    67902.175  ops/s
MapSizeBench.hashMap       100  thrpt  200      628408.009 ±     7856.737  ops/s
MapSizeBench.hashMap      1000  thrpt  200       54923.485 ±     1239.538  ops/s
MapSizeBench.hashMap     10000  thrpt  200        4486.878 ±       27.084  ops/s
MapSizeBench.hashMap    100000  thrpt  200         360.474 ±        2.509  ops/s
MyBenchmark.testMethod     N/A  thrpt  200  2731561545.160 ± 11314792.676  ops/s

```