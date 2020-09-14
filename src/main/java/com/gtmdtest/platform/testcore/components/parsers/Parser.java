package com.gtmdtest.platform.testcore.components.parsers;

import com.gtmdtest.platform.testcore.components.caseComponents.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 用例解析器
 */
public class Parser {


//              use $$ to escape $ notation
    public static Pattern dolloarRegexCompile = Pattern.compile("\\$\\$");
//             variable notation, e.g. ${var} or $var
    public static Pattern variableRegexCompile = Pattern.compile("\\$\\{(\\w+)\\}|\\$(\\w+)");
//             function notation, e.g. ${func1($var_1, $var_3)}
    public static Pattern functionRegexCompile = Pattern.compile("\\$\\{(\\w+)\\(([\\$\\w\\.\\-/\\s=,]*)\\)\\}");

    /*
    对标parse_string_value，由于java没办法做到python那样动态返回类型，这个部分，只能在上一步依赖方判断，如果需要str转int，再手动转下
     */
//    TODO:这一部分，等待架子成型后需要删除
    void stringToNum(){}

    /*
    检查是不是引用变量$var或者是辅助函数${func()},这里需要思考下，这个参数content用什么方式封装传递
     */
    boolean isVarOrFuncExisi(Object content){return false;}

    List<Object> findAllVariablesByRegex(){return null;}

    Map<Object,Object> findAllFunctionsByRegex(){return null;}

    void parseParameters(){}

    void parseFunctionParameters(){}

    Object getMappingVariable(){return null;}

    Object getMappingFunctions(){return null;}

    /**
     * 将拼装好的case集合，结合ProjectMapping进行解析
     * @param cases 基于suites、cases、apis拼装的cases
     * @param projectMapping suite的工程信息
     * @return 解析好的用例
     */
    List<TestCase> paseSplitedCases(List<TestCase> cases,ProjectMapping projectMapping){
        List<TestCase> parsedCases = new ArrayList<>();

        //TODO:parse  cases  with   projectMapping
        return parsedCases;
    }

    /**
    parse tests and load to parsed testcases

    tests include api, testcases and testsuites.

    Args:
        testsMapping : project info and testcases list.


            {
                "project_mapping": {
                    "PWD": "XXXXX",
                    "functions": {},
                    "variables": {},                        # optional, priority 1
                    "env": {}
                },
                "testsuites": [
                    {   # testsuite data structure
                        "config": {},
                        "testcases": {
                            "testcase1 name": {
                                "variables": {
                                    "uid": 1000
                                },
                                "parameters": {
                                    "uid": [100, 101, 102]
                                },
                                "testcase_def": {
                                    "config": {},
                                    "teststeps": []
                                }
                            },
                            "testcase2 name": {}
                        }
                    }
                ],
                "testcases": [
                    {   # testcase data structure
                        "config": {
                            "name": "desc1",
                            "path": "testcase1_path",
                            "variables": {},                # optional, priority 2
                        },
                        "teststeps": [
                            # test data structure
                            {
                                'name': 'test step desc1',
                                'variables': [],            # optional, priority 3
                                'extract': [],
                                'validate': [],
                                'api_def': {
                                    "variables": {}         # optional, priority 4
                                    'request': {},
                                }
                            },
                            test_dict_2   # another test dict
                        ]
                    },
                    testcase_dict_2     # another testcase dict
                ],
                "api": {
                    "variables": {},
                    "request": {}
                }
            }
     */
    List<TestCase> parseTests(TestsMapping testsMapping){
        List<TestCase> splitedCases = new ArrayList<>();

        List<TestSuite> testSuites = testsMapping.getTestSuites();
        List<TestCase> testCases = testsMapping.getTestCases();
        List<Api> apis = testsMapping.getApis();
//        将suites中的case解析至splitedCases中
        if (testSuites != null){
            for (TestSuite suites:testSuites){
                if (suites != null){
                    for (TestCase tempcase : suites.getTestCases()){
                        splitedCases.add(tempcase);
                    }
                }
            }
        }

//        将cases中的case解析至splitedCases中
        if (testCases != null){
            for (TestCase tempcase : testCases){
                splitedCases.add(tempcase.parse());
            }
        }

//        将suites中的case解析至splitedCases中
        if (apis != null){
            for (Api tempApi : apis){
                splitedCases.add(tempApi.convertToTestcase());
            }
        }

        return splitedCases;
    }

}
