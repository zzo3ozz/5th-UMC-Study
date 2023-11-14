package umc.study.domain.common.entity;

import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity extends BaseTime{
    @Enumerated(EnumType.STRING)
    @Column(name="status", columnDefinition="ENUM('ACTIVE','INACTIVE')")
    protected Status status;
}
