package com.example.alias.offline.model;

import com.google.gson.*;

import java.lang.reflect.Type;

public class DictionaryDeserializer implements JsonDeserializer<Dictionary> {
    public Dictionary deserialize(JsonElement json, Type type,
                                  JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject object = json.getAsJsonObject();

        Dictionary dictionary = new Dictionary();
        dictionary.setName(object.get("name").getAsString());
        dictionary.setDisclaimer(object.get("disclaimer").getAsString());
        dictionary.setWordsCount(object.get("words_count").getAsInt());

        JsonArray words = object.getAsJsonArray("words");
        for(JsonElement word: words)
            dictionary.addWord(word.getAsString());
        return dictionary;
    }
}
