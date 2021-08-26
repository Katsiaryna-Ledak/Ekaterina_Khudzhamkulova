package com.epam.tc.hw7.dataproviders;

import com.epam.tc.hw7.util.JsonMetalsColorsParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.DataProvider;

public class MetalsColorsDataProvider {

    @DataProvider(name = "metalsColorsObjects")
    public static Object[][] metalsColorsObjects() throws IOException {

        InputStream fileInputStream = MetalsColorsDataProvider
            .class.getResourceAsStream("/json/JDI_ex8_metalsColorsDataSet.json");

        String jsonText = IOUtils.toString(fileInputStream, StandardCharsets.UTF_8.name());

        return JsonMetalsColorsParser.parseJsonMetalsColors(jsonText);
    }
}
