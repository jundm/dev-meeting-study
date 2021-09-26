package study.devmeetingstudy.dto.study;

import io.swagger.annotations.ApiModelProperty;
import study.devmeetingstudy.domain.study.Offline;
import study.devmeetingstudy.domain.study.enums.StudyType;
import study.devmeetingstudy.dto.address.AddressResDto;
import study.devmeetingstudy.dto.subject.SubjectResDto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CreatedOfflineStudyResDto extends CreatedStudyResDto {

    @ApiModelProperty(value = "주소", notes = "주소를 저장 요청 한 뒤 해당 id를 넘겨줍니다.")
    private AddressResDto address;

    @ApiModelProperty(value = "이미지 경로", notes = "해당 스터디 연관된 파일 (현재는 추가 기능 없이 하나의 파일만)")
    private List<StudyFileDto> files;

    public CreatedOfflineStudyResDto(Long id, String title,
                                     int maxMember, LocalDate startDate,
                                     LocalDate endDate, StudyType studyType,
                                     SubjectResDto subject, AddressResDto address,
                                     List<StudyFileDto> files) {
        super(id, title, maxMember, startDate, endDate, studyType, subject, files);
        this.address = address;
        this.files = files;
    }

    public static CreatedOfflineStudyResDto from(Offline offline) {
        return new CreatedOfflineStudyResDto(
                offline.getId(),
                offline.getTitle(),
                offline.getMaxMember(),
                offline.getStartDate(),
                offline.getEndDate(),
                offline.getStudyType(),
                SubjectResDto.from(offline.getSubject()),
                AddressResDto.from(offline.getAddress()),
                offline.getFiles().stream().map(StudyFileDto::from).collect(Collectors.toList())
        );
    }


}
