package com.migusdn.EzMacro.Macro;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter @Setter
public class TaskElement {
    private Command command;
    private String target;
    //private String command;
}
