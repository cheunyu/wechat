package com.scyb.wechat.verify.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.scyb.wechat.verify.bo.VerifyServerBo;
import com.scyb.wechat.verify.service.IVerifyServerService;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2016/2/2
 * Time:11:59
 */
public class VerifyServerAction implements Action, ServletResponseAware, ModelDriven<VerifyServerBo> {

    private HttpServletResponse response;
    private VerifyServerBo vsBo = new VerifyServerBo();
    private IVerifyServerService verifyServerService;

    public VerifyServerBo getVsBo() {
        return vsBo;
    }

    public void setVsBo(VerifyServerBo vsBo) {
        this.vsBo = vsBo;
    }

    public void setVerifyServerService(IVerifyServerService verifyServerService) {
        this.verifyServerService = verifyServerService;
    }

    @Override
    public String execute() throws Exception {
        if (verifyServerService.verifyResults(vsBo)) {
            PrintWriter pw = null;
            pw = response.getWriter();
            pw.write(vsBo.getEchostr());
        }
        return null;
    }

    @Override
    public VerifyServerBo getModel() {
        return vsBo;
    }

    @Override
    public void setServletResponse(javax.servlet.http.HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }
}
