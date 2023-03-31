package flightservlet.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JspHelper {
    private static final String JSP_DIR = "/WEB-INF/jsp/%s.jsp";
    public static String getPass(String jspName) {
        return  JSP_DIR.formatted(jspName);
    }
}
