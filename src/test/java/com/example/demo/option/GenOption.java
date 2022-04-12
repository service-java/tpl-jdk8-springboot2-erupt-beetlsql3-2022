package com.example.demo.option;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class GenOption {
    private Boolean needEntity = true;
    private Boolean needMapperAndController = false;
    private Boolean needMenuSQL = false;
    private Boolean needDBDoc = false;
}
