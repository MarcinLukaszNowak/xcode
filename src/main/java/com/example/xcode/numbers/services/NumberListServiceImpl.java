package com.example.xcode.numbers.services;

import com.example.xcode.numbers.dto.NumberListDto;
import com.example.xcode.numbers.commons.SortingOrder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class NumberListServiceImpl implements NumberListService {

    @Override
    public List<Integer> sort(NumberListDto numberList) {
        List<Integer> numbers = numberList.getNumbers();
        if (SortingOrder.ASC.equals(numberList.getOrder())) {
            return numbers.stream()
                    .sorted()
                    .toList();
        } else {
            return numbers.stream()
                    .sorted(Comparator.reverseOrder())
                    .toList();
        }
    }

}
