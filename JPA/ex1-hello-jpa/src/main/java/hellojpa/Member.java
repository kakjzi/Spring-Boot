package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;

    @Column(name = "name") //DB- COL NAME
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    /*@Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;*/
    // ==
    private LocalDateTime createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob  //DB에 큰 컨텐츠 삽입 시
    private String description;

    @Transient //매핑제외
    private int temp;

}
