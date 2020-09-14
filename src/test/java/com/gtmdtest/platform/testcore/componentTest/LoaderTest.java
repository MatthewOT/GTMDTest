package com.gtmdtest.platform.testcore.componentTest;

import com.gtmdtest.platform.testcore.components.loaders.Loader;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class LoaderTest {

    @Test
    void loaderTest(){
        String filePath = "/home/matthewot/IdeaProjects/GTMDTest/platform/src/main/resources/case/demo.json";
        String dotEnv = "";
        Loader.loadTests(filePath,dotEnv);
    }
}
