package org.trahim.library.servlets;

import org.trahim.library.objects.LibraryFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet(name = "PdfContent",
        urlPatterns = {"/PdfContent"})
public class PdfContent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/pdf; charset=UTF-8");
        OutputStream out = resp.getOutputStream();
        try {
            long id = Long.valueOf(req.getParameter("id"));
            Boolean save = Boolean.valueOf(req.getParameter("save"));

            LibraryFacade libraryFacade = (LibraryFacade) getServletContext().getAttribute("libraryFacade");

            byte[] content = libraryFacade.getContent(id);
            resp.setContentLength(content.length);
            if (save) {
                String filename = req.getParameter("filename");
                resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8") + ".pdf");
            }
            out.write(content);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            out.close();
        }
    }
}
