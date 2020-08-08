package com.testVagrant.endPoints;

import java.util.HashMap;
import java.util.Map;

public class HeaderBuilder {
    Map<String, String> headers;

    public HeaderBuilder(){
        this.headers= new HashMap<>();
    }

    public Map<String, String> withDefault(){
            headers.put("Content-Type", "application/json");
            return headers;
    }
}
