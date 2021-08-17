package com.jojoldu.book.spring.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity 클래스들이 BASETIMEENTTIY을 상속할 경우 피드들도 컬럼으로 인식하게 합니다
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity 클래스에 AUditing 기능을 포함시킵니다.
public class BaseTimeEntity {
    @CreatedDate //엔티티가 생성되어 저장될 때 시간을 자동 저장됩니다.
    private LocalDateTime createdDate;

    @LastModifiedDate //LastModifiedDate 조회한 엔티티의 값을 변경할때 시간이 자동 저장됩니다.
    private LocalDateTime modifiedDate;
}
