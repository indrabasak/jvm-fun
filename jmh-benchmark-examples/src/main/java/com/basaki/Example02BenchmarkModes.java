package com.basaki;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * {@code Example02BenchmarkModes} is an example of different benchmark
 * modes allowed by JMH with the use of {@code BenchmarkMode} annotation.
 */
public class Example02BenchmarkModes {

    /**
     * {@code Mode.Throughput} measures raw throughput by calculating the number
     * of times a method is executed within a fixed time period.
     * <p>
     * {@code TimeUnit.SECONDS} selects the unit of measurement in seconds.
     *
     * @throws InterruptedException
     */
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void measureThroughput() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
    }

    /**
     * {@code Mode.AverageTime} measures average execution time for a  method
     * within a fixed time period.
     * <p>
     * {@code TimeUnit.MICROSECONDS} selects the unit of measurement
     * in microseconds.
     *
     * @throws InterruptedException
     */
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void measureAvgTime() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
    }

    /**
     * {@code Mode.SampleTime} measures execution time for a  method
     * within a fixed time period. Unlike average execution time, it doesn't
     * measure all the executions but benchmarks a sample of the method calls.
     * <p>
     * This allows us to infer the distributions, percentiles, etc.
     * <p>
     * JMH also tries to auto-adjust sampling frequency: if the method
     * is long enough, you will end up capturing all the samples.
     * <p>
     * {@code TimeUnit.MICROSECONDS} selects the unit of measurement
     * in microseconds.
     *
     * @throws InterruptedException
     */
    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void measureSamples() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
    }

    /**
     * {@code Mode.SingleShotTime} measures a single method invocation time.
     * <p>
     * This mode is useful for cold startup tests when a method doesn't need to
     * be invoke d multiple times.
     * <p>
     * {@code TimeUnit.MICROSECONDS} selects the unit of measurement
     * in microseconds.
     *
     * @throws InterruptedException
     */
    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void measureSingleShot() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
    }

    /**
     * Multiple benchmark mode can be used at the same time.
     *
     * @throws InterruptedException
     */
    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime,
            Mode.SampleTime, Mode.SingleShotTime})
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void measureMultiple() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
    }

    /**
     * All benchmark modes can be used at the same time by declaring {@code
     * Mode.All}.
     *
     * @throws InterruptedException
     */
    @Benchmark
    @BenchmarkMode(Mode.All)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void measureAll() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Example02BenchmarkModes.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
