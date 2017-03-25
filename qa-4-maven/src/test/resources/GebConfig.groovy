import io.github.bonigarcia.wdm.ChromeDriverManager
import org.openqa.selenium.chrome.ChromeDriver

driver = {
    ChromeDriverManager.getInstance().setup()
    new ChromeDriver()
}