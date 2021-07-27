package study.devmeetingstudy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subject{

    @Id @GeneratedValue
    @Column(name = "subject_id")
    private Long id;

    @Column(name = "subject_name", length = 30, nullable = false)
    private String name;

}
