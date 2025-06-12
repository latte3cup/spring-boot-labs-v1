package com.example.ch2labs.labs06;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class labs06Controller {

    @PostMapping("/longest-word")
    public ResponseEntity<?> getLongestWord(@RequestBody Map<String, Object> body) {
        if (body == null || body.isEmpty()) {
            return ResponseEntity.status(400).body(Map.of("error", "400 Bad Request(요청 바디가 비어있습니다.)"));
        }

        Object wordsObj = body.get("words");
        if (!(wordsObj instanceof List<?> wordsList)) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(Map.of("error", "422 Unprocessable Entity(words는 문자열 리스트여야 합니다.)"));
        }

        if (wordsList.isEmpty()) {
            return ResponseEntity.status(400).body(Map.of("error", "400 Bad Request(words 리스트가 비어있습니다.)"));
        }
        if (wordsList.size() > 5) {
            return ResponseEntity.status(422).body(Map.of("error","422 Unprocessable Entity(리스트 길이가 너무 깁니다.)" ));
        }
        // 리스트 내 타입 체크 및 캐스팅
        List<String> words = wordsList.stream()
                .filter(obj -> obj instanceof String)
                .map(obj -> (String) obj)
                .toList();

        if (words.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(Map.of("error", "words 리스트에 문자열이 없습니다."));
        }

        Optional<String> longestWord = words.stream()
                .max(Comparator.comparingInt(String::length));

        String message = "가장 긴 단어는 '" + longestWord.orElse("") + "'입니다.";

        return ResponseEntity.ok(Map.of("message", message));
    }

}
