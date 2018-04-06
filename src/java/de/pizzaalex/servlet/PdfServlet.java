

package de.pizzaalex.servlet;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import de.pizzaalex.control.OrderBean;
import de.pizzaalex.model.*;

import java.io.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author AWagner
 */
@WebServlet(name = "Rechnung", urlPatterns = "/generate/Rechnung.pdf")
public class PdfServlet extends HttpServlet {

    /**
     *
     * @param req
     * @param resp
     */
    
    //MyBean sessBean;
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Document document = new Document();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PdfPTable table;
        OrderBean ordBean = null;
        try {
            resp.setContentType("application/pdf");
            //benötigter Zugriff auf die im Sessionscope
            //abgelegte Bean
            HttpSession sess = req.getSession();
            
            if (sess.getAttribute("orders") != null) {
                ordBean = (OrderBean) sess.getAttribute("orders");
                Order ord = ordBean.getOrder();
                PdfWriter.getInstance(document, bos);
                document.open();
                
                Font fc = FontFactory.getFont(FontFactory.TIMES_ROMAN, 24);
                Chunk chunk = new Chunk("Rechung", fc);
                document.add(new Paragraph(chunk));
                document.add(new Paragraph(""));
                
                document.add(new Paragraph("Kundendaten"));
                Customer c = ord.getCus();
                
                document.add(new Paragraph(c.getFirstname() + " " + c.getLastname()));
                document.add(new Paragraph(c.getStreet()));
                document.add(new Paragraph(c.getPostalcode()));
                document.add(new Paragraph(c.getCity()));
                
                table = new PdfPTable(4);
                table.addCell("Pizzaname");
                table.addCell("Anzahl");
                table.addCell("Einzelpreis");
                table.addCell("Summe");
                
                HashMap<Pizza, Integer> pizzas = ord.getPizzas();
                
                for (Pizza p: pizzas.keySet()){
                    table.addCell(p.getName());
                    table.addCell(""+pizzas.get(p));
                    table.addCell(""+p.getPrice());
                    String price = String.format("%.2f", p.getPrice() * pizzas.get(p));
                    table.addCell(price);
                    
                }
                
                document.add(table);
                String total = String.format("Summe: %.2f", ord.getTotal());
                document.add(new Paragraph(total));
                
            } else {
                PdfWriter.getInstance(document, bos);
                document.open();
               
                document.add(new Paragraph("Session abgelaufen  " ));
            }
            
            document.close();
            OutputStream os = resp.getOutputStream();
            bos.writeTo(os);
            os.flush();
            os.close();
            
        } catch (DocumentException ex) {
            Logger.getLogger(PdfServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PdfServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
       // doGet(req, resp);
    }
}
