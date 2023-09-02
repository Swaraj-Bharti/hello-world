package com.test.practice.ranges;



import lombok.Getter;
import java.util.*;


@Getter
public class RangeFunction<T extends Number> {
    private final List<Range<T>> ranges;
    private final Comparator<T> comparator;

    public RangeFunction(List<Range<T>> ranges, Comparator<T> comparator) {
        this.ranges = ranges;
        this.comparator = comparator;
    }

    @SafeVarargs
    public RangeFunction(Comparator<T> comparator, T... log) {
        this.comparator = comparator;
        this.ranges = getRanges(log);
    }

    private List<Range<T>> getRanges(T[] log) {
        List<Range<T>> ranges = new ArrayList<>();
        for (int i = 0; i < log.length - 1; i += 2) {
            ranges.add(new Range<>(log[i], log[i + 1]));
        }
        return ranges;
    }

    public List<Range<T>> mergeOverlappingRanges() {
        ranges.sort(getRangeComparator());
        mergeRanges(ranges);
        return ranges;
    }

    private  Comparator<Range<T>> getRangeComparator() {
        return (r1, r2) -> {
            if (Objects.equals(r1, r2)) {
                return 0;
            } else {
                int startCompare = comparator.compare(r1.start(), r2.start());
                int endCompare = comparator.compare(r1.end(), r2.end());
                return startCompare == 0 ? endCompare : startCompare;
            }
        };
    }

    private void mergeRanges(List<Range<T>> ranges) {
            ListIterator<Range<T>> itr = ranges.listIterator();
            while (itr.hasNext()) {
                Range<T> r1 = itr.next();
                if (itr.hasNext()) {
                    Range<T> r2 = itr.next();
                    if (isOverlapping(r1, r2)) {
                        T maxEnd = getMax(r1.end(), r2.end());
                        Range<T> r3 = new Range<>(r1.start(), maxEnd);
                        itr.remove(); // remove r2
                        itr.previous(); // traverse to r1
                        itr.remove(); // remove r1
                        itr.add(r3);
                    }
                    itr.previous();
                }
            }
    }

   private boolean isOverlapping(Range<T> r1, Range<T> r2) {
            if (Objects.equals(r1, r2)) {
                return true;
            } else {
                if (r1 != null && r2 != null) {
                    boolean compare1 = comparator.compare(r1.start(), r2.start())<=0 && comparator.compare(r1.end(), r2.start()) >=0;
                    boolean compare2 = comparator.compare(r2.start(), r1.start())<=0 && comparator.compare(r2.end(), r1.start()) >=0;
                    return compare1 || compare2;
                }
            }
            return false;
    }

    private T getMax(T t1, T t2){
        return comparator.compare(t1,t2) > 0 ? t1 : t2;
    }
}
