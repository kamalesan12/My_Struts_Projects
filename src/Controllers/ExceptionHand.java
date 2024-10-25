package Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Beans.ExceptForm;

public class ExceptionHand extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ExceptForm ex=(ExceptForm) form ;
		
		
		int fn=ex.getFnum();
		int sn=ex.getSnum();
		int result=fn/sn;
		HttpSession session=request.getSession();
		session.setAttribute("res", result);
		System.out.println("request scope :"+request.getAttribute("res"));
		System.out.println("session scope :"+session.getAttribute("res"));
		return mapping.findForward("success");
	}

}
