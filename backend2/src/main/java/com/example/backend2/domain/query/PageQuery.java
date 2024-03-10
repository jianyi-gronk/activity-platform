package com.example.backend2.domain.query;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class PageQuery implements Serializable {
    @Serial
    private static final long serialVersionUID = -7578169942688325743L;
    /**
     * 页码
     */
    private Integer pageNo;
    /**
     * 页面尺寸
     */
    private Integer pageSize;
}
