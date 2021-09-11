package com.epam.tc.hw7.util;

import com.epam.tc.hw7.entities.MetalsColorsModel;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonMetalsColorsParser {

    public static Object[][] parseJsonMetalsColors(String jsonText) throws IOException {

        Type itemsMapType = new TypeToken<Map<String, MetalsColorsModel>>() {}
            .getType();

        Map<String, MetalsColorsModel> mapItemsDes = new Gson().fromJson(jsonText, itemsMapType);
        List<MetalsColorsModel> listOfMetalsColorsModel = new ArrayList(mapItemsDes.values());

        MetalsColorsModel[][] arrayOfObjects = new MetalsColorsModel[listOfMetalsColorsModel.size()][1];
        for (int i = 0; i < listOfMetalsColorsModel.size(); i++) {
            MetalsColorsModel model = listOfMetalsColorsModel.get(i);
            arrayOfObjects[i][0] = model;
        }
        return arrayOfObjects;
    }
}
