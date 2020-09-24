package ru.malov.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//Все обращения после сайта на parcel, будут перенаправлятся на этот котроллер
@RequestMapping("parcel")
public class Parcel {
    private Map<String, String> map1 = new HashMap<>(){{ put("id", "1"); put("text", "first"); }};
    private Map<String, String> map2 = new HashMap<>(){{ put("id", "2"); put("text", "two"); }};
    private List<Map<String, String>> list = new ArrayList<>() {{ add(map1); add(map2); }};

    @GetMapping
    public List<Map<String, String>> list() {
        return list;
    }

    @GetMapping("{id}")
    public Map<String, String> getFirst(
            @PathVariable String id //потому что id передаем в запросе
    ) {
        return list.stream()
                .filter(l -> l.get("id").equals(id))
                .findFirst()
                .orElseThrow();
    }
}
