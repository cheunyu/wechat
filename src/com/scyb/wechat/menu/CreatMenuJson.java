package com.scyb.wechat.menu;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2016/2/18
 * Time:14:32
 */
public class CreatMenuJson {

    public JSONObject createMenuJson() {
        JSONObject menu1Object = new JSONObject();
        menu1Object.element("name", "天下粮仓");
        JSONObject menu1ArrayOfObject = new JSONObject();
        menu1ArrayOfObject.element("type", "media_id");
        menu1ArrayOfObject.element("name", "美味特辑");
        menu1ArrayOfObject.element("media_id", "美味特辑");
        JSONArray menu1Array = new JSONArray();
        menu1Array.add(0, menu1ArrayOfObject);
        menu1Object.element("sub_button", menu1Array);


        JSONObject menu2Object = new JSONObject();
        menu2Object.element("name", "居家良品");
        JSONObject menu3Object = new JSONObject();
        menu3Object.element("name", "全国特产");

        JSONArray buttonArray = new JSONArray();
        buttonArray.add(0, menu1Object);
        buttonArray.add(1, menu2Object);
        buttonArray.add(2, menu3Object);

        JSONObject matchruleObject = new JSONObject();
        matchruleObject.element("group_id", "2");
        matchruleObject.element("sex", "1");
        matchruleObject.element("country", "中国");
        matchruleObject.element("province", "北京");
        matchruleObject.element("city", "北京");
        matchruleObject.element("client_platform_type", "1");
        matchruleObject.element("language", "zh_CN");

        JSONObject menuObject = new JSONObject();
        menuObject.element("button", buttonArray);
        menuObject.element("matchrule", matchruleObject);

        System.out.println(menuObject);

        return null;
    }

    public static void main(String args[]) {
        CreatMenuJson cmj = new CreatMenuJson();
        cmj.createMenuJson();
    }
}
