package com.scyb;

import com.opensymphony.xwork2.Action;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2016/2/2
 * Time:11:22
 */
public class TestAction implements Action{

    @Override
    public String execute() throws Exception {
        System.out.println("action");
        return null;
    }
}
