package com.music.MP3.co.domain.model;

import com.music.MP3.co.utils.DateUtils;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class BaseModel implements Serializable {

    @Column(name = "create_date")
    private String createDate;

    @Column(name = "update_date")
    private String updateDate;

    @PrePersist
    public void prePersist() {
        this.createDate = DateUtils.format(new Date());
    }

    @PreUpdate
    public void preUpdate() {
        this.updateDate = DateUtils.format(new Date());
    }
}
