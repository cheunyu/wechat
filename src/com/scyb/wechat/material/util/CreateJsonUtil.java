package com.scyb.wechat.material.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2016/2/18
 * Time:15:44
 */
public class CreateJsonUtil {

    public void addNewsJson() {
        JSONObject baseJson = new JSONObject();

        JSONArray articles1Array = new JSONArray();

        JSONObject articles1Object = new JSONObject();
        articles1Object.element("title", "新疆番茄块——美味无极限");
        articles1Object.element("title", "新疆番茄块——美味无极限");
        articles1Object.element("title", "新疆番茄块——美味无极限");
        articles1Object.element("title", "新疆番茄块——美味无极限");
        articles1Object.element("title", "新疆番茄块——美味无极限");
        articles1Object.element("title", "新疆番茄块——美味无极限");
        articles1Object.element("title", "新疆番茄块——美味无极限");
    }

    public void imageJson() {

    }
}
