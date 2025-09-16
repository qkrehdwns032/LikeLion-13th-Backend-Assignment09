package com.likelion.likelionSwagger.member.api;

import com.likelion.likelionSwagger.common.error.SuccessCode;
import com.likelion.likelionSwagger.common.template.ApiResTemplate;
import com.likelion.likelionSwagger.member.api.dto.request.MemberJoinReqDto;
import com.likelion.likelionSwagger.member.api.dto.request.MemberLoginReqDto;
import com.likelion.likelionSwagger.member.api.dto.response.MemberInfoResDto;
import com.likelion.likelionSwagger.member.application.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
//@Tag(name = "멤버 API", description = "멤버 관리하는 api ")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
//    @Operation(summary = "멤버 회원가입", description = "멤버 회원가입 설명란입니다.")
    public ApiResTemplate<String> join(
            @RequestBody @Valid MemberJoinReqDto memberJoinReqDto
    ) {
        memberService.join(memberJoinReqDto);
        return ApiResTemplate.successWithNoContent(SuccessCode.MEMBER_JOIN_SUCCESS);
    }

    @PostMapping("/login")
//    @Operation(summary = "멤버 로그인", description = "멤버 로그인 설명란입니다.")
    public ApiResTemplate<MemberInfoResDto> login(@RequestBody @Valid MemberLoginReqDto memberLoginReqDto) {
        MemberInfoResDto memberInfoResDto = memberService.login(memberLoginReqDto);
        return ApiResTemplate.successResponse(SuccessCode.MEMBER_LOGIN_SUCCESS, memberInfoResDto);
    }




}
