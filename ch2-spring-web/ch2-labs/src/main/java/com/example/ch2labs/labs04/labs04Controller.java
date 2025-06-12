package com.example.ch2labs.labs04;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;


@ResponseBody
@RestController
public class labs04Controller {

    @GetMapping("/rps")
    public Map<String, String> getRandom(@RequestParam String userWeapon) {
        final List<String> choices = Arrays.asList("rock", "paper", "scissors");
        final Random random = new Random();


        if (!choices.contains(userWeapon)) {
        return Map.of("error", "Invalid choice. Use rock, paper, or scissors.");
        }

        String serverWeapon = choices.get(random.nextInt(choices.size()));
        String result = getResult(userWeapon, serverWeapon);

        return Map.of(
            "user", userWeapon,
            "server", serverWeapon,
            "result", result
        );
        }

        private String getResult(String user, String server) {
            if (user.equals(server)) {
                return "draw";
            }
            if ((user.equals("rock") && server.equals("scissors")) ||
                    (user.equals("paper") && server.equals("rock")) ||
                    (user.equals("scissors") && server.equals("paper"))) {
                return "win";
            }
            return "lose";
        }

    }
