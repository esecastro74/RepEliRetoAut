
import org.junit.Assert;
import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RetoAutApplicationTest {
    private static WebDriver driver;


    @Test
    public  void Iniciar() throws  InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/chromedriver/chromedriver2.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.utest.com/");
        if (driver.findElement(By.className("unauthenticated-nav-bar__sign-up")).isEnabled()){
            driver.findElement(By.className("unauthenticated-nav-bar__sign-up")).click();
            Thread.sleep(4000);
        }
    }


    @Test(dependsOnMethods = {"Iniciar"})
    public  void primerformulario() throws  InterruptedException {

            driver.findElement(By.id("firstName")).sendKeys("Ana");
            driver.findElement(By.id("lastName")).sendKeys("Guzman");
            driver.findElement(By.id("email")).sendKeys("anaguzman15");
            Thread.sleep(1000);
            driver.findElement(By.id("email")).sendKeys("@guzman.com");
            Thread.sleep(500);

            driver.findElement(By.id("birthMonth")).sendKeys("March");
            driver.findElement(By.id("birthDay")).sendKeys("11");
            driver.findElement(By.id("birthYear")).sendKeys("1990");

            driver.findElement(By.xpath("//*[@id=\"languages\"]/div[1]/input")).click();
            Thread.sleep(200);
            driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-0-10\"]/span/div")).click();
            Thread.sleep(200);
            driver.findElement(By.xpath("//*[@id=\"languages\"]/div[1]/input")).click();
            Thread.sleep(200);
            driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-0-34\"]/span/div")).click();
            Thread.sleep(200);


    }

    @Test(dependsOnMethods = {"primerformulario"})
    public  void segundoformulario() throws  InterruptedException {
        //ubicacion
        driver.findElement(By.xpath("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/form/div[2]/a")).click();
        Thread.sleep(800);
        driver.findElement(By.id("city")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "Medellin");
        Thread.sleep(400);
        driver.findElement(By.id("city")).sendKeys(Keys.DOWN);
        Thread.sleep(400);
        driver.findElement(By.id("city")).sendKeys(Keys.ENTER);
        Thread.sleep(400);
        driver.findElement(By.id("zip")).sendKeys("050001");
        Thread.sleep(600);

        //vista3
        driver.findElement(By.xpath("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/form/div[2]/div/a")).click();
        Thread.sleep(600);



    }

    @Test(dependsOnMethods = {"segundoformulario"})
    public  void tercerformulario() throws  InterruptedException {
        //vista4
        driver.findElement(By.xpath("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/div[2]/div/a")).click();
        Thread.sleep(600);


    }

    @Test(dependsOnMethods = {"tercerformulario"})
    public  void cuartoformulario() throws  InterruptedException {
        //password
        driver.findElement(By.id("password")).sendKeys("TcsretoAut1*");
        Thread.sleep(400);

        driver.findElement(By.id("confirmPassword")).sendKeys("TcsretoAut1*");
        Thread.sleep(400);

        driver.findElement(By.xpath("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/form/div[5]/label/span[1]")).click();
        Thread.sleep(400);

        driver.findElement(By.xpath("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/form/div[6]/label/span[1]")).click();
        Thread.sleep(400);

        driver.findElement(By.id("laddaBtn")).click();
        Thread.sleep(60000);


    }

    @Test(dependsOnMethods = {"cuartoformulario"})
    public  void validarregistro() throws  InterruptedException {
        String texto = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div[1]/div/h1")).getText();
        Thread.sleep(1000);
        Assert.assertEquals(texto, "Welcome to the world's largest community of freelance software testers!");
        driver.quit();
    }







}
