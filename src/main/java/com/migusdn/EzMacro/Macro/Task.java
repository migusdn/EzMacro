package com.migusdn.EzMacro.Macro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Task {
    private String target_url;
    private ArrayList<TaskElement> TaskList;

}
