package numberrangesummarizer.numberrangessummarizer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class NumberRangeSummarizerImplTest {

    private NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
    @Test
    public void testCollect() {
        summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> expected = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        Collection<Integer> actual = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        assertEquals(expected, actual);
    }

    @Test
    public void testSummarizeCollection() {
        Collection<Integer> input = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String expected = "1, 3, 6-8, 12-15, 21-24, 31";
        String actual = summarizer.summarizeCollection(input);
        assertEquals(expected, actual);
    }
    @Test
    public void testEmptyInput() {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> numbers = summarizer.collect("");
        String result = summarizer.summarizeCollection(numbers);
        assertEquals("", result);
    }

    @Test
    public void testSingleNumber() {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> numbers = summarizer.collect("5");
        String result = summarizer.summarizeCollection(numbers);
        assertEquals("5", result);
    }

    @Test
    public void testNonConsecutiveNumbers() {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> numbers = summarizer.collect("1, 4, 7, 10");
        String result = summarizer.summarizeCollection(numbers);
        assertEquals("1, 4, 7, 10", result);
    }

    @Test
    public void testMixedNumbers() {//test mixed numbers
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> numbers = summarizer.collect("3, 2, 4, 1, 5");
        String result = summarizer.summarizeCollection(numbers);
        assertEquals("1-5", result);
    }
}