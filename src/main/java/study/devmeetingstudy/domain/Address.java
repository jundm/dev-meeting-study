package study.devmeetingstudy.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

    @Id @GeneratedValue
    @Column(name = "address_id")
    private Long id;


    private String address_1;
    private String address_2;
    private String address_3;
}
