package com;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class CustomTagDemo extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out= getJspContext().getOut();
        out.println("<h3 style='color:red;background-color:yellow;'><b>Hello Sujan ! </b></h3>");
    }

}
