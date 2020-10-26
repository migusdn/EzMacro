package com.migusdn.EzMacro.Macro;

import lombok.*;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Task {
    private String target_url;
    private ArrayList<TaskElement> TaskList;

}
