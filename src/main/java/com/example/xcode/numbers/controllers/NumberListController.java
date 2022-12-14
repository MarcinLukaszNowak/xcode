package com.example.xcode.numbers.controllers;

import com.example.xcode.numbers.dto.NumberListDto;
import com.example.xcode.numbers.exceptions.EmptyListException;
import com.example.xcode.numbers.services.NumberListService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("numbers")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class NumberListController {

    private final NumberListService numberListService;

    @PostMapping("sort-command")
    public ResponseEntity sortNumber(@RequestBody NumberListDto numberList) {
        if (numberList.getNumbers() == null || numberList.getNumbers().isEmpty()) {
            throw new EmptyListException();
        }

        List<Integer> sortedList = numberListService.sort(numberList);
        JsonArray jsonArray = new JsonArray();
        sortedList.forEach(jsonArray::add);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("numbers", jsonArray);

        return ResponseEntity.ok(jsonObject.toString());
    }

}
