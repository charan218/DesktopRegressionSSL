package utility;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import pageObjects.BaseClass;
import utility.JyperionListener;

//Add listener for pdf report generation
@Listeners(JyperionListener.class)
public class PDFReport extends BaseClass {

                public PDFReport(WebDriver Driver) {
                                super(Driver);
                                // TODO Auto-generated constructor stub
                }

                /**
                * Send email using java
                * 
                 * @param from
                * @param pass
                * @param to
                * @param subject
                * @param body
                * @throws Exception 
                 */
                public static void sendPDFReportByGMail(String from, String pass, InternetAddress[] to, String subject, String body) throws Exception {
                                Properties props = System.getProperties();
                               // String host="smtp.gmail.com";
                                String host = Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("hostname"); 
                              //  props.put("mail.smtp.ssl.trust", "smtp.shoppersstop.com");
                                props.put("mail.smtp.starttls.enable", "true");
                                props.put("mail.smtp.host", host);
                                props.put("mail.smtp.user", from);
                                props.put("mail.smtp.password", pass);
                                props.put("mail.smtp.port", "587");
                                props.put("mail.smtp.auth", "true");
                                

                                Session session = Session.getDefaultInstance(props);
                                MimeMessage message = new MimeMessage(session);

                                try {	        // Set String Builder Variable 
                                				StringBuilder str=new StringBuilder();
                                				str=str.append("Please find the attached PDF report!! \n");
                                				str=str.append("Total Test Cases= " +BaseClass.totalTC +"\n");
                                				str=str.append("Passed Test Cases= " +BaseClass.passedTC +"\n");
                                				str=str.append("Failed Test Cases= " +BaseClass.failedTC +"\n");
                                				str=str.append("Failed Test Cases Reasons = " +BaseClass.tcFailReasons +"\n");
                                				String email=str.toString();
                                                // Set from address
                                                message.setFrom(new InternetAddress(from));
                                                message.addRecipients(Message.RecipientType.TO, to);
                                                // Set subject
                                                message.setSubject(subject);
                                                message.setText(body);

                                                BodyPart objMessageBodyPart = new MimeBodyPart();

                                                objMessageBodyPart.setText(email);
                                               /* objMessageBodyPart.setText("Total Test Cases= " +BaseClass.totalTC +"\n");
                                                objMessageBodyPart.setText("Passed Test Cases= " +BaseClass.passedTC +"\n");
                                                objMessageBodyPart.setText("Failed Test Cases= " +BaseClass.failedTC +"\n");*/
                                                
                                                Multipart multipart = new MimeMultipart();

                                                multipart.addBodyPart(objMessageBodyPart);

                                                objMessageBodyPart = new MimeBodyPart();


                                                
                                                String filename = Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_Source")
                                                                                + "Test.pdf";
                                                
                                                
                                                // Create data source to attach the file in mail
                                                DataSource source = new FileDataSource(filename);

                                                objMessageBodyPart.setDataHandler(new DataHandler(source));
                                                objMessageBodyPart.setFileName("RegressionTest.pdf");

                                                multipart.addBodyPart(objMessageBodyPart);

                                                message.setContent(multipart);
                                                Transport transport = session.getTransport("smtp");
                                                transport.connect(host, from, pass);
 //                                               transport.connect();
                                                transport.sendMessage(message, message.getAllRecipients());
                                                transport.close();
                                } catch (AddressException ae) {
                                                ae.printStackTrace();
                                } catch (MessagingException me) {
                                                me.printStackTrace();
                                } catch (Exception e){
                                                Log.error("Exception in Class PDFReport | Method sendPDFReportByGMail");
                                                e.printStackTrace();
                                }
                }
}
