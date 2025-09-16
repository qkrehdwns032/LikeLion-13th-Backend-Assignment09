package com.likelion.likelionSwagger.post.api;

import com.likelion.likelionSwagger.common.error.SuccessCode;
import com.likelion.likelionSwagger.common.template.ApiResTemplate;
import com.likelion.likelionSwagger.post.api.dto.request.PostSaveRequestDto;
import com.likelion.likelionSwagger.post.application.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
//@Tag(name = "포스트 API", description = "포스트 관리하는 api")
public class PostController {
    private final PostService postService;

    // 게시물 저장
    @PostMapping("/save")
//    @Operation(summary = "포스트 저장", description = "포스트저장 설명란입니다.")
    public ApiResTemplate<String> postSave(@RequestBody @Valid PostSaveRequestDto postSaveRequestDto, Principal principal) {
        postService.postSave(postSaveRequestDto, principal);
        return ApiResTemplate.successWithNoContent(SuccessCode.POST_SAVE_SUCCESS);
    }



}