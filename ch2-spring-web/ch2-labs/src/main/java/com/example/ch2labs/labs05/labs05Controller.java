package com.example.ch2labs.labs05;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class labs05Controller {

    @GetMapping("/sum-digits")
    public ResponseEntity<?> sumDigits(@RequestParam(required = false) String number) {
        // 1. number 파라미터 누락 확인
        if (number == null || number.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "number 파라미터는 필수입니다."));
        }

        // 2. 정수로 파싱 시도
        int num;
        try {
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return ResponseEntity
                    .status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(Map.of("error", "정수만 입력 가능합니다."));
        }

        // 3. 음수 확인
        if (num < 0) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "음수는 지원하지 않습니다. 양의 정수를 입력해주세요."));
        }

        // 4. 자리수 합 계산
        int sum = 0;
        int temp = num;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        // 5. 정상 응답
        return ResponseEntity.ok(Map.of("message", "각 자리수 합 .. " + sum));
    }
}
