package com.migusdn.EzMacro.Setting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserSetting {
    private String os;
    private String chromeVersion;
    private String driverPath;
    private String browserType;
}
