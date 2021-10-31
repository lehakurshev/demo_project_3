package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
class ApiController {


    /*
    @GetMapping("books")
    public ResponseEntity<String> getText() {
        return ResponseEntity.ok("Hello text!");
    }
     */

    private List<String> lists = new ArrayList<>();

    @DeleteMapping("lists/{index}")
    public void deleteList
            (@PathVariable("index") Integer index) {
        lists.remove((int) index);
    }

    @GetMapping("lists")
    public List<String> getList() {
        return lists;
    }

    @PutMapping("lists/{index}")
    public void updateList(
            @PathVariable("index") Integer i,
            @RequestBody String message) {
        lists.remove((int) i);
        lists.add(i, message);
    }

    @GetMapping("lists/count")
    public Integer getListscount() {
        return (lists.size());
    }

    @DeleteMapping("lists")
    public void deleteallLists() {
        for (int i = 0; i <lists.size(); i++) {
            lists.remove(i+1);
        }
    }

    @GetMapping("lists/{index}")
    public String getList(@PathVariable("index") Integer index) {
        return lists.get(index);
    }


}