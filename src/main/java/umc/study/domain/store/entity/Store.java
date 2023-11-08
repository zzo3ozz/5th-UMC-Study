package umc.study.domain.store.entity;

import lombok.*;
import umc.study.domain.common.entity.BaseEntity;
import umc.study.domain.common.entity.Region;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(columnDefinition = "VARCHAR(50)")
    private String address;

    private Float score;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();
}
