package br.com.vishquebrou.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class ShowTag extends SimpleTagSupport{
	private String className;
	private String title;
	
	public void setClassName(String className) {
		this.className = className;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void doTag() throws JspException, IOException {
	    JspWriter out = getJspContext().getOut();
	out.print("<h2 class=\" " + className + "\" "+"><b>"+title+"</b></h2>"
			);
	getJspBody().invoke(null);
	}

}
