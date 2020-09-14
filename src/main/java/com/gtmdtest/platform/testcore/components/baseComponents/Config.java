package com.gtmdtest.platform.testcore.components.baseComponents;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 用例的全局配置项
 * 作用域为整个测试用例
 * "config": {
 *     "name": "testcase description",
 *     "parameters": [
 *         {"user_agent": ["iOS/10.1", "iOS/10.2", "iOS/10.3"]},
 *         {"app_version": "${P(app_version.csv)}"},
 *         {"os_platform": "${get_os_platform()}"}
 *     ],
 *     "variables": [
 *         {"user_agent": "iOS/10.3"},
 *         {"device_sn": "${gen_random_string(15)}"},
 *         {"os_platform": "ios"}
 *     ],
 *     "request": {
 *         "base_url": "http://127.0.0.1:5000",
 *         "headers": {
 *             "Content-Type": "application/json",
 *             "device_sn": "$device_sn"
 *         }
 *     },
 *     "output": [
 *         "token"
 *     ],
 *     "setup_hooks": [],
 *     "teardown_hooks": []
 * }
 */
@Data
@NoArgsConstructor
public class Config implements Serializable {
    private String name;
    private String id;
    private Map<String,Object> variables;
    private Map<String,Object> requestForConfig;
    private List<String> output;
    private List<String> setupHooks;
    private List<String> teardownHooks;


}
