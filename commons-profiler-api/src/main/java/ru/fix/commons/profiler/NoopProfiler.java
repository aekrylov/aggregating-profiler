package ru.fix.commons.profiler;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

/**
 * Test purpose stub
 */
public class NoopProfiler implements Profiler {

    public static class NoopProfiledCall implements ProfiledCall {
        AtomicBoolean isStopped = new AtomicBoolean();

        @Override
        public void call() {
        }

        @Override
        public ProfiledCall start() {
            return this;
        }

        @Override
        public void stop() {
            isStopped.set(true);
        }

        @Override
        public void stop(long payload) {
        }

        @Override
        public void cancel() {
        }

        @Override
        public void close() {
        }

        @Override
        public boolean isStopped() {
            return isStopped.get();
        }
    }

    @Override
    public ProfiledCall profiledCall(String name) {
        return new NoopProfiledCall();
    }

    @Override
    public <T> CompletableFuture<T> profiledCall(String name, Supplier<CompletableFuture<T>> cfSupplier) {
        return null;
    }

    @Override
    public void attachIndicator(String name, IndicationProvider indicationProvider) {
    }

    @Override
    public void detachIndicator(String name) {
    }

    @Override
    public ProfilerReporter createReporter() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ProfilerReporter createReporter(boolean enableActiveCallsMaxLatency, int activeCallsToKeepBetweenReports) {
        throw new UnsupportedOperationException();
    }
}
