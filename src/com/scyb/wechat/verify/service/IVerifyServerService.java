package com.scyb.wechat.verify.service;

import com.scyb.wechat.verify.bo.VerifyServerBo;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2016/2/2
 * Time:13:31
 */
public interface IVerifyServerService {

    public boolean verifyResults(VerifyServerBo vsBo);
}
