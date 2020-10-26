package com.migusdn.EzMacro.Macro;

import com.migusdn.EzMacro.Enum.Command;
import com.migusdn.EzMacro.Enum.TargetType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter @Setter
public class TaskElement {
    private Command command;
    private TargetType targetType;
    private String target;
    //private String command;
}
