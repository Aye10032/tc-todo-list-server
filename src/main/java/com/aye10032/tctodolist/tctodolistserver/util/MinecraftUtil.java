package com.aye10032.tctodolist.tctodolistserver.util;


import com.aye10032.tctodolist.tctodolistserver.data.APIException;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

/**
 * @program: tc-todo-list-server
 * @className: MinecraftUtil
 * @Description: MC相关工具类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/10 上午 11:00
 */
@Slf4j
public class MinecraftUtil {

    public static String getUUID(String player) throws IOException{
        String uuid = "";

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.mojang.com/users/profiles/minecraft/" + player)
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();

        JsonElement result = JsonParser.parseString(Objects.requireNonNull(response.body()).string());
        if (result instanceof JsonNull) {
            log.error("player " + player + " doesn't exist!");
            throw new APIException(5000, "player " + player + " doesn't exist!");
        } else {
            uuid = result.getAsJsonObject().get("id").getAsString();
        }

        return uuid;
    }

}
