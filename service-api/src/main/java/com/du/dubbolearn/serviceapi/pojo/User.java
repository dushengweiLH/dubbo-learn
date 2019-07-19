package com.du.dubbolearn.serviceapi.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author dushengwei@duoshengbu.com
 * @since 2019/7/18
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {
    private static final long serialVersionUID = 1113151993740663573L;
    private Long id;
    private String name;
    private Integer age;
}
