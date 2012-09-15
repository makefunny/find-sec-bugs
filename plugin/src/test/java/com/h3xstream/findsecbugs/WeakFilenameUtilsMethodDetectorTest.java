package com.h3xstream.findsecbugs;

import com.h3xstream.findbugs.test.BaseDetectorTest;
import com.h3xstream.findbugs.test.EasyBugReporter;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class WeakFilenameUtilsMethodDetectorTest extends BaseDetectorTest {

    @Test
    public void detectWeakFilenameUtils() throws Exception {
        //Locate com.h3xstream.findbugs.test code
        String[] files = {
                getClassFilePath("testcode/WeakFilenameUtils")
        };

        //Run the analysis
        EasyBugReporter reporter = spy(new EasyBugReporter());
        analyze(files, reporter);

        for (Integer line : Arrays.asList(17, 20, 23, 26, 29)) {
            verify(reporter).doReportBug(
                    bugDefinition()
                            .bugType("WEAK_FILENAMEUTILS")
                            .inClass("WeakFilenameUtils").inMethod("testPath").atLine(line)
                            .build()
            );
        }
    }
}