package generic;


import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.openqa.selenium.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest2 {

    // Formato Data BR
    public static DateTimeFormatter formatoDataBR = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault());
    public static DateTimeFormatter formatoHoraBR = DateTimeFormatter.ofPattern("HH", Locale.getDefault());
    public static DateTimeFormatter formatoMinuBR = DateTimeFormatter.ofPattern("mm", Locale.getDefault());
    public static DateTimeFormatter formatoSeguBR = DateTimeFormatter.ofPattern("ss", Locale.getDefault());

    public static String pathSaveEvidence =
            Paths.get(System.getProperty("user.dir").toString() + "\\Evidencias_Geradas",
                    "Evidencias-" +
                            formatoDataBR.format(LocalDate.now()) + "-" +
                            formatoHoraBR.format(LocalTime.now()) + "-" +
                            formatoMinuBR.format(LocalTime.now()) + "-" +
                            formatoSeguBR.format(LocalTime.now())).toString();


    public static void CriarPasta(String caminhoPastaCriar) {
        File pasta = new File(caminhoPastaCriar);
        if(!pasta.exists()) {
            pasta.mkdirs();
        }
    }

    public static void gerarPrintScreen (String nomeHTML, String identificador, int resultado, String info) throws WebDriverException {
        if ((ExtentReportsManager.report == null) && (ExtentReportsManager.test == null)) {
            ExtentReportsManager.caminhoExtentReport = Paths.get(pathSaveEvidence, nomeHTML + ".html").toString();
            ExtentReportsManager.report = new ExtentReports(ExtentReportsManager.caminhoExtentReport);
            ExtentReportsManager.test = ExtentReportsManager.report.startTest(identificador);
        } else if ((ExtentReportsManager.report != null) && (ExtentReportsManager.test == null)) {
            ExtentReportsManager.test = ExtentReportsManager.report.startTest(identificador);
        }

        if ((ExtentReportsManager.report != null) && (ExtentReportsManager.test != null)) {
            switch (resultado) {
                case 0:
                    ExtentReportsManager.test.log(LogStatus.PASS, ExtentReportsManager.test.addScreenCapture(ExtentReportsManager.capture(identificador)) + info);
                    break;
                case 1:
                    ExtentReportsManager.test.log(LogStatus.FAIL, ExtentReportsManager.test.addScreenCapture(ExtentReportsManager.capture(identificador)) + info);
                    break;
                case 2:
                    ExtentReportsManager.test.log(LogStatus.INFO, info);
                    break;
            }
            ExtentReportsManager.report.endTest(ExtentReportsManager.test);
            ExtentReportsManager.report.flush();
            ExtentReportsManager.test = null;
        }

    }
}

