package com.glasgow.tapp.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 7883206325289667102L;

    private Integer userId;
    private String userName;
    private String password;
    private String salt;
    private Integer level;
    private Integer money;
    private String  userLocation;
    @JsonFormat(locale = "zh",timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @JsonFormat(locale = "zh",timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
