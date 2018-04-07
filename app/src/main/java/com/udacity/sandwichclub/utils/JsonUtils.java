package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject nameObject = jsonObject.getJSONObject("name");
            JSONArray alsoKnownAsJSONArray = nameObject.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsStringList = stringListFromJSONArray(alsoKnownAsJSONArray);
            String mainName = nameObject.getString("mainName");
            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");
            JSONArray ingredientsJSONArray = jsonObject.getJSONArray("ingredients");
            List<String> ingredientsStringList = stringListFromJSONArray(ingredientsJSONArray);
            sandwich.setMainName(mainName);
            sandwich.setAlsoKnownAs(alsoKnownAsStringList);
            sandwich.setPlaceOfOrigin(placeOfOrigin);
            sandwich.setDescription(description);
            sandwich.setImage(image);
            sandwich.setIngredients(ingredientsStringList);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }

    private static List<String> stringListFromJSONArray(JSONArray jsonArray) throws JSONException {
        List<String> stringList = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                stringList.add(jsonArray.getString(i));
            }
        }
        return stringList;
    }
}
