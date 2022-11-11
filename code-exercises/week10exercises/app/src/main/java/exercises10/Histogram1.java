package exercises10;

import java.util.concurrent.atomic.AtomicInteger;

class Histogram1 implements Histogram {
    private AtomicInteger[] counts;

    public Histogram1(int span) {
        this.counts = new AtomicInteger[span];
    }

    public int increment(int bin) {
        int oldValue, newValue;
        do {
            oldValue = counts[bin].get();
            newValue = oldValue + 1;
        } while (!counts[bin].compareAndSet(oldValue, newValue));
    }

    public int getCount(int bin) {
        return counts[bin].get();
    }

    public int getSpan() {
        return counts.length;
    }

    public int getAndClear(int bin) {
        int oldValue, newValue;
        do {
            oldValue = counts[bin].get();
            newValue = oldValue + 1;
        } while (!counts[bin].compareAndSet(oldValue, newValue));
    }
}
