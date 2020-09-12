package com.gtmdtest.platform.testcore.components;

import com.gtmdtest.platform.testcore.components.caseComponents.ProjectMapping;
import com.gtmdtest.platform.testcore.components.caseComponents.TestsMapping;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
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

    void loadDotEnvFile(){}

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

    void loadTestcase(){}

    void loadTestcaseV2(){}

    void loadTestsuites(){}

    void loadTestFile(){}

    void loadFolderContent(){}

    void loadApiFolder(){}

    void locateDebugtalk(){}

    void loadProjrctTests(){}

    static ProjectMapping loadProjectTests(String path, String dotEnvPath){
        ProjectMapping projectMapping = new ProjectMapping();

        return projectMapping;
    }

    static void loadFileContent(TestsMapping testsMapping,String testPath){

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
