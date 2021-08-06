package study.devmeetingstudy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.devmeetingstudy.common.exception.global.error.exception.SignupDuplicateException;
import study.devmeetingstudy.common.exception.global.error.exception.UserException;
import study.devmeetingstudy.dto.member.MemberResponseDto;
import study.devmeetingstudy.repository.MemberRepository;
import study.devmeetingstudy.util.SecurityUtil;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public MemberResponseDto getMemberInfo(String email) {
        return memberRepository.findByEmail(email)
                .map(MemberResponseDto::of)  // email 확징
                .orElseThrow(() -> new UserException("유저 정보가 없습니다."));
    }

    // 현재 SecurityContext 에 있는 유저 정보 가져오기
    @Transactional(readOnly = true)
    public MemberResponseDto getMyInfo() {
        return memberRepository.findById(SecurityUtil.getCurrentMemberId())
                .map(MemberResponseDto::of)
                .orElseThrow(() -> new UserException("로그인 유저 정보가 없습니다."));
    }
}
