package com.example.consumer.a.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @Author: JiangYuSong
 * @Date: 2021/7/6 15:57
 */

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChaoChaoBean {

    @JsonProperty("coco")
    private String coco;

    @JsonProperty("wife")
    private String wife;
}
