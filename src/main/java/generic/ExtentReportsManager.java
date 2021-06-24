package generic;

import java.io.File;
import java.nio.file.Paths;


import core.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportsManager extends BaseTest2 {

    public static ExtentTest    test;
    public static ExtentReports report;
    public static String 	    nomeprint   		= "";
    public static String 		pathGeneric 		= "";
    public static String 		caminhoExtentReport = "";

    public static String capture(String identificador) {
        pathGeneric = Paths.get(pathSaveEvidence).toString();
        CriarPasta(pathGeneric);
        nomeprint = identificador + ".png";

        try {
            File scrFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            File imagemDestino = new File(Paths.get(pathGeneric, nomeprint).toString());
            String returnPath = imagemDestino.getAbsolutePath();
            FileUtils.copyFile(scrFile, imagemDestino);
            pathGeneric = "";
            nomeprint = "";
            return returnPath;
        } catch (Exception e) {
            File imagemDestino = new File(Paths.get(pathGeneric, nomeprint).toString());
            String returnPath = imagemDestino.getAbsolutePath();
            return returnPath;
        }
    }
}
