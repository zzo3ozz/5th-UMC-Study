package umc.study.domain.mission.entity;

import lombok.*;
import umc.study.domain.common.entity.BaseEntity;
import umc.study.domain.store.entity.Store;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    private Integer reward;

    private LocalDate deadline;

    @Column(columnDefinition = "TEXT")
    private String mission_spec;
}
