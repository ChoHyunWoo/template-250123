package com.example.template.domain.post.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping("/write")
    @ResponseBody
    public String showWrite() {
        return """
                <form method = "post">
                  <input type="text" name="title" placeholder="제목" />
                  <textarea name="content"></textarea>
                  <input type="submit" value="등록" />
                </form>
                """;
    }

    // 브라우저 주소창에 주소 치는 것 ->get
    //form이 보내주는 주소 -> get

    @PostMapping("/write")
    @ResponseBody
    public String doWrite(String title, String content) {

        if(title.isBlank() || title == null){
            return """
                <div>%s</div>
                <form method = "post">
                  <input type="text" name="title" placeholder="제목" />
                  <textarea name="content"></textarea>
                  <input type="submit" value="등록" />
                </form>
                """.formatted("제목을 입력해주세요.");
        }
        if(content.isBlank() || content == null){
            return """
                <div>%s</div>
                <form method = "post">
                  <input type="text" name="title" placeholder="제목" />
                  <textarea name="content"></textarea>
                  <input type="submit" value="등록" />
                </form>
                """.formatted("내용을 입력해주세요.");
        }
        if(title.length() <5){
            return """
                <div>%s</div>
                <form method = "post">
                  <input type="text" name="title" placeholder="제목" />
                  <textarea name="content"></textarea>
                  <input type="submit" value="등록" />
                </form>
                """.formatted("제목 5글자이상.");
        if(content.length() <10){
            return """
                <div>%s</div>
                <form method = "post">
                  <input type="text" name="title" placeholder="제목" />
                  <textarea name="content"></textarea>
                  <input type="submit" value="등록" />
                </form>
                """.formatted("내용 10글자 이상");
        }

        return """
                <h1>게시물 조회</h1>
                <div>%s</div>
                <div>%s</div>
                """.formatted(title, content);
    }
}