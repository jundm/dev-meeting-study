package study.devmeetingstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import study.devmeetingstudy.domain.study.StudyMember;
import study.devmeetingstudy.domain.study.enums.StudyAuth;

import java.util.List;
import java.util.Optional;

public interface StudyMemberRepository extends JpaRepository<StudyMember, Long> {

    @Query("select sm from StudyMember sm left join fetch sm.member where sm.studyAuth = :studyAuth and sm.study.id = :studyId")
    List<StudyMember> findFirstByStudyIdAndStudyAuth(@Param("studyId") Long studyId, @Param("studyAuth") StudyAuth studyAuth);
}
