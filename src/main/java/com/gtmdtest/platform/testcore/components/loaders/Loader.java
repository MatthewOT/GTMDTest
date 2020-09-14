package com.gtmdtest.platform.testcore.components.loaders;

import com.alibaba.fastjson.JSONObject;
import com.gtmdtest.platform.testcore.components.Debugtalk;
import com.gtmdtest.platform.testcore.components.caseComponents.*;
import org.apache.commons.io.FileUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Slf4j
public class Loader {

    //////////////////////////////////////////////////////////////////
    //////                                                      //////
    //////             file  module   loader                    //////
    //////                                                      //////
    //////////////////////////////////////////////////////////////////
    /**
     * check testcase format if valid
     * @param filePath casepath
     * @param content case
     * @throws Exception
     */
    static void checkFormat(String filePath,Object content) throws Exception {
        if (content == null){
            log.error("Testcase file content is empty:{{}}",filePath);
            throw new Exception("Testcase file content is empty");
        }

        if (!(content instanceof Map || content instanceof List)){
            log.error("Testcase file content format invalid:{{}}",filePath);
            throw new Exception("Testcase file content format invalid");
        }
    }

    static Object loadJsonFile(File file){
        try {
            String jsonStr = FileUtils.readFileToString(file);
            JSONObject jsonObject = JSONObject.parseObject(jsonStr);
            Map<String,Object> map = jsonObject;
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    void loadYamlFile(){

        //本期不做

    }

    void loadCsvFile(){

        //本期不做

    }

    public static Object loadFile(String filePath){
        File file = new File(filePath);

        String fileSuffix = filePath.substring(filePath.lastIndexOf("."));

        if (file.isDirectory() || (!file.exists())){
            log.error("{{}} does not exist.",filePath);

            try {
                throw new Exception("File does not exist.");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

//        当前只支持json文件的解析加载
        if (!fileSuffix.equals(".json")){
            log.error("Unsupported file format:{{}}",filePath);

            try {
                throw new Exception("Unsupported file formatFile does not exist.");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return loadJsonFile(file);
    }

    static List<String> loadFolderFiles(String path){
        return null;
    }

    static Map<String,Object> loadDotEnvFile(String dotEnvPath){
        return null;
    }

    void locateFile(){}

    //////////////////////////////////////////////////////////////////
    //////                                                      //////
    //////         debugtak  module   loader                    //////
    //////                                                      //////
    //////////////////////////////////////////////////////////////////

    void loadModuleFunctions(){}

    void loadBuiltinFunctions(){}

    void loadDebugtalkFunctions(){}

    //////////////////////////////////////////////////////////////////
    //////                                                      //////
    //////         testcase  module   loader                    //////
    //////                                                      //////
    //////////////////////////////////////////////////////////////////

    void extendWithApiRef(){}

    void extendWithTestcaseRef(){}

    void loadTeststep(){}

    static TestCase loadTestcase(List rawContent){
        return null;
    }

    static TestCase loadTestcaseV2(Map tempContent){
        return null;
    }

    static TestSuite loadTestsuite(Map tempContent){
        TestSuite testSuite = new TestSuite();
        return null;
    }
//  TODO: highest todo: load testpath to content. content could be a api, a testCase or a testSuite
    static Runable loadTestFile(String path){
//        TODO:关于path的空指针处理
        Object rawContent = loadFile(path);
        Runable loadedContent = null;

        if (rawContent instanceof Map){
            Map tempContent = (Map)rawContent;

            if (tempContent.containsKey("request")){
                loadedContent = new Api(tempContent);
            }

            else if (tempContent.containsKey("teststeps")){
                loadedContent = loadTestcaseV2(tempContent);
                ((TestCase) loadedContent).setPath(path);
                ((TestCase) loadedContent).setType("testcase");
            }

            else if (tempContent.containsKey("testcases")){
                loadedContent = loadTestsuite(tempContent);
                ((TestSuite) loadedContent).setPath(path);
                ((TestSuite) loadedContent).setType("testsuite");
            }

        }else if (rawContent instanceof List && ((List) rawContent).size() > 0){
//
            loadedContent = loadTestcase((List)rawContent);
            ((TestCase) loadedContent).setPath(path);
            ((TestCase) loadedContent).setType("testcase");
        } else {
            log.error("Invalid test file format!");
            try {
                throw new Exception("Invalid test file format!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return loadedContent;
    }

    void loadFolderContent(){}

    static Map<String,Object> loadApiFolder(Map<String, Object> env){
        return null;
    }

    static String locateDebugtalk(String path){
        return null;
    }

    void loadProjrctTests(){}

//  TODO:highest todo: load project information for testMapping
//  这里是整个加载器的重点，也是实现的难点，这里需要实现，加载并初始化ProjectMapping里的pwd，env文件，api接口，以及最最重要的辅助函数debugtalk,这是最重要的
    static ProjectMapping loadProjectTests(String path, String dotEnvPath){
        ProjectMapping projectMapping = new ProjectMapping();

        String debugtalkPath = locateDebugtalk(path);

        if (debugtalkPath != null){
//            TODO：获取debugtalk的path作为pwd
//            projectMapping.setPWD(debugtalkPath.getSysPath());

//            TODO:这里需要使用反射，获取debugtalk的class,用来后续使用它的方法，作为辅助函数
            Class cls = Debugtalk.class;
            projectMapping.setFunctions(cls);

        }else {
//
            projectMapping.setPWD(path);
        }

        if (dotEnvPath == null || dotEnvPath.equals("")){
            dotEnvPath = Paths.get(projectMapping.getPWD()).resolve(".env").toString();

        }
//      TODO:这样实现是否合理待考察
        projectMapping.setApi(loadApiFolder(projectMapping.getEnv()));
        projectMapping.setEnv(loadDotEnvFile(dotEnvPath));
        return projectMapping;


    }

    /**
     * 将case中的content拼装至testMapping。淦，不知道为啥这句话的google翻译感觉怪怪的，先写中文
     * @param testsMapping testcase temp information
     * @param testPath case's path
     */
    static void loadFileContent(TestsMapping testsMapping,String testPath){
        Runable loadedContent = loadTestFile(testPath);

        switch (loadedContent.getClass().getSimpleName()){

            case "Api":
                testsMapping.getApis().add((Api) loadedContent);
                break;

            case "TestCase":
                testsMapping.getTestCases().add((TestCase) loadedContent);
                break;

            case "TestSuite":
                testsMapping.getTestSuites().add((TestSuite) loadedContent);
                break;

            default :
                log.error("case is valid.");
                try {
                    throw new Exception("case is valid.");
                } catch (Exception e) {
                    e.printStackTrace();
                }

        }
    }

    /**
     * Loader main entry
     * load testcases from file path, extend and merge with api/testcase definitions.
     *
     * @param path  project path,could be in 2 types:
     *              - absolute/relative file paloadFileContentth
     *              - absolute/relative folder path
     * @param dotEnvPath .env file path
     * @return tests mapping, include project_mapping and testCases.
     *               each testcase is corresponding to a file.
     */
    public static TestsMapping loadTests(String path, String dotEnvPath){
//      TODO:relative相对路径的支持未完成

        File file = new File(path);
        if (!file.exists()){
            log.error("path is not exists : {{}}",path);
        }

        TestsMapping testsMapping = new TestsMapping();

        testsMapping.setProjectMapping(loadProjectTests(path,dotEnvPath));

//      is folder  --->  Traverse all cases under the folder
        if (file.isDirectory()){
            List<String> filesList = loadFolderFiles(path);

//      TODO:关于filesList可能造成的空指针未处理
            for (String testFile : filesList){
                loadFileContent(testsMapping,testFile);
            }

//      is file  --->   load the file's  content
        }else if (file.isFile()){
            loadFileContent(testsMapping,path);
        }

        return testsMapping;
    }
}
