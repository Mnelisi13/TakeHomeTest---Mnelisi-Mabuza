package numberrangesummarizer.numberrangessummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
//Author: Mnelisi Mabuza
// Impact.com TakeHomeTest
public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {
    @Override
    public Collection<Integer> collect(String input) {//collect the numbers from input string
        List<Integer> numbers = new ArrayList<>();
        if (input != null && !input.isEmpty()) {
            String[] parts = input.split(",");
            for (String part : parts) {
                numbers.add(Integer.parseInt(part.trim()));
            }
            Collections.sort(numbers); // Ensure the numbers are sorted
        }
        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        List<Integer> numbers = new ArrayList<>(input);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numbers.size(); i++) {
            int start = numbers.get(i);
            // while the numbers increment sequentially it passes
            while (i + 1 < numbers.size() && numbers.get(i + 1) == numbers.get(i) + 1) {
                i++;
            }

            int end = numbers.get(i);//stopping point of range
            if (start == end) {//no range
                result.append(start);
            } else {
                result.append(start).append("-").append(end);
            }

            if (i + 1 < numbers.size()) {
                result.append(", ");
            }
        }

        return result.toString();
    }
}
