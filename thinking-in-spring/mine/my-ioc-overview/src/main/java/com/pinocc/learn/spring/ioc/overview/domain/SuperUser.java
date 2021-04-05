package com.pinocc.learn.spring.ioc.overview.domain;

import com.pinocc.learn.spring.ioc.overview.annotation.Super;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author wu on 2021/4/5
 * @version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Super
public class SuperUser extends User {
    private String address;
}
