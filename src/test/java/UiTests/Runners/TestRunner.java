package UiTests.Runners;  // Běžná deklarace balíčku, ve kterém se runner nachází.

import io.cucumber.core.options.Constants;  //Importuje konstanty, které Cucumber používá k pojmenování konfiguračních parametrů (např. GLUE_PROPERTY_NAME, PLUGIN_PROPERTY_NAME apod.).
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;     //Tyto anotace pochází z JUnit Platform Suite API (novinka v JUnit 5), a slouží k nastavení testovací sady (suite).

@Suite        //Říká JUnitu, že se jedná o testovací sadu (suite). Toto je hlavní anotace, bez které se suite nespustí.
@IncludeEngines("cucumber")      //Určuje, který engine má být použit. V tomto případě cucumber, což říká JUnitu, že má spustit testy napsané v Cucumberu.
@SelectClasspathResource("Features")    // Definuje, kde jsou uloženy feature files (scénáře psané v Gherkinu). Features znamená, že složka Features je na classpath (např. src/test/resources/Features).
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME,value = "UiTests/Steps")  // Určuje tzv. glue code – tedy kde se nachází definice kroků (@Given, @When, @Then). Tato hodnota by měla být ve formátu balíčku, takže správně by měla být:
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME,value = "@regression")  // Lomítko (/) je překlep, správný tvar je tečka (.) jako v názvu balíčku v Javě.
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME,value = "false")   //Spouští pouze scénáře označené tagem @regression. Užitečné, pokud máš různé testy označené např. @smoke, @login, @regression atd.
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, html:target/cucumber-report/cucumber.html")   // true = pouze ověří, zda jsou všechny kroky implementované, ale nespustí žádný test.
// false = běžné spuštění testů.
public class TestRunner  {
}


//Tento runner:
//
//    spouští Cucumber testy s JUnit 5,
//
//    hledá feature soubory ve složce Features,
//
//    kroky (step definitions) hledá v balíčku UiTests.Steps,
//
//    spouští pouze scénáře označené tagem @regression,
//
//    generuje pěkný HTML report,
//
//    a opravdu spouští testy (není to jen kontrola implementace).